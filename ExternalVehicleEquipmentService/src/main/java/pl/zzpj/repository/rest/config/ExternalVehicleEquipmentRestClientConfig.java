package pl.zzpj.repository.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration(value = "VehicleEquipmentBuilder")
public class ExternalVehicleEquipmentRestClientConfig {

    @Bean(name = "vehicleEquipment", autowireCandidate = false) //TODO FIXME
    public WebClient.Builder getVehicleEquipmentBuilder() {
        return WebClient.builder();
    }
}
