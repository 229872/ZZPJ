package pl.zzpj.repository.core.domain.model.weatherModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class Description {
    private String main;
    private String description;
}
