package pl.zzpj.ports.command.ShopEquipment;

import pl.zzpj.core.domain.model.shopModel.ShopEquipment;

import java.util.UUID;

public interface ShopEquipmentCommandService {

    ShopEquipment addEquipment(ShopEquipment equipment); //todo throws

    ShopEquipment updateEquipment(UUID id, ShopEquipment equipment); //todo throws

    void removeEquipment(UUID id); //todo

}
