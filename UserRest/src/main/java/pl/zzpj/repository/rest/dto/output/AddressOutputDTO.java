package pl.zzpj.repository.rest.dto.output;

import lombok.Builder;



@Builder
public record AddressOutputDTO(String country, String countryCode, String city, String streetName,
                               String streetAddress) { }
