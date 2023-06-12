package pl.zzpj.repository.rest.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record MainValuesDto(
    double temp,
    @JsonProperty("feels_like") double feelsLike,
    @JsonProperty("temp_min") double tempMin,
    @JsonProperty("temp_max") double tempMax,
    @JsonProperty("pressure") int pressure,
    @JsonProperty("sea_level") int seaLevel,
    @JsonProperty("grnd_level") int groundLevel,
    @JsonProperty("humidity") int humidity,
    @JsonProperty("temp_kf") double tempKf
) {
}
