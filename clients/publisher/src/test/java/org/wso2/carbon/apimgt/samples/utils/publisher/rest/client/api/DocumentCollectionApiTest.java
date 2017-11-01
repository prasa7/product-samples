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
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Document;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.DocumentList;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Error;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for DocumentCollectionApi
 */
@Ignore
public class DocumentCollectionApiTest {

    private final DocumentCollectionApi api = new DocumentCollectionApi();

    
    /**
     * Get a list of documents of an API
     *
     * This operation can be used to retrive a list of documents belonging to an API by providing the id of the API. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void apisApiIdDocumentsGetTest() throws ApiException {
        String apiId = null;
        Integer limit = null;
        Integer offset = null;
        String accept = null;
        String ifNoneMatch = null;
        DocumentList response = api.apisApiIdDocumentsGet(apiId, limit, offset, accept, ifNoneMatch);

        // TODO: test validations
    }
    
    /**
     * Add a new document to an API
     *
     * This operation can be used to add a new documentation to an API. This operation only adds the metadata of a document. To add the actual content we need to use **Upload the content of an API document ** API once we obtain a document Id by this operation. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void apisApiIdDocumentsPostTest() throws ApiException {
        String apiId = null;
        Document body = null;
        String contentType = null;
        Document response = api.apisApiIdDocumentsPost(apiId, body, contentType);

        // TODO: test validations
    }
    
}
