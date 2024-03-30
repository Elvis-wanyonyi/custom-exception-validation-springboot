package com.wolfcode.exceptions.validation.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserResponse {

    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private String nationality;
    private Date dateOfBirth;
}
