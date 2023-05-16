package pl.zzpj.rest.api;

public interface RentVehiclesService {
    void addVehicle();
    void updateVehicle();
    void removeVehicle();
    void getAll();
    void getById();
    void getByMake();
    void getAllAvailable();
    void getAllByType();

}
