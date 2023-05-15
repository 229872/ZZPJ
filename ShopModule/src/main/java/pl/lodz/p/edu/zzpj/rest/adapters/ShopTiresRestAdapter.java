package pl.lodz.p.edu.zzpj.rest.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopTire.ShopTireFromDomainToDtoMapper;
import pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopTire.ShopTireFromInputDtoToDomainMapper;
import pl.lodz.p.edu.zzpj.rest.command.ShopTiresCommandRest;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireCreateInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireUpdateInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.lodz.p.edu.zzpj.rest.query.ShopTiresQueryRest;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.ports.command.ShopEquipment.ShopEquipmentCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopEquipmentQueryService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ShopTiresRestAdapter implements ShopTiresCommandRest, ShopTiresQueryRest {

    private final ShopEquipmentCommandService commandService;
    private final ShopEquipmentQueryService queryService;
    private final ShopTireFromInputDtoToDomainMapper fromInputDtoMapper;
    private final ShopTireFromDomainToDtoMapper fromDomainMapper;

    @Autowired
    public ShopTiresRestAdapter(ShopEquipmentCommandService commandService,
                                ShopEquipmentQueryService queryService,
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
    public ShopTireOutputDto addEquipment(ShopTireCreateInputDto dto) {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                addEquipment(fromInputDtoMapper.convertTireInputCreateDtoToDomainModel(dto)));
    }

    @Override
    public ShopTireOutputDto updateEquipment(UUID id, ShopTireUpdateInputDto dto)
            throws EquipmentNotFoundServiceException {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                updateEquipment(id, fromInputDtoMapper.convertTireInputUpdateDtoToDomainModel(dto)));
    }

    @Override
    public void removeEquipment(UUID id) {
        commandService.removeEquipment(id);
    }
}
