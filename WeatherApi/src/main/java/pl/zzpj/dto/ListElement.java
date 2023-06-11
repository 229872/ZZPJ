package pl.zzpj.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.sun.tools.javac.Main;
import lombok.Builder;

import java.util.List;

@Builder
public record ListElement(
    String dt, //Timestamp
    Main main,
    List<Weather> weather,
    Wind wind,
    String visibility,
    @JsonProperty("dt_txt") String dtTxt
    ) {
}
