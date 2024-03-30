package com.wolfcode.exceptions.validation.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wolfcode.exceptions.validation.validation.ValidEducationLevel;
import com.wolfcode.exceptions.validation.validation.ValidateNationality;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserRequest {

    @NotBlank(message = "Enter first name")
    private String firstname;
    @NotBlank(message = "Enter first name")
    private String lastname;
    @Pattern(regexp = "^\\d{9}$", message = "Enter a valid phone number")
    private String phone;
    @Email(message = "Invalid email format")
    private String email;
    @Past(message = "Enter a valid date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date dateOfBirth;
    @NotBlank
    @ValidateNationality(message = "Our Services are not available in your Country")
    private String nationality;
    @NotBlank
    @ValidEducationLevel(message = "Choose between: primary, secondary, university ")
    private String levelOfStudy;

}
