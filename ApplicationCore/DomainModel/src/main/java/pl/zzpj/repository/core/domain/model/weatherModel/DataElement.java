package pl.zzpj.repository.core.domain.model.weatherModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class DataElement {
    private String dt; //Timestamp
    private MainValues main;
    private List<Description> weather;
    private double windSpeed;
    private double windDeg;
    private double windGust;
    private double visibility;
    private String dtTxt;
}
