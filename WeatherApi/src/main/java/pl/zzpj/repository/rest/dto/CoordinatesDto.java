package pl.zzpj.repository.rest.dto;

import lombok.Builder;

@Builder
public record CoordinatesDto(
    double lat,
    double lon
) {
}
