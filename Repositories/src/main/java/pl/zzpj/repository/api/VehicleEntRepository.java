package pl.zzpj.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zzpj.repository.data.vehicle.VehicleEnt;

import java.util.UUID;

@Repository
public interface VehicleEntRepository extends JpaRepository<VehicleEnt, UUID> {
}
