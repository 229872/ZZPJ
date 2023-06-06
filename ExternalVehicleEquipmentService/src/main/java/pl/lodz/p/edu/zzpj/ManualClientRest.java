package pl.lodz.p.edu.zzpj;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import pl.lodz.p.edu.zzpj.api.RandomApi;
import pl.lodz.p.edu.zzpj.dto.RandomDto;

@RestController
@RequestMapping(path = "/manual/tires")
@AllArgsConstructor
public class ManualClientRest {

    private final RandomApi externalRestApiAdapter;
    private final ExternalClientRest externalClientRest; //todo remove

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "randomDto", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createTireFromRandomDto(@RequestParam(required = false) Integer type, @RequestBody RandomDto dto) {
        externalRestApiAdapter.addRandomVehicleTire(dto, type);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "random", produces = MediaType.APPLICATION_JSON_VALUE)
    public void createRandomTire() {
        externalClientRest.getNewTireFromExternalService();
    }

}
