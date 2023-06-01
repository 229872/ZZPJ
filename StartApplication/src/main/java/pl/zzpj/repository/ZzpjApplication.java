package pl.zzpj.repository;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ZzpjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzpjApplication.class, args);
    }
}
