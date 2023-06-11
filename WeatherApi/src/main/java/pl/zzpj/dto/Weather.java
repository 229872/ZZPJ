package pl.zzpj.dto;

import lombok.Builder;

@Builder
public record Weather(
    String main,
    String description
    ) {
}
