package pl.zzpj.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.rest.adapters.ShopEquipmentRestAdapter;
import pl.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;

@RestController
public class ShopEquipmentRestController {

    private ShopEquipmentRestAdapter restAdapter;

    @Autowired
    public ShopEquipmentRestController(ShopEquipmentRestAdapter shopEquipmentRestAdapter) {
        this.restAdapter = shopEquipmentRestAdapter;
    }

    void test() {
        ShopTireInputDto tire = new ShopTireInputDto();
        restAdapter.addEquipment(tire);
    }
}
