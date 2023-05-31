package pl.zzpj.repository.rest.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddressInputDTO (
        @NotBlank String country,
        @NotBlank String countryCode,
        @NotBlank String city,
        @NotBlank String streetName,
        @NotBlank String streetAddress,
        @NotBlank String zipCode ) {

}
