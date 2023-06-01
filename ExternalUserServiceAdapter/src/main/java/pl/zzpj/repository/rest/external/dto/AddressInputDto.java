package pl.zzpj.repository.rest.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record AddressInputDto (
        String city,
        @JsonProperty("street_name") String streetName,
        @JsonProperty("street_address") String streetAddress,
        @JsonProperty("secondary_address") String secondaryAddress,
        @JsonProperty("building_number") String buildingNumber,
        @JsonProperty("mail_box") String mailBox,
        String community,
        String postcode,
        @JsonProperty("time_zone") String timeZone,
        @JsonProperty("street_suffix") String streetSuffix,
        @JsonProperty("city_suffix") String citySuffix,
        @JsonProperty("city_prefix") String cityPrefix,
        String state,
        @JsonProperty("state_abbr") String stateAbbr,
        String country,
        @JsonProperty("country_code") String countryCode,
        Double latitude,
        Double longitude,
        @JsonProperty("full_address") String fullAddress

) {
}
