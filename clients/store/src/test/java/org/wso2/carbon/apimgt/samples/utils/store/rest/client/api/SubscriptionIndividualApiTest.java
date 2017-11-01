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
 * API tests for SubscriptionIndividualApi
 */
@Ignore
public class SubscriptionIndividualApiTest {

    private final SubscriptionIndividualApi api = new SubscriptionIndividualApi();

    
    /**
     * Add a new subscription 
     *
     * This operation can be used to add a new subscription providing the id of the API and the application. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void subscriptionsPostTest() throws ApiException {
        Subscription body = null;
        String contentType = null;
        Subscription response = api.subscriptionsPost(body, contentType);

        // TODO: test validations
    }
    
    /**
     * Remove a subscription 
     *
     * This operation can be used to remove a subscription. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void subscriptionsSubscriptionIdDeleteTest() throws ApiException {
        String subscriptionId = null;
        String ifMatch = null;
        String ifUnmodifiedSince = null;
        api.subscriptionsSubscriptionIdDelete(subscriptionId, ifMatch, ifUnmodifiedSince);

        // TODO: test validations
    }
    
    /**
     * Get details of a subscription 
     *
     * This operation can be used to get details of a single subscription. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void subscriptionsSubscriptionIdGetTest() throws ApiException {
        String subscriptionId = null;
        String accept = null;
        String ifNoneMatch = null;
        String ifModifiedSince = null;
        Subscription response = api.subscriptionsSubscriptionIdGet(subscriptionId, accept, ifNoneMatch, ifModifiedSince);

        // TODO: test validations
    }
    
}
