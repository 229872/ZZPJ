package pl.zzpj.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.rest.adapters.ShopTiresRestAdapter;

@RestController
@RequestMapping("/shop/tires")
public class ShopTiresRestController {

    private final ShopTiresRestAdapter restAdapter;

    @Autowired
    public ShopTiresRestController(ShopTiresRestAdapter shopTireRestAdapter) {
        this.restAdapter = shopTireRestAdapter;
    }

    @GetMapping(value = "/test")
    @ResponseBody
    public String test() {
        return "Hello world";
    }
}
