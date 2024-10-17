package org.example.petstore.api.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.core.models.api.responses.BaseResponse;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User extends BaseResponse {
       private long id;
       private String username;
       private String firstName;
       private String lastName;
       private String email;
       private String password;
       private String phone;
       private int userStatus;
}
