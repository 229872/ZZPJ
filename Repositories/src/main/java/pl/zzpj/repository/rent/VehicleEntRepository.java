package pl.zzpj.repository.rent;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zzpj.data.rent.VehicleEnt;

import java.util.UUID;

@Repository
public class VehicleEntRepository implements JpaRepository<VehicleEnt, UUID> {
}
