package pl.zzpj.repository.api;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.zzpj.repository.data.shop.ShopEquipmentEnt;

import java.util.UUID;

@Repository
public interface ShopEquipmentRepository extends JpaRepository<ShopEquipmentEnt, UUID> {
}
