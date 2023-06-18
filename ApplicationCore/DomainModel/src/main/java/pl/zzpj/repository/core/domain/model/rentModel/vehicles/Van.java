package pl.zzpj.repository.core.domain.model.rentModel.vehicles;

import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Van extends Vehicle{
    String cargoCapacity;

    @Builder(builderMethodName = "fromApiBuilder")
    public Van(String make, String model,
                        String cargoCapacity) {
        this.setMake(make);
        this.setModel(model);
        this.setHourlyRate(80);
        this.setAvailable(true);
        this.cargoCapacity = cargoCapacity;
    }
}
