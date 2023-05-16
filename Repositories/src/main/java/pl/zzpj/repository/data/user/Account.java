package pl.zzpj.repository.data.user;

import jakarta.persistence.*;
import lombok.*;
import pl.zzpj.repository.data.AbstractEntity;

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@Entity
@Table(indexes = {
        @Index(name = "score_index", columnList = "score")
})
@AttributeOverride(name = "id", column = @Column(name = "account_id"))
public class Account extends AbstractEntity {
  @Column(unique = true, nullable = false, updatable = false)
  private String login;
  @Column(nullable = false)
  private String password;
  @Column(unique = true, nullable = false, updatable = false)
  private String email;
  @Column(name = "phone_number", unique = true)
  private String phoneNumber;
  @Column(name = "social_insurance_number", unique = true)
  private String socialInsuranceNumber;
  @Column(name = "credit_card", unique = true)
  private String creditCard;
  @Column(nullable = false)
  private Double score;
  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
  @JoinColumn(nullable = false, unique = true)
  private Person person;

}
