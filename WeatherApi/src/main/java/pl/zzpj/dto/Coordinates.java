package pl.zzpj.dto;

import lombok.Builder;

@Builder
public record Coordinates(
    String lat,
    String lon
) {
}
