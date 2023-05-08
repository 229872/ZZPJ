package pl.zzpj.rest.query;

import pl.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.List;
import java.util.UUID;

public interface ShopEquipmentQueryRest {

    List<ShopEquipmentOutputDto> getAllShopEquipment();

    List<ShopTireOutputDto> getAllTires();

    ShopEquipmentOutputDto getTireById(UUID uuid);
}
