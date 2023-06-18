package pl.zzpj.repository.data.vehicle;

import jakarta.persistence.*;
import lombok.*;
import pl.zzpj.repository.data.AbstractEntity;

import java.util.ArrayList;
import java.util.List;
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

    @Column
    private List<String> damage;

    @Column
    String color;

    @Column
    String transmission;

    @Column
    String drive_type;

    @Column
    String fuel_type;

    @Column
    String car_type;

    @Column
    ArrayList<String> car_options;

    @Column
    ArrayList<String> specs;

    @Column
    int doors;


}
