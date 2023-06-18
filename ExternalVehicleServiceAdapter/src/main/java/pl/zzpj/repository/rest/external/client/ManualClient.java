package pl.zzpj.repository.rest.external.client;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.rest.external.adapter.VehicleRestClientAdapter;
import pl.zzpj.repository.rest.external.dto.VehicleInputDto;

@RestController
@RequestMapping(path = "/manual/vehicles")
@AllArgsConstructor
public class ManualClient {
    private final VehicleRestClientAdapter externalRestApiAdapter;
    private final ExternalClient externalClientRest;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/randomDto", consumes = MediaType.APPLICATION_JSON_VALUE)
    public void createVehicleFromRandomDto(@RequestBody VehicleInputDto dto) {
        externalRestApiAdapter.add(dto);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping(path = "/random")
    public void createRandomVehicle() {
        externalClientRest.getNewTireFromExternalService();
    }
}
