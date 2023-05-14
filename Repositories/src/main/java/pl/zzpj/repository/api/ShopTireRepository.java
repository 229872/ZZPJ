package pl.zzpj.repository.api;


import org.springframework.stereotype.Repository;
import pl.zzpj.repository.data.shop.ShopTireEnt;

@Repository
public interface ShopTireRepository extends ShopEquipmentRepository<ShopTireEnt> { //Todo basic shopEquipmentRepository
}
