import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.api.APICollectionApi;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.API;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.APIBusinessInformation;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.APICorsConfiguration;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Sequence;

import java.util.ArrayList;
import java.util.List;

public class SampleUtils {

    public static String createApi(String apiName, String version, String context, ArrayList<String> visibleRoles,
            ArrayList<String> visibleTenants, API.VisibilityEnum apiVisibility) throws ApiException {

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
        body.setTags(new ArrayList<String>());
        body.setVisibleRoles(visibleRoles);
        body.setVisibleTenants(visibleTenants);
        body.setSequences(new ArrayList<Sequence>());
        body.setBusinessInformation(new APIBusinessInformation());
        body.setCorsConfiguration(new APICorsConfiguration());
        String endpointConfig = "{\"production_endpoints\":{\"url\":\"https://localhost:9443/am/sample/pizzashack/v1/api/\",\"config\":null},\"sandbox_endpoints\":{\"url\":\"https://localhost:9443/am/sample/pizzashack/v1/api/\",\"config\":null},\"endpoint_type\":\"http\"}";
        body.setEndpointConfig(endpointConfig);
        body.setApiDefinition(
                "{\"paths\":{\"/order\":{\"post\":{\"x-auth-type\":\"Application & Application User\",\"x-throttling-ti"
                        + "er\":\"Unlimited\",\"description\":\"Create a new Order\",\"parameters\":[{\"schema\":{\"$re"
                        + "f\":\"#/definitions/Order\"},\"description\":\"Order object that needs to be added\",\"name"
                        + "\":\"body\",\"required\":true,\"in\":\"body\"}],\"responses\":{\"201\":{\"headers\":{\""
                        + "Location\":{\"description\":\"The URL of the newly created resource.\",\"type\":\"string\"}}"
                        + ",\"schema\":{\"$ref\":\"#/definitions/Order\"},\"description\":\"Created.\"}}}},\"/menu\":{"
                        + "\"get\":{\"x-auth-type\":\"Application & Application User\",\"x-throttling-tier\":\""
                        + "Unlimited\",\"description\":\"Return a list of available menu items\",\"parameters\":[],\""
                        + "responses\":{\"200\":{\"headers\":{},\"schema\":{\"title\":\"Menu\",\"properties\":{\"list\""
                        + ":{\"items\":{\"$ref\":\"#/definitions/MenuItem\"},\"type\":\"array\"}},\"type\":\"object\"},"
                        + "\"description\":\"OK.\"}}}}},\"schemes\":[\"https\"],\"produces\":[\"application/json\"],\""
                        + "swagger\":\"2.0\",\"definitions\":{\"MenuItem\":{\"title\":\"Pizza menu Item\",\"properties"
                        + "\":{\"price\":{\"type\":\"string\"},\"description\":{\"type\":\"string\"},\"name\":{\"type\""
                        + ":\"string\"},\"image\":{\"type\":\"string\"}},\"required\":[\"name\"]},\"Order\":{\"title\":"
                        + "\"Pizza Order\",\"properties\":{\"customerName\":{\"type\":\"string\"},\"delivered\":{\"type"
                        + "\":\"boolean\"},\"address\":{\"type\":\"string\"},\"pizzaType\":{\"type\":\"string\"},\""
                        + "creditCardNumber\":{\"type\":\"string\"},\"quantity\":{\"type\":\"number\"},\"orderId\":{\""
                        + "type\":\"integer\"}},\"required\":[\"orderId\"]}},\"consumes\":[\"application/json\"],\"info"
                        + "\":{\"title\":\"PizzaShackAPI\",\"description\":\"This document describe a RESTFul API for "
                        + "Pizza Shack online pizza delivery store.\\n\",\"license\":{\"name\":\"Apache 2.0\",\"url\":\""
                        + "http://www.apache.org/licenses/LICENSE-2.0.html\"},\"contact\":{\"email\":\""
                        + "architecture@pizzashack.com\",\"name\":\"John Doe\",\"url\":\"http://www.pizzashack.com\"},\""
                        + "version\":\"1.0.0\"}}");
        List<String> tierList = new ArrayList<String>();
        tierList.add("Unlimited");
        body.setTiers(tierList);
        API response = api.apisPost(body, "application/json");
        String apiID = response.getId();
        return apiID;
    }

}
