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
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.API;

import java.io.IOException;
import java.util.ArrayList;

/**
 *
 */
public class CreateSampleOneRawData {

    private static final String hostname = "localhost";
    private static final String port = "9443";
    private static final String serviceEndpoint = "https://" + hostname + ":" + port + "/services/";

    public static void main(String[] args) throws ApiException, IOException {
        createTenants();
        createAPIs();
    }

    /**
     *
     * @throws ApiException
     */
    private static void createAPIs() throws ApiException, IOException {

        ArrayList<String> apiOneVisibleTenants = new ArrayList<String>();
        apiOneVisibleTenants.add("finance.abc.com");
        ArrayList<String> apiOneTags = new ArrayList<String>();
        apiOneTags.add("Finance");
        SampleUtils.createApi("Salary_details_API", "1.0.0", "/salaries", new ArrayList<>(), apiOneVisibleTenants,
                API.SubscriptionAvailabilityEnum.SPECIFIC_TENANTS, hostname, port, apiOneTags);

        ArrayList<String> apiTwoVisibleTenants = new ArrayList<String>();
        apiOneVisibleTenants.add("core.abc.com");
        ArrayList<String> apiTwoTags = new ArrayList<String>();
        apiTwoTags.add("stock");
        SampleUtils.createApi("Mobile_stock_API", "1.0.0", "/stocks", new ArrayList<>(), apiTwoVisibleTenants,
                API.SubscriptionAvailabilityEnum.SPECIFIC_TENANTS, hostname, port, apiTwoTags);

        ArrayList<String> apiThreeVisibleTenants = new ArrayList<String>();
        apiOneVisibleTenants.add("operations.abc.com");
        ArrayList<String> apiThreeTags = new ArrayList<String>();
        apiThreeTags.add("maintenance");
        SampleUtils.createApi("Maintenance_ask_API", "1.0.0", "/tasks", new ArrayList<>(), apiThreeVisibleTenants,
                API.SubscriptionAvailabilityEnum.SPECIFIC_TENANTS, hostname, port, apiThreeTags);

        ArrayList<String> apiFourVisibleTenants = new ArrayList<String>();
        apiOneVisibleTenants.add("finance.abc.com");
        apiOneVisibleTenants.add("core.abc.com");
        ArrayList<String> apiFourTags = new ArrayList<String>();
        apiFourTags.add("employee");
        SampleUtils.createApi("Employee_info_API", "1.0.0", "/empInfo", new ArrayList<String>(), apiFourVisibleTenants,
                API.SubscriptionAvailabilityEnum.SPECIFIC_TENANTS, hostname, port, apiFourTags);
        ArrayList<String> apiFiveTags = new ArrayList<String>();
        apiFiveTags.add("price");
        SampleUtils.createApi("Phone_prices_API", "1.0.0", "/mobilePrices", new ArrayList<String>(),
                new ArrayList<String>(), API.SubscriptionAvailabilityEnum.SPECIFIC_TENANTS, hostname, port,
                apiFiveTags);

    }

    /**
     *
     */
    private static void createTenants() {
        TenantUtils.createTenant("john", "123123", "finance.abc.com", " John", "Smith", serviceEndpoint);
        TenantUtils.createTenant("tom", "123123", "core.abc.com", " Tom", "Smith", serviceEndpoint);
        TenantUtils.createTenant("bob", "123123", "operations.abc.com", " Bob", "Len", serviceEndpoint);
    }
}