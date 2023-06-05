package pl.zzpj.repository.rest.dto.input;

import jakarta.validation.constraints.NotBlank;

public record CredentialsDto(@NotBlank String login, @NotBlank String password) {
}
