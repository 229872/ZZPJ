package pl.zzpj.adapter.shop.shopTire;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.shopModel.ShopTire;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandPort;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryPort;
import pl.zzpj.adapter.shop.shopTire.mapper.ShopTireFromDataToDomainMapper;
import pl.zzpj.adapter.shop.shopTire.mapper.ShopTireFromDomainToDataMapper;
import pl.zzpj.api.ShopTireRepository;

import java.util.List;
import java.util.UUID;

@Service
public class ShopTiresRepositoryAdapter implements ShopTiresCommandPort, ShopTiresQueryPort {

    private ShopTireRepository repository;
    private ShopTireFromDataToDomainMapper fromDataMapper;
    private ShopTireFromDomainToDataMapper fromDomainMapper;

    @Autowired
    public ShopTiresRepositoryAdapter(ShopTireRepository repository,
                                      ShopTireFromDataToDomainMapper fromDataMapper,
                                      ShopTireFromDomainToDataMapper fromDomainMapper) {
        this.repository = repository;
        this.fromDataMapper = fromDataMapper;
        this.fromDomainMapper = fromDomainMapper;
    }

    @Override
    public ShopTire add(ShopTire tire) {
        return null; //FIXME
//        return fromDataMapper.convertTireEntToDomainModel(repository
//                .save(fromDomainMapper.convertDomainModelToDataRepository(tire)));
    }

    @Override
    public ShopTire update(ShopTire tire) throws EquipmentNotFoundServiceException {
        return null; //FIXME
        //        return fromDataMapper.convertTireEntToDomainModel(repository
//                .save(fromDomainMapper.convertDomainModelToDataRepository(tire)));
    }

    @Override
    public void remove(UUID id) {
//        repository.deleteById(id);
    }

    @Override
    public List<ShopTire> getAllTires() {
        return null; //FIXME
//        return repository.findAll().stream()
//                .map(fromDataMapper::convertTireEntToDomainModel).collect(Collectors.toList());
    }

    @Override
    public ShopTire getTireById(UUID id) throws EquipmentNotFoundServiceException {
        return null; //FIXME
//        return fromDataMapper.convertTireEntToDomainModel(repository.findById(id)
//                .orElseThrow(EquipmentNotFoundServiceException::new));
    }
}
