package pl.zzpj.repository.data.vehicle;

import jakarta.persistence.*;
import lombok.*;
import pl.zzpj.repository.data.AbstractEntity;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicle")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEnt extends AbstractEntity {
    @Column
    private String make;

    @Column
    private String model;

    @Column
    private long hourlyRate;

    @Column
    private boolean isAvailable;


}
