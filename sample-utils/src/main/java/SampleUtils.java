import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.api.APICollectionApi;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.API;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.APIBusinessInformation;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.APICorsConfiguration;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Sequence;

import java.util.ArrayList;

public class SampleUtils {

    public static String createApi(String apiName, String version, String context) throws ApiException {

        APICollectionApi api = new APICollectionApi();
        API body = new API();

        api.getApiClient().setBasePath("https://127.0.0.1:9443/api/am/publisher/v0.11/apis");

        body.setName(apiName);
        body.setContext(context);
        body.setVersion(version);
        body.setDescription("This is the api description");
        body.setProvider("admin");
        body.setTransport(new ArrayList<String>() {{
            add("http");
        }});
        body.setCacheTimeout(100);
        body.setGatewayEnvironments("Production and Sandbox");
        body.setVisibility(API.VisibilityEnum.PUBLIC);
        body.setTags(new ArrayList<String>());
        body.setVisibleRoles(new ArrayList<String>());
        body.setVisibleTenants(new ArrayList<String>());
        body.setSequences(new ArrayList<Sequence>());
        body.setBusinessInformation(new APIBusinessInformation());
        body.setCorsConfiguration(new APICorsConfiguration());
        API response = api.apisPost(body, "application/json");
        String apiID = response.getId();
        return apiID;
    }


}
