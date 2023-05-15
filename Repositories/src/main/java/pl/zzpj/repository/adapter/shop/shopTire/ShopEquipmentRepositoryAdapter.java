package pl.zzpj.repository.adapter.shop.shopTire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopEquipment;
import pl.zzpj.ports.command.ShopEquipment.ShopEquipmentCommandPort;
import pl.zzpj.ports.query.ShopEquipment.ShopEquipmentQueryPort;
import pl.zzpj.repository.adapter.shop.shopTire.mapper.ShopEquipmentFromDataToDomainMapper;
import pl.zzpj.repository.adapter.shop.shopTire.mapper.ShopEquipmentFromDomainToDataMapper;
import pl.zzpj.repository.api.ShopEquipmentRepository;

import java.util.List;
import java.util.Objects;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ShopEquipmentRepositoryAdapter implements ShopEquipmentCommandPort, ShopEquipmentQueryPort {

    private ShopEquipmentRepository repository;
    private ShopEquipmentFromDataToDomainMapper fromDataMapper;
    private ShopEquipmentFromDomainToDataMapper fromDomainMapper;

    @Autowired
    public ShopEquipmentRepositoryAdapter(ShopEquipmentRepository repository,
                                          ShopEquipmentFromDataToDomainMapper fromDataMapper,
                                          ShopEquipmentFromDomainToDataMapper fromDomainMapper) {
        this.repository = repository;
        this.fromDataMapper = fromDataMapper;
        this.fromDomainMapper = fromDomainMapper;
    }

    @Override
    public ShopEquipment add(ShopEquipment equipment) {
        return fromDataMapper.convertDataToDomainModel(repository
                .save(fromDomainMapper.convertDomainModelToDataRepository(equipment)));
    }

    @Override
    public ShopEquipment update(ShopEquipment equipment) throws EquipmentNotFoundServiceException {
        return fromDataMapper.convertDataToDomainModel(repository
                .save(fromDomainMapper.convertDomainModelToDataRepository(equipment)));
    }

    @Override
    public void remove(UUID id) {
        repository.deleteById(id);
    }

    @Override
    public List<ShopEquipment> getAllEquipment() {
        return repository.findAll().stream()
                .map(fromDataMapper::convertDataToDomainModel).filter(Objects::nonNull).collect(Collectors.toList());
    }

    @Override
    public ShopEquipment getEquipmentById(UUID id) throws EquipmentNotFoundServiceException {
        return null;
    }
}
