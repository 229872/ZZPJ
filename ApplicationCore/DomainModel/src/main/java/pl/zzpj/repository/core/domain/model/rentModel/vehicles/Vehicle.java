package pl.zzpj.repository.core.domain.model.rentModel.vehicles;


import lombok.*;
import pl.zzpj.repository.core.domain.model.AbstractDataModel;


@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class Vehicle extends AbstractDataModel {
    private String make;
    private String model;
    private long hourlyRate;
    private boolean isAvailable;



}
