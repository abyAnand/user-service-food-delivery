package com.delivery.userservice.dto;

import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {


        private int userId;
        private String userName;
        private String userPassword;
        private String address;
        private String city;

}
