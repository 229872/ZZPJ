package pl.zzpj.data.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Address {
  private String country;
  @Column(name = "country_code")
  private String countryCode;
  private String city;
  @Column(name = "street_name")
  private String streetName;
  @Column(name = "street_address")
  private String streetAddress;
  @Column(name = "secondary_address")
  private String secondaryAddress;
  @Column(name = "building_number")
  private Integer buildingNumber;
  @Column(name = "mail_box")
  private String mailBox;
  private String community;
  @Column(name = "zip_code")
  private String zipCode;
  private String zip;
  @Column(name = "time_zone")
  private String timeZone;
  @Column(name = "street_suffix")
  private String streetSuffix;
  @Column(name = "city_suffix")
  private String citySuffix;
  @Column(name = "city_prefix")
  private String cityPrefix;
  private String state;
  @Column(name = "state_abbr")
  private String stateAbbr;
  @Embedded
  private Coordinates coordinates;
  @Column(name = "full_address")
  private String fullAddress;


}
