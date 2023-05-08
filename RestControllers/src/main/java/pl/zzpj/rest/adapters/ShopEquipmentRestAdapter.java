package pl.zzpj.rest.adapters;


import org.springframework.stereotype.Component;
import pl.zzpj.rest.command.ShopEquipmentCommandRest;
import pl.zzpj.rest.dto.shopEquipment.Input.ShopEquipmentInputDto;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;
import pl.zzpj.rest.query.ShopEquipmentQueryRest;

import java.util.List;
import java.util.UUID;

@Component
public class ShopEquipmentRestAdapter implements ShopEquipmentCommandRest, ShopEquipmentQueryRest {


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
