package ru.gb.api.security.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto {

    @JsonIgnore
    private Long id;
    @NotBlank(message = "is required")
    @Size(min = 3, message = "username length must be greater than 5 symbols")
    private String username;
    @NotBlank(message = "is required")
    @Size(min = 8, message = "password length must be greater than 8 symbols")
    private String password;
    @NotBlank(message = "is required")
    private String firstname;
    @NotBlank(message = "is required")
    private String lastname;
    @NotBlank(message = "is required")
    private String email;
    @NotBlank(message = "is required")
    @Size(min = 5, message = "phone length must be greater than 5 symbols")
    private String phone;
}
