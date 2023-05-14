package pl.zzpj.repository.data.user;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zzpj.repository.data.AbstractEntity;

import java.time.LocalDate;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Person extends AbstractEntity {
  private String firstName;
  private String lastName;
  private String gender;
  @Column(name = "date_of_birth")
  private LocalDate dateOfBirth;
  @Embedded
  private Address address;
}
