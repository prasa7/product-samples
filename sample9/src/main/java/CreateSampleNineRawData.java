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

import org.wso2.carbon.apimgt.samples.utils.SampleUtils;
import org.wso2.carbon.apimgt.samples.utils.TenantUtils;
import org.wso2.carbon.apimgt.samples.utils.ThrottlingUtils;
import org.wso2.carbon.apimgt.samples.utils.admin.rest.client.model.ThrottleLimit;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.API;

import java.io.IOException;
import java.util.ArrayList;

/**
 * This class is used to populate sample data to represent the sample nine business scenario.
 */
public class CreateSampleNineRawData {

    private static final String hostname = "localhost";
    private static final String port = "9443";
    private static final String serviceEndpoint = "https://" + hostname + ":" + port + "/services/";

    /**
     * This main method will be called when running sample nine.
     *
     * @throws ApiException throws if an exception is thrown when API creation.
     * @throws IOException  throws when if an error occurred when reading the api definition file.
     */
    public static void main(String[] args)
            throws ApiException, IOException, org.wso2.carbon.apimgt.samples.utils.admin.rest.client.ApiException,
            InterruptedException {

        // Create a tenant
        TenantUtils.createTenant("john", "123123", "finance.abc.com", " John", "Smith", serviceEndpoint);

        // Create advance throttle policies for super tenants.
        ThrottlingUtils
                .addAdvanceThrottlePolicyForTenants("5KPerMin", "5KPerMin", "Allows 100000 requests per minute",
                        "min", 1, 100000L, ThrottleLimit.TypeEnum.REQUESTCOUNTLIMIT, 0, null, "finance.abc.com", "john",
                        "123123");

        String apiIdOne = SampleUtils.createApiForTenant("Salary_details_API", "1.0.0", "/t/finance.abc.com/stocks",
                API.VisibilityEnum.PUBLIC, new ArrayList<>(), new ArrayList<>(),
                API.SubscriptionAvailabilityEnum.CURRENT_TENANT, hostname, port, new ArrayList<>(), "finance.abc.com",
                "john", "123123");

        SampleUtils.publishAPI(apiIdOne, "finance.abc.com", "john", "123123");
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

    }

}