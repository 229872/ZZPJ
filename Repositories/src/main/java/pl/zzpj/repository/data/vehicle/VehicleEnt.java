package pl.zzpj.repository.data.vehicle;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@Table(name = "vehicle")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VehicleEnt {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", nullable = false)
    private UUID id;

    @Column
    private String make;

    @Column
    private String model;

    @Column
    private long hourlyRate;

    @Column
    private boolean isAvailable;


}
