package pl.zzpj.repository.adapter.user.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.data.user.Address;

@Component
public class AddressMapper {
  public Address mapToDatabaseAddress(pl.zzpj.repository.core.domain.model.userModel.Address address) {
    return Address.builder()
            .country(address.getCountry())
            .countryCode(address.getCountryCode())
            .city(address.getCity())
            .streetName(address.getStreetName())
            .streetAddress(address.getStreetAddress())
            .zipCode(address.getZipCode())
            .build();
  }

  public pl.zzpj.repository.core.domain.model.userModel.Address mapToDomainModelAddress(Address address) {
    return pl.zzpj.repository.core.domain.model.userModel.Address.builder()
            .country(address.getCountry())
            .countryCode(address.getCountryCode())
            .city(address.getCity())
            .streetName(address.getStreetName())
            .streetAddress(address.getStreetAddress())
            .zipCode(address.getZipCode())
            .build();
  }
}
