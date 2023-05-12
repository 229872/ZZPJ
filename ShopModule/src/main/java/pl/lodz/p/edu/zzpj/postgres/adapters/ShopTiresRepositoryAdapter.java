package pl.lodz.p.edu.zzpj.postgres.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import pl.lodz.p.edu.zzpj.postgres.repository.ShopEquipmentRepository;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandPort;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestScope
@Component
public class ShopTiresRepositoryAdapter implements ShopTiresCommandPort, ShopTiresQueryPort {

    private ShopEquipmentRepository repository;

    @Autowired
    public ShopTiresRepositoryAdapter(ShopEquipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShopTire add(ShopTire equipment) {
        return null;
    }

    @Override
    public ShopTire update(UUID id, ShopTire tire) throws EquipmentNotFoundServiceException {
        return null;
    }

    @Override
    public void remove(UUID id) {

    }

    @Override
    public List<ShopTire> getAllEquipment() {
        return null;
    }

    @Override
    public ShopTire getById(UUID id) throws EquipmentNotFoundServiceException {
        return null;
    }
}
