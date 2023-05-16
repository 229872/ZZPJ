package pl.zzpj.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.zzpj.data.shop.ShopEquipmentEnt;

import java.util.UUID;

@NoRepositoryBean
public interface ShopEquipmentRepository<T extends ShopEquipmentEnt> extends JpaRepository<T, UUID> {
}
