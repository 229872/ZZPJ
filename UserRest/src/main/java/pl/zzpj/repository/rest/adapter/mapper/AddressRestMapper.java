package pl.zzpj.repository.rest.adapter.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.Address;
import pl.zzpj.repository.rest.dto.input.AddressInputDTO;
import pl.zzpj.repository.rest.dto.output.AddressOutputDTO;

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
            .country(address.country())
            .countryCode(address.countryCode())
            .city(address.city())
            .streetName(address.streetName())
            .streetAddress(address.streetAddress())
            .zipCode(address.zipCode())
            .build();
  }
}
