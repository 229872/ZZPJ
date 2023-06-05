package pl.zzpj.repository.rest.external.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreditCardInputDto (@JsonProperty("cc_number") String ccNumber) {
}
