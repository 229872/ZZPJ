package pl.zzpj.repository.rest.dto;

import lombok.Builder;

@Builder
public record WindDto(
    double speed,
    double deg,
    double gust
) {
}
