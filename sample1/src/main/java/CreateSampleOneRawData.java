import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;

public class CreateSampleOneRawData {

    private static final String serviceEndpoint = "https://localhost:9443/services/";

    public static void main(String[] args) throws ApiException {
        createTenants();
        createAPI();
    }

    private static void createAPI() throws ApiException {

        String apiName = "test";
        String apiVersion = "1.1.1";
        String apiContext = "/api";
        //        SampleUtils.createApi(apiName, apiVersion, apiContext);
    }

    private static void createTenants() {
        TenantUtils.createTenant("john", "123123", "dpt.finance.com", " John", "Smith", serviceEndpoint);
        TenantUtils.createTenant("tom", "123123", "dpt.core.com", " Tom", "Smith", serviceEndpoint);
        TenantUtils.createTenant("bob", "123123", "dpt.opt.com", " Bob", "Len", serviceEndpoint);
    }
}