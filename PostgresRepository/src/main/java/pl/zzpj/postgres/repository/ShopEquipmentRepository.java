package pl.zzpj.postgres.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zzpj.postgres.entities.shopEntities.ShopEquipmentEnt;

import java.util.UUID;


@Repository
public interface ShopEquipmentRepository extends JpaRepository<ShopEquipmentEnt, UUID> {
}
