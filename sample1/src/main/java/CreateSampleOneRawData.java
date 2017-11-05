import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;

import java.util.ArrayList;

public class CreateSampleOneRawData {

    private static final String serviceEndpoint = "https://localhost:9443/services/";

    public static void main(String[] args) throws ApiException {
        createTenants();
        createAPIs();
    }

    private static void createAPIs() throws ApiException {

        SampleUtils.createApi("Salary Details API", "1.0.0", "/salaries", new ArrayList<String>(),new ArrayList<String>());
        SampleUtils.createApi("Mobile Stock API", "1.0.0", "/stocks", new ArrayList<String>(),new ArrayList<String>());
        SampleUtils.createApi("Maintenance Task API ", "1.0.0", "/tasks", new ArrayList<String>(),new ArrayList<String>());
        SampleUtils.createApi("Employee Info API", "1.0.0", "/empInfo", new ArrayList<String>(),new ArrayList<String>());
        SampleUtils.createApi("Phone Prices API", "1.0.0", "/mobilePrices", new ArrayList<String>(),new ArrayList<String>());

    }

    private static void createTenants() {
        TenantUtils.createTenant("john", "123123", "dpt.finance.com", " John", "Smith", serviceEndpoint);
        TenantUtils.createTenant("tom", "123123", "dpt.core.com", " Tom", "Smith", serviceEndpoint);
        TenantUtils.createTenant("bob", "123123", "dpt.opt.com", " Bob", "Len", serviceEndpoint);
    }
}