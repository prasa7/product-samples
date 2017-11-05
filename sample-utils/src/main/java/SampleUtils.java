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

import org.apache.commons.io.IOUtils;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.api.APICollectionApi;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.API;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.APIBusinessInformation;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.APICorsConfiguration;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class SampleUtils {

    private static String apiDefinition = null;

    public static String createApi(String apiName, String version, String context, ArrayList<String> visibleRoles,
            ArrayList<String> visibleTenants, API.VisibilityEnum apiVisibility) throws ApiException, IOException {

        APICollectionApi api = new APICollectionApi();
        API body = new API();

        body.setName(apiName);
        body.setContext(context);
        body.setVersion(version);
        body.setDescription("This is the api description");
        body.setProvider("admin");
        body.setTransport(new ArrayList<String>() {{
            add("http");
        }});
        body.isDefaultVersion(false);
        body.setCacheTimeout(100);
        body.setGatewayEnvironments("Production and Sandbox");
        body.setVisibility(apiVisibility);
        body.setTags(new ArrayList<>());
        body.setVisibleRoles(visibleRoles);
        body.setVisibleTenants(visibleTenants);
        body.setSequences(new ArrayList<>());
        body.setBusinessInformation(new APIBusinessInformation());
        body.setCorsConfiguration(new APICorsConfiguration());
        String endpointConfig = "{\"production_endpoints\":{\"url\":\"https://localhost:9443/am/sample/pizzashack/v1/api/\",\"config\":null},\"sandbox_endpoints\":{\"url\":\"https://localhost:9443/am/sample/pizzashack/v1/api/\",\"config\":null},\"endpoint_type\":\"http\"}";
        body.setEndpointConfig(endpointConfig);
        body.setApiDefinition(getApiDefinition());
        List<String> tierList = new ArrayList<>();
        tierList.add("Unlimited");
        body.setTiers(tierList);
        API response = api.apisPost(body, "application/json");
        return response.getId();
    }

    private static String getApiDefinition() throws IOException {
        if (apiDefinition == null) {
            apiDefinition = IOUtils.toString(SampleUtils.class.getResourceAsStream("api-definition.json"), StandardCharsets.UTF_8.name());
        }

        return apiDefinition;
    }

}
