package pl.zzpj.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.exception.shopEquipment.EquipmentNotFoundServiceException;
import pl.zzpj.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.ports.command.rent.RentVehiclesCommandPort;
import pl.zzpj.ports.command.rent.RentVehiclesCommandService;
import pl.zzpj.ports.query.rent.RentVehiclesQueryPort;
import pl.zzpj.ports.query.rent.RentVehiclesQueryService;

import java.util.List;
import java.util.UUID;

@Component
public class RentVehicleServiceImpl implements RentVehiclesCommandService, RentVehiclesQueryService {

    @Autowired
    private RentVehiclesCommandPort vehiclesCommandPort;
    @Autowired
    private RentVehiclesQueryPort vehiclesQueryPort;


    @Override
    public Vehicle addVehicle(Vehicle o) {
        return vehiclesCommandPort.add(o);
    }

    @Override
    public Vehicle updateVehicle(UUID id, Vehicle o)  {
        return vehiclesCommandPort.update(o);
    }

    @Override
    public void switchAvailability(UUID id) {
        //TODO implement
    }

    @Override
    public void removeVehicle(UUID id) {
        vehiclesCommandPort.remove(id);
    }

    @Override
    public Vehicle findById(UUID id) {
        return vehiclesQueryPort.getById(id);
    }

    @Override
    public List<Vehicle> findAllByMake(String make) {
        return vehiclesQueryPort.getAllByMake(make);
    }

    @Override
    public List<Vehicle> findAll() {
        return vehiclesQueryPort.getAll();
    }

    @Override
    public List<Vehicle> findAllAvailable() {
        return vehiclesQueryPort.getAllAvailable();
    }



}
