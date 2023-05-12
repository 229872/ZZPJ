package pl.lodz.p.edu.zzpj.postgres.adapters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;
import pl.lodz.p.edu.zzpj.postgres.adapters.mappers.shopTire.ShopTireFromDataToDomainMapper;
import pl.lodz.p.edu.zzpj.postgres.adapters.mappers.shopTire.ShopTireFromDomainToDataMapper;
import pl.lodz.p.edu.zzpj.postgres.repository.ShopEquipmentRepository;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandPort;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryPort;

import java.util.List;
import java.util.UUID;

@RequestScope
@Component
public class ShopTiresRepositoryAdapter implements ShopTiresCommandPort, ShopTiresQueryPort {

    private ShopEquipmentRepository repository;
    private ShopTireFromDataToDomainMapper fromDataMapper;
    private ShopTireFromDomainToDataMapper fromDomainMapper;

    @Autowired
    public ShopTiresRepositoryAdapter(ShopEquipmentRepository repository,
                                      ShopTireFromDataToDomainMapper fromDataMapper,
                                      ShopTireFromDomainToDataMapper fromDomainMapper) {
        this.repository = repository;
        this.fromDataMapper = fromDataMapper;
        this.fromDomainMapper = fromDomainMapper;
    }

    @Override
    public ShopTire add(ShopTire tire) {
        return fromDataMapper.convertTireEntToDomainModel(repository
                .save(fromDomainMapper.convertDomainModelToDataRepository(tire)));
    }

    @Override
    public ShopTire update(UUID id, ShopTire tire) throws EquipmentNotFoundServiceException {
        //FIXME probably doesn't have UUID, and/or won't merge entity because it's not in managed state
        return fromDataMapper.convertTireEntToDomainModel(repository
                .saveAndFlush(fromDomainMapper.convertDomainModelToDataRepository(tire)));
    }

    @Override
    public void remove(UUID id) {

    }

    @Override
    public List<ShopTire> getAllEquipment() {
        return null;
    }

    @Override
    public ShopTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return null;
    }
}
