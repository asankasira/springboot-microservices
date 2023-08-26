package org.asanka.javaguide.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;

    @NotBlank(message = "should not be blank")
    private String firstName;

    @NotBlank
    private String surname;

    @NotBlank
    @Email(message = "please specify valid email address")
    private String email;
}
