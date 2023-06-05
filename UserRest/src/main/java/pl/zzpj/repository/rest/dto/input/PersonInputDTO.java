package pl.zzpj.repository.rest.dto.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;


@Builder
public record PersonInputDTO (
        @NotBlank String name,
        @NotBlank String lastName,
        @NotBlank String gender,
        @NotBlank String dateOfBirth,
        @NotNull @Valid AddressInputDTO address ) {

}
