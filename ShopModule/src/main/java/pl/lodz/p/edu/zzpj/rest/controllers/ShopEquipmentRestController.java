package pl.lodz.p.edu.zzpj.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.p.edu.zzpj.rest.adapters.ShopTiresRestAdapter;
import pl.lodz.p.edu.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;

@RestController
public class ShopEquipmentRestController {

    private ShopTiresRestAdapter restAdapter;

    @Autowired
    public ShopEquipmentRestController(ShopTiresRestAdapter shopTireRestAdapter) {
        this.restAdapter = shopTireRestAdapter;
    }

    void test() {
        ShopTireInputDto tire = new ShopTireInputDto();
        restAdapter.addEquipment(tire);
    }
}
