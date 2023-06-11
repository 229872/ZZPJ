package pl.zzpj.dto;

import lombok.Builder;

@Builder
public record Wind(
    String speed,
    String deg,
    String gust
) {
}
