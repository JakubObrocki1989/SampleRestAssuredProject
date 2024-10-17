package org.example.petstore.api.models.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.core.models.api.responses.BaseResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponse extends BaseResponse {
    private int code;
    private String type;
    private String message;
}
