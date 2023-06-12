package pl.zzpj.repository.core.domain.model.weatherModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Data
@AllArgsConstructor
public class Weather {
    private String message;
    private String cnt;
    private City city;
    private List<DataElement> elementList;
}
