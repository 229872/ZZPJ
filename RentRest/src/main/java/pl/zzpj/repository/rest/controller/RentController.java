package pl.zzpj.repository.rest.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.rest.adapter.RentRestAdapter;
import pl.zzpj.repository.rest.dto.get.RentDto;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("rent")
@AllArgsConstructor
public class RentController {

    private RentRestAdapter adapter;

    @GetMapping
    public List<RentDto> getAllRents() {
        return null;
    }

    @GetMapping(value = "{uuid}")
    public RentDto getRent(@PathVariable UUID uuid) {
        return null;
    }


}
