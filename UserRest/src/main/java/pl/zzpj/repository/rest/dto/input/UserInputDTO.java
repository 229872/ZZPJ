package pl.zzpj.repository.rest.dto.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
public record UserInputDTO (
        @NotBlank(message = "login can't be empty") String login,
        @NotBlank @Size(min = 8) String password,
        @Email @NotBlank String email,
        @NotNull @Valid PersonInputDTO person,
        String phoneNumber,
        String socialInsuranceNumber,
        String creditCard,
        Double score ) {

}
