package pl.lodz.p.edu.zzpj.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.p.edu.zzpj.rest.adapters.ShopTiresRestAdapter;

@RestController(value = "/tires")
public class ShopTiresRestController extends ShopEquipmentAbstractController {

    private ShopTiresRestAdapter restAdapter;

    @Autowired
    public ShopTiresRestController(ShopTiresRestAdapter shopTireRestAdapter) {
        this.restAdapter = shopTireRestAdapter;
    }

    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> test() {
        return new ResponseEntity<String>("Hello world", HttpStatus.OK);
    }
}
