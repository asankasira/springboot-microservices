package org.asanka.javaguide.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Schema (
     description = "Schema of UserDTO"
)
@Getter
@Setter
public class UserDTO {
    private Long id;

    @Schema ( description = "user first name")
    @NotBlank(message = "should not be blank")
    private String firstName;

    @Schema ( description = "user last name")
    @NotBlank
    private String surname;

    @Schema ( description = "user email")
    @NotBlank
    @Email(message = "please specify valid email address")
    private String email;
}
