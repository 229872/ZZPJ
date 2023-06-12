package pl.zzpj.repository.core.domain.model.weatherModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainValues {

    private double temp;
    private double feelsLike;
    private double tempMin;
    private double tempMap;
    private int pressure;
    private int seaLevel;
    private int groundLevel;
    private int humidity;
    private double tempKf;
}
