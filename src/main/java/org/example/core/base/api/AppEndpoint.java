package org.example.core.base.api;

import io.restassured.http.ContentType;
import org.example.core.models.api.responses.BaseResponse;

public abstract class AppEndpoint<T extends BaseResponse> extends Endpoint<T> {

    public AppEndpoint(Class<T> model, String name) {
        super(model, name);
        requestSpecification.urlEncodingEnabled(false).contentType("multipart/form-data").accept(ContentType.JSON);
    }
}
