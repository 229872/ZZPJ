package pl.zzpj.repository.rest.dto;

import lombok.Builder;

@Builder
public record WindDto(
    String speed,
    String deg,
    String gust
) {
}
