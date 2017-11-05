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

import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.API;

import java.util.ArrayList;

public class CreateSampleOneRawData {

    private static final String serviceEndpoint = "https://localhost:9443/services/";

    public static void main(String[] args) throws ApiException {
        createTenants();
        createAPIs();
    }

    private static void createAPIs() throws ApiException {

        SampleUtils
                .createApi("Salary Details API", "1.0.0", "/salaries", new ArrayList<String>(), new ArrayList<String>(),
                        API.VisibilityEnum.PRIVATE);
        SampleUtils.createApi("Mobile Stock API", "1.0.0", "/stocks", new ArrayList<String>(), new ArrayList<String>(),
                API.VisibilityEnum.PRIVATE);
        SampleUtils
                .createApi("Maintenance Task API ", "1.0.0", "/tasks", new ArrayList<String>(), new ArrayList<String>(),
                        API.VisibilityEnum.PRIVATE);
        SampleUtils
                .createApi("Employee Info API", "1.0.0", "/empInfo", new ArrayList<String>(), new ArrayList<String>(),
                        API.VisibilityEnum.RESTRICTED);
        SampleUtils.createApi("Phone Prices API", "1.0.0", "/mobilePrices", new ArrayList<String>(),
                new ArrayList<String>(), API.VisibilityEnum.PUBLIC);

    }

    private static void createTenants() {
        TenantUtils.createTenant("john", "123123", "dpt.finance.com", " John", "Smith", serviceEndpoint);
        TenantUtils.createTenant("tom", "123123", "dpt.core.com", " Tom", "Smith", serviceEndpoint);
        TenantUtils.createTenant("bob", "123123", "dpt.opt.com", " Bob", "Len", serviceEndpoint);
    }
}