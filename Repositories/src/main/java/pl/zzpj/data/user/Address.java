package pl.zzpj.data.user;

import jakarta.persistence.*;
import lombok.*;
import pl.zzpj.repository.data.AbstractEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@SecondaryTable(
        name = "address_additional_data",
        pkJoinColumns = @PrimaryKeyJoinColumn(name = "address_id")
)
public class Address extends AbstractEntity {
  @Column(nullable = false)
  private String country;
  @Column(name = "country_code")
  private String countryCode;
  @Column(nullable = false)
  private String city;
  @Column(name = "street_name", nullable = false)
  private String streetName;
  @Column(name = "street_address", nullable = false)
  private String streetAddress;
  @Column(name = "secondary_address")
  private String secondaryAddress;
  @Column(name = "building_number")
  private Integer buildingNumber;
  @Column(name = "mail_box")
  private String mailBox;
  @Column(name = "zip_code")
  private String zipCode;

  @Column(table = "address_additional_data")
  private String community;
  @Column(table = "address_additional_data")
  private String zip;
  @Column(name = "time_zone", table = "address_additional_data")
  private String timeZone;
  @Column(name = "street_suffix", table = "address_additional_data")
  private String streetSuffix;
  @Column(name = "city_suffix", table = "address_additional_data")
  private String citySuffix;
  @Column(name = "city_prefix", table = "address_additional_data")
  private String cityPrefix;
  @Column(table = "address_additional_data")
  private String state;
  @Column(name = "state_abbr", table = "address_additional_data")
  private String stateAbbr;
  @Embedded
  private Coordinates coordinates;
  @Column(name = "full_address", table = "address_additional_data")
  private String fullAddress;


}
