package pl.zzpj.repository.data.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.zzpj.repository.data.AbstractEntity;

import java.time.LocalDate;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PROTECTED)
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Entity
@Table(indexes = {
        @Index(name = "first_name_index", columnList = "firstName"),
        @Index(name = "last_name_index", columnList = "lastName")
})
@AttributeOverride(name = "id", column = @Column(name = "person_id"))
public class Person extends AbstractEntity {
  @Column(nullable = false)
  private String firstName;
  @Column(nullable = false)
  private String lastName;
  @Column(nullable = false, updatable = false)
  private String gender;
  @Column(name = "date_of_birth", nullable = false)
  private LocalDate dateOfBirth;
  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  @JoinColumn(unique = true, nullable = false)
  private Address address;

  public static PersonBuilder<?,?> builder(String firstName, String lastName, String gender,
                                           LocalDate dateOfBirth, Address address) {
    return new PersonBuilderImpl().firstName(firstName).lastName(lastName).gender(gender)
            .dateOfBirth(dateOfBirth).address(address);
  }
}


