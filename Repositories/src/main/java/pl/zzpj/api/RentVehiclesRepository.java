package pl.zzpj.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zzpj.data.rent.VehicleEnt;

import java.util.List;
import java.util.UUID;

@Repository
public interface RentVehiclesRepository extends JpaRepository<VehicleEnt, UUID> {

}
