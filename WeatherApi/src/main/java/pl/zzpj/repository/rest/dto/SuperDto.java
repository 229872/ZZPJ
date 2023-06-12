package pl.zzpj.repository.rest.dto;

import lombok.Builder;
import java.util.List;

@Builder
public record SuperDto(
    String cod,
    String message,
    String cnt,
    List<ListElementDto> list,
    CityDto city
) {
}
