package pl.zzpj.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration(value = "WeatherBuilder")
public class WeatherConfig {

    @Bean
    public WebClient.Builder getWeatherClientBuilder() {
        return WebClient.builder();
    }
}
