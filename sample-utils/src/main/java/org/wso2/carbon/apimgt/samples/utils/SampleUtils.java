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

package org.wso2.carbon.apimgt.samples.utils;

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

/**
 *
 */
public class SampleUtils {

    private static String apiDefinition = null;

    /**
     *
     * @param apiName
     * @param version
     * @param context
     * @param visibleRoles
     * @param visibleTenants
     * @param subscriptionAvailabilityEnum
     * @param hostname
     * @param port
     * @return
     * @throws ApiException
     */
    public static String createApi(String apiName, String version, String context, ArrayList<String> visibleRoles,
            ArrayList<String> visibleTenants, API.SubscriptionAvailabilityEnum subscriptionAvailabilityEnum,
            String hostname, String port, ArrayList<String> tags) throws ApiException {

        APICollectionApi api = new APICollectionApi();
        API body = new API();

        body.setName(apiName);
        body.setContext(context);
        body.setVersion(version);
        body.setVisibility(API.VisibilityEnum.PUBLIC);
        body.setDescription(Constants.API_DESCRIPTION);
        body.setProvider(Constants.PROVIDER_ADMIN);
        body.setTransport(new ArrayList<String>() {{
            add(Constants.PROTOCOL_HTTP);
        }});
        body.isDefaultVersion(false);
        body.setCacheTimeout(100);
        body.setGatewayEnvironments(Constants.GATEWAY_ENVIRONMENTS);
        body.setSubscriptionAvailability(subscriptionAvailabilityEnum);
        body.setVisibleRoles(visibleRoles);
        body.setSubscriptionAvailableTenants(visibleTenants);
        body.setSequences(new ArrayList<>());
        body.setBusinessInformation(new APIBusinessInformation());
        body.setCorsConfiguration(new APICorsConfiguration());
        body.setTags(tags);
        String endpointConfig = "{\"production_endpoints\":{\"url\":\"https://" + hostname + ":" + port
                + "/am/sample/pizzashack/v1/api/\",\"config\":null},\"sandbox_endpoints\":"
                + "{\"url\":\"https://localhost:9443/am/sample/pizzashack/v1/api/\",\"config\":null},"
                + "\"endpoint_type\":\"http\"}";

        body.setEndpointConfig(endpointConfig);
        try {
            body.setApiDefinition(getApiDefinition());
        } catch (IOException e) {
            throw new ApiException("Could not read API definition file");
        }
        List<String> tierList = new ArrayList<>();
        tierList.add(Constants.TIERS_UNLIMITED);
        body.setTiers(tierList);
        API response = api.apisPost(body, Constants.APPLICATION_JSON);
        return response.getId();
    }

    /**
     *
     * @return
     * @throws IOException
     */
    private static String getApiDefinition() throws IOException {
        if (apiDefinition == null) {
            apiDefinition = IOUtils.toString(
                    SampleUtils.class.getClassLoader().getResourceAsStream(Constants.API_DEFINITION_JSON_FILE),
                    StandardCharsets.UTF_8.name());
        }

        return apiDefinition;
    }

}
