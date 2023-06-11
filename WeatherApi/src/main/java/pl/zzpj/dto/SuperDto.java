package pl.zzpj.dto;

import java.util.List;

public record SuperDto(
    String cod,
    String message,
    String cnt,
    List<ListElement> list,
    City city
) {
}
