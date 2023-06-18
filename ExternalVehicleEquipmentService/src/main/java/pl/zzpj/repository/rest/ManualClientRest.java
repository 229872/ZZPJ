package pl.zzpj.repository.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.zzpj.repository.rest.api.RandomVehicleTireApi;
import pl.zzpj.repository.rest.dto.RandomVehicleTireDto;

@RestController
@RequestMapping(path = "/manual/tires")
@AllArgsConstructor
public class ManualClientRest {

    private final RandomVehicleTireApi externalRestApiAdapter;
    private final ExternalClientRest externalClientRest; //todo remove

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "randomDto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createTireFromRandomDto(@RequestParam(required = false) Integer type, @RequestBody RandomVehicleTireDto dto) {
        externalRestApiAdapter.addRandomVehicleTire(dto, type);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/random")
    public void createRandomTire() {
        externalClientRest.getNewTireFromExternalService();
    }

}
