package pl.lodz.p.edu.zzpj.postgres.repository;


import org.springframework.stereotype.Repository;
import pl.lodz.p.edu.zzpj.postgres.entities.shopEntities.ShopTireEnt;

@Repository
public interface ShopTireRepository extends ShopEquipmentRepository<ShopTireEnt> {
}
