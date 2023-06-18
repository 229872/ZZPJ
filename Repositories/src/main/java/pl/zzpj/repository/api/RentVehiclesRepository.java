package pl.zzpj.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.ConditionRating;
import pl.zzpj.repository.data.vehicle.VehicleEnt;

import java.util.List;
import java.util.UUID;

@Repository
public interface RentVehiclesRepository extends JpaRepository<VehicleEnt, UUID> {
    List<VehicleEnt> findByMake(String name);

    List<VehicleEnt> findByisAvailableTrue();

    List<VehicleEnt> findByRating(ConditionRating rating);

}
