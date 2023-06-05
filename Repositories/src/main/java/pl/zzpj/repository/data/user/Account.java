package pl.zzpj.repository.data.user;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;
import pl.zzpj.repository.data.AbstractEntity;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
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
  @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
  @JoinColumn(nullable = false, unique = true)
  private Person person;
  @Enumerated(value = EnumType.STRING)
  @Column(name = "time_zone")
  private TimeZone timeZone;
  @Enumerated(value = EnumType.STRING)
  @Column(nullable = false)
  private Role role;
  @Enumerated(value = EnumType.STRING)
  @Column(name = "account_state", nullable = false)
  private AccountState accountState;
  @Column(nullable = false)
  private String locale;
  @Column(name = "last_correct_authentication_ip")
  private String lastIpLogin;
  @Column(name = "last_failed_authentication_ip")
  private String lastIpWrongLogin;
  @Column(name = "failed_login_counter")
  private Integer failedLoginCounter;
  @Column(name = "last_correct_authentication_time")
  private LocalDateTime lastCorrectAuthenticationTime;
  @Column(name = "last_failed_authentication_time")
  private LocalDateTime lastFailedAuthenticationTime;
  @Column(name = "blockade_begin")
  private LocalDateTime blockadeBegin;
  @Column(name = "blockade_end")
  private LocalDateTime blockadeEnd;


  public static AccountBuilder<?,?> builder(String login, String password, String email, Person person,
                                            Role role, AccountState state) {

    return new AccountBuilderImpl().login(login).password(password).email(email).person(person)
            .role(role).accountState(state);
  }

  @PrePersist
  public void init() {
    this.score = score == null ? 0.0 : score;
    this.locale = locale == null ? "en" : locale;
    this.failedLoginCounter = 0;
  }

}
