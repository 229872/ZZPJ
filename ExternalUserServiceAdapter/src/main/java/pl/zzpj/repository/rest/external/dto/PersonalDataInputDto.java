package pl.zzpj.repository.rest.external.dto;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record PersonalDataInputDto(
        UUID uid,
        String password,
        String first_name,
        String last_name,
        CreditCardInputDto credit_card,
        String username,
        String email,
        String gender,
        String phone_number,
        String social_insurance_number,
        LocalDate date_of_birth

) {
}
