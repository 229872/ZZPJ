package pl.zzpj.repository.api;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zzpj.repository.data.vehicleEquipment.VehicleEquipmentEnt;

import java.util.UUID;

@Repository
public interface VehicleEquipmentRepository extends JpaRepository<VehicleEquipmentEnt, UUID> {
}
