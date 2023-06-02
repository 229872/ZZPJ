package pl.zzpj.repository.rest.dto.output;

import lombok.Builder;



@Builder
public record AddressOutputDTO(
        String country,
        String city,
        String streetName,
        String streetNumber,
        String postalCode,
        String fullAddress,
        String secondaryAddress,
        Integer buildingNumber,
        String mailBox,
        String state,
        CoordinatesDto coordinates,
        String community,
        String countryCode,
        String streetSuffix,
        String cityPrefix,
        String citySuffix,
        String stateAbbr
) {

}
