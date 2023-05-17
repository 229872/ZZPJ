package pl.zzpj.repository.rest.adapter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.service.RentVehicleServiceImpl;
import pl.zzpj.repository.rest.dto.mapper.VehicleFromDtoToDomain;
import pl.zzpj.repository.rest.api.RentVehiclesService;
import pl.zzpj.repository.rest.dto.VehicleDto;
import pl.zzpj.repository.rest.dto.mapper.VehicleFromDomainToDto;

import java.util.List;
import java.util.UUID;


@Component
public class RentVehiclesAdapter implements RentVehiclesService {

    @Autowired
    private RentVehicleServiceImpl vehicleService;

    @Override
    public VehicleDto addVehicle(VehicleDto vehicle) {
        return VehicleFromDomainToDto.map(vehicleService.addVehicle(VehicleFromDtoToDomain.map(vehicle)));
    }

    @Override
    public VehicleDto updateVehicle(UUID id, VehicleDto vehicle) {
        return VehicleFromDomainToDto.map(vehicleService.updateVehicle(id, VehicleFromDtoToDomain.map(vehicle)));
    }

    @Override
    public void switchAvailability(UUID id) {
        //TODO
    }

    @Override
    public void removeVehicle(UUID id) {
        vehicleService.removeVehicle(id);
    }

    @Override
    public List<VehicleDto> getAll() {
        return VehicleFromDomainToDto.mapList(vehicleService.findAll());
    }

    @Override
    public VehicleDto getById(UUID id) {
        return VehicleFromDomainToDto.map(vehicleService.findById(id));
    }

    @Override
    public List<VehicleDto> getAllByMake(String make) {
        return VehicleFromDomainToDto.mapList(vehicleService.findAllByMake(make));
    }

    @Override
    public List<VehicleDto> getAllAvailable() {
        return VehicleFromDomainToDto.mapList(vehicleService.findAllAvailable());
    }


}
