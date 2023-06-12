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

    private String temp;
    private String feelsLike;
    private String tempMin;
    private String tempMap;
    private String pressure;
    private String seaLevel;
    private String groundLevel;
    private String humidity;
    private String tempKf;
}
