package pl.zzpj.repository.rest.external.dto;

public record UserInputDto (PersonalDataInputDto user, AddressInputDto address, String timeZone) {
}
