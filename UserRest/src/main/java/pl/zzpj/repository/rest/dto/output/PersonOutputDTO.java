package pl.zzpj.repository.rest.dto.output;


import lombok.Builder;
import java.time.LocalDate;


@Builder
public record PersonOutputDTO(String firstName, String lastName, String gender, LocalDate dateOfBirth,
                             AddressOutputDTO address) {

}
