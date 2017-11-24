/*
 * Copyright (c) 2017, WSO2 Inc. (http://wso2.com) All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.apache.commons.lang.StringUtils;
import org.wso2.carbon.apimgt.samples.utils.Constants;
import org.wso2.carbon.apimgt.samples.utils.HTTPSClientUtils;
import org.wso2.carbon.apimgt.samples.utils.SampleUtils;
import org.wso2.carbon.apimgt.samples.utils.TenantUtils;
import org.wso2.carbon.apimgt.samples.utils.ThrottlingUtils;
import org.wso2.carbon.apimgt.samples.utils.UserManagementUtils;
import org.wso2.carbon.apimgt.samples.utils.admin.rest.client.model.ThrottleLimit;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.API;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.model.ApplicationKey;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.model.ApplicationKeyGenerateRequest;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.model.Subscription;
import org.wso2.carbon.user.mgt.stub.UserAdminUserAdminException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * This class is used to populate sample data to represent the sample nine business scenario.
 */
public class CreateSampleNineRawData {

    private static final String hostname = "localhost";
    private static final String port = "9443";
    private static final String gatewayPort = "8243";
    private static final String gatewayHost = "localhost";
    private static final String serviceEndpoint = "https://" + hostname + ":" + port + "/services/";
    private static final String getGatewayEndpoint = "https://" + gatewayHost + ":" + gatewayPort;

