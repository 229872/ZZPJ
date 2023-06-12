package pl.zzpj.repository.rest.dto;

import lombok.Builder;

@Builder
public record DesciptionDto(
    String main,
    String description
    ) {
}
