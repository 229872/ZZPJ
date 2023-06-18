package pl.zzpj.repository.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.rest.adapter.RentRestAdapter;
import pl.zzpj.repository.rest.dto.RentDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("rent")
@AllArgsConstructor
public class RentController {

    private RentRestAdapter adapter;

    @GetMapping
    public List<RentDto> getAllRents() {
        return adapter.findAllRents();
    }

    @GetMapping(value = "{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto getRent(@PathVariable UUID uuid) {
        return adapter.findRent(uuid);
    }


}
