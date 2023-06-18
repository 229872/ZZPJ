package pl.zzpj.repository.adapter.Vehicles;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.adapter.Vehicles.mapper.VehicleFromDataToDomain;
import pl.zzpj.repository.adapter.Vehicles.mapper.VehicleFromDomainToData;
import pl.zzpj.repository.api.RentVehiclesRepository;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.ConditionRating;
import pl.zzpj.repository.core.domain.model.rentModel.vehicles.Vehicle;
import pl.zzpj.repository.data.vehicle.VehicleEnt;
import pl.zzpj.repository.ports.command.rent.RentVehiclesCommandPort;
import pl.zzpj.repository.ports.query.rent.RentVehiclesQueryPort;

import java.util.List;
import java.util.UUID;

@Component
public class RentVehiclesRepositoryAdapter implements RentVehiclesCommandPort, RentVehiclesQueryPort {

    @Autowired
    private RentVehiclesRepository vehiclesRepository;

    @Override
    public Vehicle add(Vehicle vehicle) {
        return VehicleFromDataToDomain.map(vehiclesRepository.save(VehicleFromDomainToData.map(vehicle)));
    }

    @Override
    public Vehicle update(Vehicle vehicle) {
        return VehicleFromDataToDomain.map(vehiclesRepository.save(VehicleFromDomainToData.map(vehicle)));
    }

    @Override
    public void remove(UUID id) {
        vehiclesRepository.deleteById(id);
    }

    @Override
    public Vehicle getById(UUID id) {
        return VehicleFromDataToDomain.map(vehiclesRepository.findById(id).get());
    }

    @Override
    public List<Vehicle> getAllByMake(String make) {
        List<VehicleEnt> vehicleEnts = vehiclesRepository.findByMake(make);

        return VehicleFromDataToDomain.mapList(vehicleEnts);
    }

    @Override
    public List<Vehicle> getAll() {
        return VehicleFromDataToDomain.mapList(vehiclesRepository.findAll());
    }

    @Override
    public List<Vehicle> getAllAvailable() {
        return VehicleFromDataToDomain.mapList(vehiclesRepository.findByisAvailableTrue());
    }

    @Override
    public List<Vehicle> getAllByRating(String rating) {
        return VehicleFromDataToDomain.mapList(vehiclesRepository.findByRating(ConditionRating.getByName(rating)));
    }

    @Override
    public List<Vehicle> getAllByType(String type) {
        return null;
    }
}
