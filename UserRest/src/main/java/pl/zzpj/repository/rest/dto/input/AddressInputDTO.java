package pl.zzpj.repository.rest.dto.input;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record AddressInputDTO (
        @NotBlank String country,
        @NotBlank String city,
        @NotBlank String streetName,
        @NotBlank String streetNumber,
        @NotBlank String postalCode,
        String secondaryAddress,
        Integer buildingNumber,
        String mailBox,
        String timeZone,
        String state,
        Double longitude,
        Double latitude,
        String community

        ) {

}