    /**
     * This main method will be called when running sample nine.
     *
     * @throws ApiException throws if an exception is thrown when API creation.
     * @throws IOException  throws when if an error occurred when reading the api definition file.
     */
    public static void main(String[] args)
            throws ApiException, IOException, org.wso2.carbon.apimgt.samples.utils.admin.rest.client.ApiException,
            InterruptedException, UserAdminUserAdminException,
            org.wso2.carbon.apimgt.samples.utils.store.rest.client.ApiException {

        if (StringUtils.isEmpty(System.getProperty(Constants.JAVAX_NET_SSL_TRUST_STORE))) {
            System.setProperty(Constants.JAVAX_NET_SSL_TRUST_STORE,
                    UserManagementUtils.class.getClassLoader().getResource(Constants.CLIENT_TRUSTORE_JKS).getPath());
        }
        if (StringUtils.isEmpty(System.getProperty(Constants.JAVAX_NET_SSL_TRUST_STORE_PASSWORD))) {
            System.setProperty(Constants.JAVAX_NET_SSL_TRUST_STORE_PASSWORD, Constants.WSO2_CARBON);
        }
        if (StringUtils.isEmpty(System.getProperty(Constants.JAVAX_NET_SSL_TRUST_STORE_TYPE))) {
            System.setProperty(Constants.JAVAX_NET_SSL_TRUST_STORE_TYPE, Constants.JKS);
        }

        String tenantDomain = "finance.abc.com";
        String tenantAdminUsername = "John";
        String tenantAdminPassword = "123123";

        // Create a new user
        UserManagementUtils
                .addUser("tom", "123123", serviceEndpoint, new String[] { "Internal/subscriber" }, "admin", "admin");

        // Create a tenant
        TenantUtils.createTenant(tenantAdminUsername, tenantAdminPassword, tenantDomain, tenantAdminUsername, "Smith",
                serviceEndpoint);

        // Create advance throttle policies for super tenants.
        ThrottlingUtils
                .addAdvanceThrottlePolicyForTenants("5KPerMin", "5KPerMin", "Allows 5000 requests per minute", "min", 1,
                        100000L, ThrottleLimit.TypeEnum.REQUESTCOUNTLIMIT, 0, null, tenantDomain, tenantAdminUsername,
                        tenantAdminPassword);

        // Create advance throttle policies for super tenants.
        ThrottlingUtils
                .addAdvanceThrottlePolicy("5KPerMin", "5KPerMin", "Allows 5000 requests per minute", "min", 1, 100000L,
                        ThrottleLimit.TypeEnum.REQUESTCOUNTLIMIT, 0, null);
        String apiIdOne = SampleUtils
                .createApiForTenant("Salary_details_API", "1.0.0", "/t/" + tenantDomain + "/stocks",
                        API.VisibilityEnum.PUBLIC, new ArrayList<>(), new ArrayList<>(),
                        API.SubscriptionAvailabilityEnum.CURRENT_TENANT, hostname, port, new ArrayList<>(),
                        tenantDomain, tenantAdminUsername, tenantAdminPassword);

        SampleUtils.publishAPI(apiIdOne, tenantDomain, tenantAdminUsername, tenantAdminPassword);

        // Create advance throttle policies for super tenants.
        ThrottlingUtils
                .addAdvanceThrottlePolicy("100KPerMin", "100KPerMin", "Allows 100000 requests per minute", "min", 1,
                        100000L, ThrottleLimit.TypeEnum.REQUESTCOUNTLIMIT, 0, null);

        ThrottlingUtils
                .addAdvanceThrottlePolicy("100KKBPerMin", "100KKBPerMin", "Allows 100000 kilo bytes per minute", "min",
                        1, 0, ThrottleLimit.TypeEnum.BANDWIDTHLIMIT, 100000L, "KB");
        // Create the API.
        String apiIdTwo = SampleUtils
                .createApi("Mobile_stock_API", "1.0.0", "/stocks", new ArrayList<>(), new ArrayList<>(),
                        API.SubscriptionAvailabilityEnum.CURRENT_TENANT, hostname, port, new ArrayList<>());
        // Publish the API.
        SampleUtils.publishAPI(apiIdTwo);
        System.out.println("Waiting two seconds for API to be deployed to the gateway");
        Thread.sleep(2000);

        // Create Application
        String applicationIdOne = SampleUtils
                .createApplication("Application_one", "This a new application created", "Unlimited");

        // Create grant types
        ArrayList<String> grantTypes = new ArrayList<>();
        grantTypes.add("refresh_token");
        grantTypes.add("urn:ietf:params:oauth:grant-type:saml2-bearer");
        grantTypes.add("password");
        grantTypes.add("client_credentials");
        grantTypes.add("iwa:ntlm");

        // Create allow roles
        ArrayList<String> allowedDomain = new ArrayList<>();
        allowedDomain.add("ALL");

        // Generate Keys for the application one
        ApplicationKey applicationKey = SampleUtils
                .generateKeys(applicationIdOne, "7200", null, ApplicationKeyGenerateRequest.KeyTypeEnum.PRODUCTION,
                        new ArrayList<>(), allowedDomain, grantTypes);
        String accessToken = applicationKey.getToken().getAccessToken();

        // Create subscription for application one
        SampleUtils.createSubscription(apiIdTwo, applicationIdOne, "Unlimited", Subscription.StatusEnum.UNBLOCKED);

        Map<String, String> requestHeadersOne = new HashMap<>();
        requestHeadersOne.put("Authorization", "Bearer " + accessToken);

        // Invoke the API for 20 times with applicationone
        for (int i = 1; i <= 20; i++) {
            HTTPSClientUtils.doGet(getGatewayEndpoint + "/stocks/1.0.0/stock/1", requestHeadersOne);
            System.out.println(i);
        }

        // Create Application two
        String applicationIdTwo = SampleUtils
                .createApplication("Application_two", "This a new application created", "Unlimited");

        // Generate Keys for the application two
        ApplicationKey applicationKeyTwo = SampleUtils
                .generateKeys(applicationIdTwo, "7200", null, ApplicationKeyGenerateRequest.KeyTypeEnum.PRODUCTION,
                        new ArrayList<>(), allowedDomain, grantTypes);
        String accessTokenTwo = applicationKeyTwo.getToken().getAccessToken();

        // Create subscription for application one
        SampleUtils.createSubscription(apiIdTwo, applicationIdTwo, "Unlimited", Subscription.StatusEnum.UNBLOCKED);

        Map<String, String> requestHeadersTwo = new HashMap<>();
        requestHeadersOne.put("Authorization", "Bearer " + accessTokenTwo);

        // Invoke the API for 20 times with application Two
        for (int i = 1; i <= 20; i++) {
            HTTPSClientUtils.doGet(getGatewayEndpoint + "/stocks/1.0.0/stock/1", requestHeadersTwo);
            System.out.println(i);
        }
    }

}