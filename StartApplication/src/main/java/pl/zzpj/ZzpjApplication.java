package pl.zzpj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"pl"})
public class ZzpjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzpjApplication.class, args);
    }

}
