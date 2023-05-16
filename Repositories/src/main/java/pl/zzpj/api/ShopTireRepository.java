package pl.zzpj.api;


import org.springframework.stereotype.Repository;
import pl.zzpj.data.shop.ShopTireEnt;

@Repository
public interface ShopTireRepository extends ShopEquipmentRepository<ShopTireEnt> { //Todo basic shopEquipmentRepository
}
