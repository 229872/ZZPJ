package pl.lodz.p.edu.zzpj.postgres.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import pl.lodz.p.edu.zzpj.postgres.repository.ShopEquipmentRepository;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.ports.command.ShopEquipment.ShopEquipmentCommandPort;
import pl.zzpj.ports.query.ShopEquipment.ShopEquipmentQueryPort;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RequestScope
@Component
public class ShopEquipmentRepositoryAdapter implements ShopEquipmentCommandPort, ShopEquipmentQueryPort {

    private ShopEquipmentRepository repository;

    @Autowired
    public ShopEquipmentRepositoryAdapter(ShopEquipmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public ShopEquipment add(ShopEquipment equipment) {
        return null;
    }

    @Override
    public ShopEquipment update(UUID id, ShopEquipment equipment) throws EquipmentNotFoundServiceException {
        return null;
    }

    @Override
    public void remove(ShopEquipment id) {

    }

    @Override
    public List<ShopEquipment> getAllEquipment() {
        return null;
    }

    @Override
    public Optional<ShopEquipment> getById(UUID id) throws EquipmentNotFoundServiceException {
        return Optional.empty();
    }
}
