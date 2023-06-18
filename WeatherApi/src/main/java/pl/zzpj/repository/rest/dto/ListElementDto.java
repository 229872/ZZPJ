package pl.zzpj.repository.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.util.List;

@Builder
public record ListElementDto(
    String dt, //Timestamp
    MainValuesDto main,
    List<DesciptionDto> weather,
    WindDto wind,
    double visibility,
    @JsonProperty("dt_txt") String dtTxt
    ) {
}
