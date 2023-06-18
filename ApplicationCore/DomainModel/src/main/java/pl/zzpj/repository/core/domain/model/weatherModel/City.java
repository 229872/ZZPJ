package pl.zzpj.repository.core.domain.model.weatherModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class City {
    private String name;
    private double latitude;
    private double longitude;
    private String country;
    private int population;
    private String timezone;
    private String sunrise;
    private String sunset;
}
