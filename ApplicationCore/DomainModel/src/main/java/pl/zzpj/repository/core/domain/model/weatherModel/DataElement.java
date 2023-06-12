package pl.zzpj.repository.core.domain.model.weatherModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class DataElement {
    private String dt; //Timestamp
    private MainValues main;
    private List<Description> weather;
    private String windSpeed;
    private String windDeg;
    private String windGust;
    private String visibility;
    private String dtTxt;
}
