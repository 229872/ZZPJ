package pl.zzpj.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zzpj.repository.data.rent.RentEnt;

import java.util.UUID;

@Repository
public interface RentRepository extends JpaRepository<RentEnt, UUID> {
}
