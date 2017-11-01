/*
 * WSO2 API Manager - Store
 * This specifies a **RESTful API** for WSO2 **API Manager** - Store.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.1.66/components/apimgt/org.wso2.carbon.apimgt.rest.api.store/src/main/resources/store-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: 0.11.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.carbon.apimgt.samples.utils.store.rest.client.api;

import org.wso2.carbon.apimgt.samples.utils.store.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.model.Error;
import org.wso2.carbon.apimgt.samples.utils.store.rest.client.model.Subscription;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for SubscriptionMultitpleApi
 */
@Ignore
public class SubscriptionMultitpleApiTest {

    private final SubscriptionMultitpleApi api = new SubscriptionMultitpleApi();

    
    /**
     * Add new subscriptions 
     *
     * This operation can be used to add a new subscriptions providing the ids of the APIs and the applications. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void subscriptionsMultiplePostTest() throws ApiException {
        List<Subscription> body = null;
        String contentType = null;
        Subscription response = api.subscriptionsMultiplePost(body, contentType);

        // TODO: test validations
    }
    
}
