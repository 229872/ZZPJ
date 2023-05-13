package pl.zzpj.repository.data.user;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.zzpj.repository.data.AbstractEntity;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account extends AbstractEntity {

  private String login;
  private String password;
  private String email;
  @Column(name = "phone_number")
  private String phoneNumber;
  @Column(name = "social_insurance_number")
  private String socialInsuranceNumber;
  @Column(name = "credit_card")
  private String creditCard;
  @OneToOne
  @JoinColumn(nullable = false, unique = true)
  private Person person;

}
