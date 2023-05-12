package pl.lodz.p.edu.zzpj.rest.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopEquipment.ShopTireFromDomainToDtoMapper;
import pl.lodz.p.edu.zzpj.rest.adapters.mappers.shopEquipment.ShopTireFromInputDtoToDomainMapper;
import pl.lodz.p.edu.zzpj.rest.command.ShopTiresCommandRest;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopEquipmentInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;
import pl.lodz.p.edu.zzpj.rest.query.ShopTiresQueryRest;
import pl.zzpj.ports.command.ShopEquipment.ShopTiresCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopTiresQueryService;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.List;
import java.util.UUID;

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
        return null;
    }

    @Override
    public ShopTireOutputDto getEquipmentById(UUID uuid) {
        return null;
    }

    @Override
    public ShopTireOutputDto addEquipment(ShopTireInputDto dto) {
        return null;
    }

    @Override
    public ShopTireOutputDto updateEquipment(UUID id, ShopTireInputDto dto) {
        return null;
    }

    @Override
    public void removeEquipment(UUID id) {

    }
}
