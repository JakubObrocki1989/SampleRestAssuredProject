package org.example.petstore.api.models.pet;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.core.models.api.responses.BaseResponse;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Pet extends BaseResponse {
    private long id;
    private PetCategory category;
    private String name;
    List<String> photoUrls;
    List<PetTag> tags;
    private String status;
}
