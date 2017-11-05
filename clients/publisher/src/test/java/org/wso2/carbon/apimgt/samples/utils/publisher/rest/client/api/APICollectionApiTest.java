/*
 * WSO2 API Manager - Publisher API
 * This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.1.66/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: 0.11.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.api;

import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.ApiException;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.API;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.APIList;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Error;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for APICollectionApi
 */
@Ignore
public class APICollectionApiTest {

    private final APICollectionApi api = new APICollectionApi();

    
    /**
     * Retrieve/Search APIs 
     *
     * This operation provides you a list of available APIs qualifying under a given search condition.  Each retrieved API is represented with a minimal amount of attributes. If you want to get complete details of an API, you need to use **Get details of an API** operation. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void apisGetTest() throws ApiException {
        Integer limit = null;
        Integer offset = null;
        String query = null;
        String accept = null;
        String ifNoneMatch = null;
        APIList response = api.apisGet(limit, offset, query, accept, ifNoneMatch);

        // TODO: test validations
    }
    
    /**
     * Create a new API
     *
     * This operation can be used to create a new API specifying the details of the API in the payload. The new API will be in &#x60;CREATED&#x60; state.  There is a special capability for a user who has &#x60;APIM Admin&#x60; permission such that he can create APIs on behalf of other users. For that he can to specify &#x60;\&quot;provider\&quot; : \&quot;some_other_user\&quot;&#x60; in the payload so that the API&#39;s creator will be shown as &#x60;some_other_user&#x60; in the UI. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void apisPostTest() throws ApiException {
        API body = null;
        String contentType = null;
        API response = api.apisPost(body, contentType);

        // TODO: test validations
    }
    
}