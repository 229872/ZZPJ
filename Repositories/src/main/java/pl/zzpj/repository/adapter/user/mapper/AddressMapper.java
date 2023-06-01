package pl.zzpj.repository.adapter.user.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.data.user.Address;
import pl.zzpj.repository.data.user.Coordinates;

@Component
public class AddressMapper {
  public Address mapToDatabaseAddress(pl.zzpj.repository.core.domain.model.userModel.Address address) {
    Address.AddressBuilder builder = Address.builder(
            address.getCountry(),
            address.getCity(),
            address.getStreetName(),
            address.getStreetNumber(),
            address.getPostalCode(),
            address.getFullAddress()
    );

    return builder
            .secondaryAddress(address.getSecondaryAddress())
            .buildingNumber(address.getBuildingNumber())
            .mailBox(address.getMailBox())
            .timeZone(address.getTimeZone())
            .state(address.getState())
            .coordinates(new Coordinates(address.getLatitude(), address.getLongitude()))
            .community(address.getCommunity())
            .countryCode(address.getCountryCode())
            .streetSuffix(address.getStreetSuffix())
            .cityPrefix(address.getCityPrefix())
            .citySuffix(address.getCitySuffix())
            .stateAbbr(address.getStateAbbr())
            .build();

  }

  public pl.zzpj.repository.core.domain.model.userModel.Address mapToDomainModelAddress(Address address) {
    var builder = pl.zzpj.repository.core.domain.model.userModel.Address.builder(
            address.getCountry(),
            address.getCity(),
            address.getStreetName(),
            address.getStreetNumber(),
            address.getPostalCode()
    );

    return builder
            .secondaryAddress(address.getSecondaryAddress())
            .buildingNumber(address.getBuildingNumber())
            .mailBox(address.getMailBox())
            .timeZone(address.getTimeZone())
            .state(address.getState())
            .longitude(address.getCoordinates().map(Coordinates::getLongitude).orElse(null))
            .latitude(address.getCoordinates().map(Coordinates::getLatitude).orElse(null))
            .community(address.getCommunity())
            .countryCode(address.getCountryCode())
            .streetSuffix(address.getStreetSuffix())
            .cityPrefix(address.getCityPrefix())
            .citySuffix(address.getCitySuffix())
            .stateAbbr(address.getStateAbbr())
            .build();
  }
}
