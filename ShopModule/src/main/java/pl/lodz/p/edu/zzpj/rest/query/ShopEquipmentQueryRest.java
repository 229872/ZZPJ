package pl.lodz.p.edu.zzpj.rest.query;

import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopEquipmentOutputDto;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.List;
import java.util.UUID;

public interface ShopEquipmentQueryRest {

    List<ShopEquipmentOutputDto> getAllShopEquipment();

    List<ShopTireOutputDto> getAllTires();

    ShopEquipmentOutputDto getTireById(UUID uuid);
}
