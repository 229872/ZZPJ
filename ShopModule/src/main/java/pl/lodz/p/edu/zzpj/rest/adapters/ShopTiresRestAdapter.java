package pl.lodz.p.edu.zzpj.rest.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopEquipment.ShopTireFromDomainToDtoMapper;
import pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopEquipment.ShopTireFromInputDtoToDomainMapper;
import pl.lodz.p.edu.zzpj.rest.command.ShopTiresCommandRest;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.lodz.p.edu.zzpj.rest.query.ShopTiresQueryRest;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class ShopTiresRestAdapter implements ShopTiresCommandRest, ShopTiresQueryRest {

    private final ShopTiresCommandService commandService;
    private final ShopTiresQueryService queryService;
    private final ShopTireFromInputDtoToDomainMapper fromInputDtoMapper;
    private final ShopTireFromDomainToDtoMapper fromDomainMapper;

    @Autowired
    public ShopTiresRestAdapter(ShopTiresCommandService commandService,
                                ShopTiresQueryService queryService,
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
    public ShopTireOutputDto getEquipmentById(UUID uuid) {
        return fromDomainMapper.convertDomainModelToTireOutputDto(queryService.getEquipmentById(uuid));
    }

    @Override
    public ShopTireOutputDto addEquipment(ShopTireInputDto dto) {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                addEquipment(fromInputDtoMapper.convertTireInputDtoToDomainModel(dto)));
    }

    @Override
    public ShopTireOutputDto updateEquipment(UUID id, ShopTireInputDto dto) {
        return fromDomainMapper.convertDomainModelToTireOutputDto(commandService.
                updateEquipment(id, fromInputDtoMapper.convertTireInputDtoToDomainModel(dto)));
    }

    @Override
    public void removeEquipment(UUID id) {
        commandService.removeEquipment(id);
    }
}
