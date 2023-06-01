package pl.zzpj.repository.rest.external.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserInputDto(
        UUID uid,
        String password,
        String first_name,
        String last_name,
        String username,
        String email,
        String gender

) {
}
