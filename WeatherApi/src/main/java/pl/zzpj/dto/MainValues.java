package pl.zzpj.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record MainValues(
    String temp,
    @JsonProperty("feels_like") String feelsLike,
    @JsonProperty("temp_min") String tempMin,
    @JsonProperty("temp_max") String tempMap,
    @JsonProperty("pressure") String pressure,
    @JsonProperty("sea_level") String seaLevel,
    @JsonProperty("grnd_level") String groundLevel,
    @JsonProperty("humidity") String humidity,
    @JsonProperty("temp_kf") String tempKf
) {
}
