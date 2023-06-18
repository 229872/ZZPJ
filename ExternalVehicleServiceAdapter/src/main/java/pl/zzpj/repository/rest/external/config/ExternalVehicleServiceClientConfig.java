package pl.zzpj.repository.rest.external.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration(value = "VehicleBuilder")
public class ExternalVehicleServiceClientConfig {

    @Bean(name = "vehicle", autowireCandidate = false)
    public WebClient.Builder getVehicleEquipmentBuilder() {
        return WebClient.builder();
    }
}
