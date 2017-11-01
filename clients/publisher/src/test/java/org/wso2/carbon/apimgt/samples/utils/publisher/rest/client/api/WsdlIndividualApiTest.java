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
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Error;
import org.wso2.carbon.apimgt.samples.utils.publisher.rest.client.model.Wsdl;
import org.junit.Test;
import org.junit.Ignore;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for WsdlIndividualApi
 */
@Ignore
public class WsdlIndividualApiTest {

    private final WsdlIndividualApi api = new WsdlIndividualApi();

    
    /**
     * Get the WSDL of an API
     *
     * This operation can be used to retrieve the WSDL definition of an API. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void apisApiIdWsdlGetTest() throws ApiException {
        String apiId = null;
        String accept = null;
        String ifNoneMatch = null;
        String ifModifiedSince = null;
        Wsdl response = api.apisApiIdWsdlGet(apiId, accept, ifNoneMatch, ifModifiedSince);

        // TODO: test validations
    }
    
    /**
     * Add a WSDL to an API
     *
     * This operation can be used to add a WSDL definition to an existing API. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void apisApiIdWsdlPostTest() throws ApiException {
        String apiId = null;
        Wsdl body = null;
        String contentType = null;
        String ifMatch = null;
        String ifUnmodifiedSince = null;
        api.apisApiIdWsdlPost(apiId, body, contentType, ifMatch, ifUnmodifiedSince);

        // TODO: test validations
    }
    
}
