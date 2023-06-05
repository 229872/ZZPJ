package pl.zzpj.repository.rest.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record PersonalDataInputDto(
        UUID uid,
        String password,
        @JsonProperty("first_name") String firstName,
        @JsonProperty("last_name") String lastName,
        @JsonProperty("credit_card") CreditCardInputDto creditCard,
        String username,
        String email,
        String gender,
        @JsonProperty("phone_number") String phoneNumber,
        @JsonProperty("social_insurance_number") String socialInsuranceNumber,
        @JsonProperty("date_of_birth") LocalDate dateOfBirth

) {
}
