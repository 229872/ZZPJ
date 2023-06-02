package pl.zzpj.repository.rest.dto.output;

import lombok.Builder;
import java.util.UUID;

@Builder
public record UserOutputDTO(
        Long version,
        UUID clientId,
        String login,
        String email,
        String phoneNumber,
        String socialInsuranceNumber,
        String creditCard,
        Double score,
        PersonOutputDTO person,
        String role,
        String state,
        String timeZone,
        String locale,
        Boolean archive
        ) {
}
