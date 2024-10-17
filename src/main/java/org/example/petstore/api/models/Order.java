package org.example.petstore.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.core.models.api.responses.BaseResponse;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Order extends BaseResponse {
    private int id;
    private int petId;
    private int quantity;
    private String shipDate;
    private String status;
    private boolean complete;

    public String getShipDate() {
        return shipDate.replaceFirst("\\:\\d+\\.\\d+\\+\\d+", "Z");
    }
}
