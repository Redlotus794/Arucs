package com.rdlts.arcus.identity.user.userinterface.request;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import org.hibernate.validator.constraints.Length;

/**
 * CreateArcusUserRequest
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Builder
@Schema(description = "Request body for creating an Arcus user")
public class CreateArcusUserRequest {

    @NotBlank
    @Schema(description = "Username of the new user", example = "alice", requiredMode = Schema.RequiredMode.REQUIRED)
    String username;

    @NotBlank
    @Schema(description = "Password for the new user", example = "P@ssw0rd", requiredMode = Schema.RequiredMode.REQUIRED)
    String password;

    @Schema(description = "Email address of the user", example = "alice@example.com")
    String email;

    @Schema(description = "Avatar URL for the user", example = "https://example.com/avatar/alice.png")
    String avatar;
}
