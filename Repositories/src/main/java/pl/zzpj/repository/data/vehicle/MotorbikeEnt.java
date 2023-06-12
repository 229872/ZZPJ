package pl.zzpj.repository.data.vehicle;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Data
@Table(name = "Motorbike")
@AllArgsConstructor
@NoArgsConstructor()
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@PrimaryKeyJoinColumn(name = "VehicleEntId")
public class MotorbikeEnt extends VehicleEnt{
    String engineSize;
}
