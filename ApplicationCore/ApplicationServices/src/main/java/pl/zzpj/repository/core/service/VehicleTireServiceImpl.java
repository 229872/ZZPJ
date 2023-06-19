package pl.zzpj.repository.core.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.BadEquipmentTireTypeException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceCreateException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceNotFoundException;
import pl.zzpj.repository.core.domain.exception.vehicleEquipment.VehicleEquipmentServiceUpdateException;
import pl.zzpj.repository.core.domain.model.vehicleModel.TireType;
import pl.zzpj.repository.core.domain.model.vehicleModel.VehicleTire;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandPort;
import pl.zzpj.repository.ports.command.vehicleEquipment.VehicleTireCommandService;
import pl.zzpj.repository.ports.command.weather.WeatherCommandService;
import pl.zzpj.repository.ports.query.vehicleEquipment.VehicleTireQueryPort;
import pl.zzpj.repository.ports.query.vehicleEquipment.VehicleTireQueryService;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@AllArgsConstructor
public class VehicleTireServiceImpl implements VehicleTireCommandService, VehicleTireQueryService {

    private final VehicleTireCommandPort commandPort;

    private final VehicleTireQueryPort queryPort;

    private final WeatherCommandService weatherCommandService;

    @Override
    public VehicleTire addEquipment(VehicleTire tire) throws VehicleEquipmentServiceCreateException {
        return commandPort.add(tire);
    }

    @Override
    public VehicleTire updateEquipment(UUID id, VehicleTire tire) throws
        VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException {
        VehicleTire existingTire = queryPort.getEquipmentById(id);
        existingTire.merge(tire);
        return commandPort.update(existingTire);
    }

    @Override
    public void removeEquipment(UUID id) {
        commandPort.remove(id);
    }

    @Override
    public VehicleTire setArchiveStatus(UUID id, boolean status)
        throws VehicleEquipmentServiceNotFoundException, VehicleEquipmentServiceUpdateException {
        VehicleTire existingTire = queryPort.getEquipmentById(id);
        existingTire.getEquipment().setArchive(status);
        return commandPort.update(existingTire);
    }

    @Override
    public List<VehicleTire> getAllEquipment() {
//        System.out.println(weatherCommandService.getWeatherForecast(57.75, 19.45));
        return queryPort.getAllEquipment();
    }

    @Override
    public VehicleTire getEquipmentById(UUID id) throws VehicleEquipmentServiceNotFoundException {
        return queryPort.getEquipmentById(id);
    }

    @Override
    public VehicleTire addEquipmentNoType(VehicleTire tire)
        throws VehicleEquipmentServiceCreateException, BadEquipmentTireTypeException {
        try {
            Random random = new Random();
            tire.setType(TireType.values()[random.nextInt(TireType.values().length)]);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new BadEquipmentTireTypeException(e.getMessage(), e.getCause());
        }
        return commandPort.add(tire);
    }
}
