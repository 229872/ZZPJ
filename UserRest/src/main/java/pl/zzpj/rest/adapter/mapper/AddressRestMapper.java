package pl.zzpj.rest.adapter.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.userModel.Address;
import pl.zzpj.rest.dto.input.AddressInputDTO;
import pl.zzpj.rest.dto.output.AddressOutputDTO;

@Component
public class AddressRestMapper {
  public AddressOutputDTO mapToAddressOutputDTO(Address address) {
    return AddressOutputDTO.builder()
            .country(address.getCountry())
            .countryCode(address.getCountryCode())
            .city(address.getCity())
            .streetName(address.getStreetName())
            .streetAddress(address.getStreetAddress())
            .build();
  }

  public Address mapToDomainModelAddress(AddressInputDTO address) {
    return Address.builder()
            .country(address.getCountry())
            .countryCode(address.getCountryCode())
            .city(address.getCity())
            .streetName(address.getStreetName())
            .streetAddress(address.getStreetAddress())
            .zipCode(address.getZipCode())
            .build();
  }
}
