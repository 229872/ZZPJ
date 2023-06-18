package pl.zzpj.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.data.rent.RentEnt;
import pl.zzpj.repository.data.user.Account;
import pl.zzpj.repository.data.vehicle.VehicleEnt;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Repository
public interface RentRepository extends JpaRepository<RentEnt, UUID> {
  @Query("select r from RentEnt r where r.status = ?1 and r.declaredStartDate = ?2")
  List<RentEnt> findByStatusAndDeclaredStartDate(RentStatus status, LocalDateTime declaredStartDate);
  @Query("select r from RentEnt r where r.vehicle = ?1")
  List<RentEnt> findByVehicle(VehicleEnt vehicle);
  @Query("select r from RentEnt r where r.user = ?1")
  List<RentEnt> findByUser(Account user);
  @Query("select r from RentEnt r where r.status in ?1")
  List<RentEnt> findByStatusIn(Collection<RentStatus> statuses);
  @Query("select r from RentEnt r where r.status = ?1")
  List<RentEnt> findByStatus(RentStatus status);
}
