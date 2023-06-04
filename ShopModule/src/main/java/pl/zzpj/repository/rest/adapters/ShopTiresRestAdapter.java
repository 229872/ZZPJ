package pl.zzpj.repository.rest.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.repository.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.repository.ports.command.ShopEquipment.ShopTireCommandService;
import pl.zzpj.repository.ports.query.ShopEquipment.ShopTireQueryService;
import pl.zzpj.repository.rest.adapters.mappers.shopTire.ShopTireFromDomainToDtoMapper;
import pl.zzpj.repository.rest.adapters.mappers.shopTire.ShopTireFromInputDtoToDomainMapper;
import pl.zzpj.repository.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.zzpj.repository.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.zzpj.repository.rest.command.ShopTiresCommandRest;
import pl.zzpj.repository.rest.query.ShopTiresQueryRest;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ShopTiresRestAdapter implements ShopTiresCommandRest, ShopTiresQueryRest {

    private final ShopTireCommandService commandService;
    private final ShopTireQueryService queryService;
    private final ShopTireFromInputDtoToDomainMapper fromInputDtoMapper;
    private final ShopTireFromDomainToDtoMapper fromDomainMapper;

    @Autowired
    public ShopTiresRestAdapter(ShopTireCommandService commandService,
                                ShopTireQueryService queryService,
                                ShopTireFromInputDtoToDomainMapper fromInputDtoMapper,
                                ShopTireFromDomainToDtoMapper fromDomainMapper) {
        this.commandService = commandService;
        this.queryService = queryService;
        this.fromInputDtoMapper = fromInputDtoMapper;
        this.fromDomainMapper = fromDomainMapper;
    }


    @Override
    public List<ShopTireOutputDto> getAllEquipment() {
        return queryService.getAllEquipment().stream()
                .map(fromDomainMapper::convertDomainModelToTireOutputDto).collect(Collectors.toList());
    }

    @Override
    public ShopTireOutputDto getEquipmentById(UUID uuid) throws EquipmentNotFoundServiceException {
        return fromDomainMapper.convertDomainModelToTireOutputDto(queryService.getEquipmentById(uuid));
    }

    @Override
    public ShopTireOutputDto addEquipment(ShopTireInputDto dto) {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                addEquipment(fromInputDtoMapper.convertTireInputCreateDtoToDomainModel(dto)));
    }

    @Override
    public ShopTireOutputDto updateEquipment(UUID id, ShopTireInputDto dto)
            throws EquipmentNotFoundServiceException, BadEquipmentTypeException {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                updateEquipment(id, fromInputDtoMapper.convertTireInputCreateDtoToDomainModel(dto)));
    }

    @Override
    public void removeEquipment(UUID id) {
        commandService.removeEquipment(id);
    }
}