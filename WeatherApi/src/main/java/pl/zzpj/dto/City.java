package pl.zzpj.dto;

import lombok.Builder;

@Builder
public record City(
    String name,
    Coordinates coord,
    String country,
    String population,
    String timezone,
    String sunrise,
    String sunset
) {
}
