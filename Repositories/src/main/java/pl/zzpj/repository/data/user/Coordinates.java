package pl.zzpj.repository.data.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Coordinates {
  @Column(name = "lat", table = "address_additional_data")
  private Double latitude;
  @Column(name = "lng", table = "address_additional_data")
  private Double longtitude;
}
