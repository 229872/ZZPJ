package pl.zzpj.repository.rest.adapter.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.Address;
import pl.zzpj.repository.rest.dto.input.AddressInputDTO;
import pl.zzpj.repository.rest.dto.output.AddressOutputDTO;
import pl.zzpj.repository.rest.dto.output.CoordinatesDto;

@Component
public class AddressRestMapper {
  public AddressOutputDTO mapToAddressOutputDTO(Address address) {
    return new AddressOutputDTO(
            address.getCountry(),
            address.getCity(),
            address.getStreetName(),
            address.getStreetNumber(),
            address.getPostalCode(),
            address.getFullAddress(),
            address.getSecondaryAddress(),
            address.getBuildingNumber(),
            address.getMailBox(),
            address.getState(),
            new CoordinatesDto(address.getLongitude(), address.getLatitude()),
            address.getCommunity(),
            address.getCountryCode(),
            address.getStreetSuffix(),
            address.getCityPrefix(),
            address.getCitySuffix(),
            address.getStateAbbr()
    );
  }

  public Address mapToDomainModelAddress(AddressInputDTO address) {
    Address.AddressBuilder builder = Address.builder(
            address.country(),
            address.city(),
            address.streetName(),
            address.streetNumber(),
            address.postalCode()
    );

    return builder
            .secondaryAddress(address.secondaryAddress())
            .buildingNumber(address.buildingNumber())
            .mailBox(address.mailBox())
            .state(address.state())
            .longitude(address.longitude())
            .latitude(address.latitude())
            .community(address.community())
            .build();
  }
}
