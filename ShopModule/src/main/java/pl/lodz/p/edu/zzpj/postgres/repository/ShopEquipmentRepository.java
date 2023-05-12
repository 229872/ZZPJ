package pl.lodz.p.edu.zzpj.postgres.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.lodz.p.edu.zzpj.postgres.entities.shopEntities.ShopEquipmentEnt;

import java.util.UUID;


@Repository
public interface ShopEquipmentRepository extends JpaRepository<ShopEquipmentEnt, UUID> {
}
