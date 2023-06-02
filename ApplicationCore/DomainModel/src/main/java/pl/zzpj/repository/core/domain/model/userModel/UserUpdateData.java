package pl.zzpj.repository.core.domain.model.userModel;

import lombok.Builder;

@Builder
public record UserUpdateData (
        String phoneNumber,
        String socialInsuranceNumber,
        String creditCard,
        String locale,
        String name,
        String lastName,
        String country,
        String city,
        String streetName,
        String streetNumber,
        String postalCode,
        String secondaryAddress,
        Integer buildingNumber,
        String mailBox,
        String state
) {

}
