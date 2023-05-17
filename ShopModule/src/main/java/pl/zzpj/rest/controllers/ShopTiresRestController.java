package pl.zzpj.rest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.core.domain.exception.BadEquipmentTypeException;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.rest.adapters.ShopTiresRestAdapter;
import pl.zzpj.rest.dto.shopEquipment.Input.ShopTireInputDto;
import pl.zzpj.rest.dto.shopEquipment.Output.ShopTireOutputDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/shop/tires")
public class ShopTiresRestController {

    private final ShopTiresRestAdapter restAdapter;

    @Autowired
    public ShopTiresRestController(ShopTiresRestAdapter shopTireRestAdapter) {
        this.restAdapter = shopTireRestAdapter;
    }

    @GetMapping(path = "/")
    public List<ShopTireOutputDto> getAll() {
        return restAdapter.getAllEquipment();
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<ShopTireOutputDto> getEquipmentById(@PathVariable("id") UUID id)
            throws EquipmentNotFoundServiceException {
        return ResponseEntity.ok().body(restAdapter.getEquipmentById(id));
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/")
    public ShopTireOutputDto createEquipment(@RequestBody ShopTireInputDto dto) {
        return restAdapter.addEquipment(dto);
    }

    @PutMapping(path = "/{id}")
    public ShopTireOutputDto updateEquipment(@PathVariable UUID id, @RequestBody ShopTireInputDto dto)
            throws BadEquipmentTypeException, EquipmentNotFoundServiceException {
        return restAdapter.updateEquipment(id, dto);
    }
}
