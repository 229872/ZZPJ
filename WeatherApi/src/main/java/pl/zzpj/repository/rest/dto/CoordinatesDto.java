package pl.zzpj.repository.rest.dto;

import lombok.Builder;

@Builder
public record CoordinatesDto(
    String lat,
    String lon
) {
}
