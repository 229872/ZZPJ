package pl.zzpj.repository;

import jakarta.annotation.security.DeclareRoles;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import static pl.zzpj.repository.utils.security.RoleName.*;


@SpringBootApplication
//@EnableScheduling
@DeclareRoles({GUEST, ADMIN, CLIENT})
public class ZzpjApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZzpjApplication.class, args);
    }


}
