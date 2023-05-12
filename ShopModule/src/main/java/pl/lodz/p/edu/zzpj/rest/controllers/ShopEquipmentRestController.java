package pl.lodz.p.edu.zzpj.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.p.edu.zzpj.rest.adapters.ShopEquipmentRestAdapter;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;

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
