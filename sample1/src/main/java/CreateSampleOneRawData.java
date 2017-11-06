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
        apiOneVisibleTenants.add("dpt.finance.com");
        SampleUtils.createApi("Salary Details API", "1.0.0", "/salaries", new ArrayList<String>(), apiOneVisibleTenants,
                API.VisibilityEnum.PRIVATE, hostname, port);

        ArrayList<String> apiTwoVisibleTenants = new ArrayList<String>();
        apiOneVisibleTenants.add("dpt.core.com");
        SampleUtils.createApi("Mobile Stock API", "1.0.0", "/stocks", new ArrayList<String>(), apiTwoVisibleTenants,
                API.VisibilityEnum.PRIVATE, hostname, port);

        ArrayList<String> apiThreeVisibleTenants = new ArrayList<String>();
        apiOneVisibleTenants.add("dpt.opt.com");
        SampleUtils
                .createApi("Maintenance Task API ", "1.0.0", "/tasks", new ArrayList<String>(), apiThreeVisibleTenants,
                        API.VisibilityEnum.PRIVATE, hostname, port);

        ArrayList<String> apiFourVisibleTenants = new ArrayList<String>();
        apiOneVisibleTenants.add("dpt.finance.com");
        apiOneVisibleTenants.add("dpt.core.com");
        SampleUtils.createApi("Employee Info API", "1.0.0", "/empInfo", new ArrayList<String>(), apiFourVisibleTenants,
                API.VisibilityEnum.PUBLIC, hostname, port);

        SampleUtils.createApi("Phone Prices API", "1.0.0", "/mobilePrices", new ArrayList<String>(),
                new ArrayList<String>(), API.VisibilityEnum.PUBLIC, hostname, port);

    }

    /**
     *
     */
    private static void createTenants() {
        TenantUtils.createTenant("john", "123123", "dpt.finance.com", " John", "Smith", serviceEndpoint);
        TenantUtils.createTenant("tom", "123123", "dpt.core.com", " Tom", "Smith", serviceEndpoint);
        TenantUtils.createTenant("bob", "123123", "dpt.opt.com", " Bob", "Len", serviceEndpoint);
    }
}