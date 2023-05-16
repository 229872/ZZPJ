package pl.zzpj.repository.adapter.shop.shopTire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopTireCommandPort;
import pl.zzpj.ports.query.ShopEquipment.ShopTireQueryPort;
import pl.zzpj.repository.adapter.shop.shopTire.mapper.ShopEquipmentFromDataToDomainMapper;
import pl.zzpj.repository.adapter.shop.shopTire.mapper.ShopEquipmentFromDomainToDataMapper;
import pl.zzpj.repository.api.ShopEquipmentRepository;
import pl.zzpj.repository.data.shop.ShopTireEnt;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShopTireRepositoryAdapter implements ShopTireCommandPort, ShopTireQueryPort {

    private ShopEquipmentRepository repository;
    private ShopEquipmentFromDataToDomainMapper fromDataMapper;
    private ShopEquipmentFromDomainToDataMapper fromDomainMapper;

    @Autowired
    public ShopTireRepositoryAdapter(ShopEquipmentRepository repository,
                                     ShopEquipmentFromDataToDomainMapper fromDataMapper,
                                     ShopEquipmentFromDomainToDataMapper fromDomainMapper) {
        this.repository = repository;
        this.fromDataMapper = fromDataMapper;
        this.fromDomainMapper = fromDomainMapper;
    }

    @Override
    public ShopTire add(ShopTire tire) {
        return fromDataMapper.convertDataToDomainModel((ShopTireEnt) repository
                .save(fromDomainMapper.convertDomainModelToDataRepository(tire)));
    }

    @Override
    public ShopTire update(ShopTire tire) throws EquipmentNotFoundServiceException {
        return fromDataMapper.convertDataToDomainModel((ShopTireEnt) repository
                .save(fromDomainMapper.convertDomainModelToDataRepository(tire)));
    }

    @Override
    public void remove(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<ShopTire> getAllEquipment() {
        return repository.findAll().stream().map(x -> (ShopTireEnt) x)
                .map(fromDataMapper::convertDataToDomainModel).collect(Collectors.toList());
    }

    @Override
    public ShopTire getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return (ShopTire) repository.findById(id).stream();
    }
}
