package pl.lodz.p.edu.zzpj.rest.adapters;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.lodz.p.edu.zzpj.rest.command.ShopEquipmentCommandRest;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopEquipmentInputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;
import pl.lodz.p.edu.zzpj.rest.query.ShopEquipmentQueryRest;
import pl.zzpj.ports.command.ShopEquipment.ShopEquipmentCommandService;
import pl.zzpj.ports.query.ShopEquipment.ShopEquipmentQueryService;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.List;
import java.util.UUID;

@Component
public class ShopEquipmentRestAdapter implements ShopEquipmentCommandRest, ShopEquipmentQueryRest {

    private final ShopEquipmentCommandService commandService;
    private final ShopEquipmentQueryService queryService;

    @Autowired
    public ShopEquipmentRestAdapter(ShopEquipmentCommandService commandService, ShopEquipmentQueryService queryService) {
        this.commandService = commandService;
        this.queryService = queryService;
    }

    @Override
    public List<ShopEquipmentOutputDto> getAllShopEquipment() {
        return null;
    }

    @Override
    public List<ShopTireOutputDto> getAllTires() {
        return null;
    }

    @Override
    public ShopEquipmentOutputDto getTireById(UUID uuid) {
        return null;
    }

    @Override
    public ShopEquipmentOutputDto addEquipment(ShopEquipmentInputDto dto) {
        return null;
    }

    @Override
    public ShopEquipmentOutputDto updateEquipment(UUID id, ShopEquipmentInputDto dto) {
        return null;
    }

    @Override
    public void removeEquipment(UUID id) {

    }
}
