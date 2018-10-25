package com.ua.sutty.crud.transfer;

import com.ua.sutty.crud.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserDTO {

    private String firstName;
    private String lastName;

    public static UserDTO from(User user){
        return UserDTO.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .build();
    }

}
