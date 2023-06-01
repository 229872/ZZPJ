package pl.zzpj.repository.rest.external.dto;

import lombok.Builder;

@Builder
public record AddressInputDto (
        String city,
        String street_name,
        String street_address,
        String secondary_address,
        String building_number,
        String mail_box,
        String community,
        String postcode,
        String time_zone,
        String street_suffix,
        String city_suffix,
        String city_prefix,
        String state,
        String state_abbr,
        String country,
        String country_code,
        Double latitude,
        Double longitude,
        String full_address

) {
}
