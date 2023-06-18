package pl.zzpj.repository.rest.dto;

import lombok.Builder;

@Builder
public record CityDto(
    String name,
    CoordinatesDto coord,
    String country,
    int population,
    String timezone,
    String sunrise,
    String sunset
) {
}
