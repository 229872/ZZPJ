package pl.zzpj.repository.rest.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pl.zzpj.repository.core.domain.exception.rent.*;
import pl.zzpj.repository.core.domain.exception.user.UserServiceNotFoundException;
import pl.zzpj.repository.core.domain.model.rentModel.RentStatus;
import pl.zzpj.repository.rest.adapter.RentRestAdapter;
import pl.zzpj.repository.rest.dto.CreateRentDto;
import pl.zzpj.repository.rest.dto.PriceDto;
import pl.zzpj.repository.rest.dto.RentDto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("rents")
@AllArgsConstructor
public class RentController {

    private RentRestAdapter adapter;

    @PostMapping(value = "calculate",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public PriceDto calculatePrice(@RequestBody @NotNull @Valid CreateRentDto createRentDto) throws UserServiceNotFoundException {
        return adapter.calculatePrice(createRentDto.getVehicleId(),
                createRentDto.getUserId(),
                createRentDto.getDeclaredStart(),
                createRentDto.getDeclaredEnd());
    }

    @PostMapping(value = "",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto createRent(@RequestBody @NotNull @Valid CreateRentDto createRentDto)
            throws RentInvalidDatePeriodException, UserServiceNotFoundException {
        return adapter.createRent(createRentDto.getUserId(),
                createRentDto.getVehicleId(),
                createRentDto.getDeclaredStart(),
                createRentDto.getDeclaredEnd());
    }

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentDto> findAllRents() {
        return adapter.findAllRents();
    }

    @GetMapping(value = "{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto findRent(@PathVariable UUID uuid) throws RentNotFoundException {
        return adapter.findRent(uuid);
    }

    @GetMapping(value = "user/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentDto> findRentsByUser(@PathVariable UUID uuid) {
        return adapter.findRentsByUser(uuid);
    }

    @GetMapping(value = "vehicle/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentDto> findFutureRentsByVehicle(@PathVariable UUID uuid) {
        return adapter.findFutureRentsByVehicle(uuid);
    }
    @GetMapping(value = "vehicle/{uuid}/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentDto> findAllRentsByVehicle(@PathVariable UUID uuid) {
        return adapter.findAllRentsByVehicle(uuid);
    }

    @GetMapping(value = "status/{status}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentDto> findRentsByStatus(@PathVariable RentStatus status) {
        return adapter.findRentsByStatus(status);
    }

    @GetMapping(value = "to-issue/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentDto> findRentsToIssue(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return adapter.findRentsToIssue(date);
    }

    @GetMapping(value = "to-return/{date}", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<RentDto> findRentsToReturn(
            @PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime date) {
        return adapter.findRentsToReturn(date);
    }

    @PutMapping(value = "cancel/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto cancelRent(@PathVariable UUID uuid)
            throws RentNotCancellableException, RentNotFoundException {
        return adapter.cancelRent(uuid);
    }

    @PutMapping(value = "issue/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto issueVehicle(@PathVariable UUID uuid)
            throws RentCannotIssueVehicleException, RentNotFoundException {
        return adapter.issueVehicle(uuid);
    }

    @PutMapping(value = "return/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto returnVehicle(@PathVariable UUID uuid)
            throws RentNotFoundException, RentVehicleNotIssuedException {
        return adapter.returnVehicle(uuid);
    }

    @PutMapping(value = "return-damaged/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto returnDamagedVehicle(@PathVariable UUID uuid)
            throws RentNotFoundException, RentVehicleNotIssuedException {
        return adapter.returnDamagedVehicle(uuid);
    }

    @PutMapping(value = "return-missing/{uuid}", produces = MediaType.APPLICATION_JSON_VALUE)
    public RentDto returnMissingVehicle(@PathVariable UUID uuid)
            throws RentNotFoundException, RentVehicleNotIssuedException {
        return adapter.returnMissingVehicle(uuid);
    }
}
