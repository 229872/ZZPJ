package pl.zzpj.repository.core.domain.model.weatherModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private String lattidute;
    private String longitude;
    private String country;
    private String population;
    private String timezone;
    private String sunrise;
    private String sunset;
}
