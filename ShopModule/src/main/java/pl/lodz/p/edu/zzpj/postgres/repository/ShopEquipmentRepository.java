package pl.lodz.p.edu.zzpj.postgres.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import pl.lodz.p.edu.zzpj.postgres.entities.shopEntities.ShopEquipmentEnt;

import java.util.UUID;

@NoRepositoryBean
public interface ShopEquipmentRepository<T extends ShopEquipmentEnt> extends JpaRepository<T, UUID> {
}
