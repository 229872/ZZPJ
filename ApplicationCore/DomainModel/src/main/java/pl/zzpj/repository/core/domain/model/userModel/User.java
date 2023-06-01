package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class User {
  private UUID clientId;
  private Long version;
  private String login;
  private String password;
  private String email;
  private String phoneNumber;
  private String socialInsuranceNumber;
  private String creditCard;
  private Double score;
  private Person person;
  private UserRole userRole;
  private UserState userState;
  private UserTimeZone userTimeZone;
  private String locale;
  private boolean archive;
  private UserAccountInformations userAccountInformations;

  public Long getSumOfVersions() {
    return this.getVersion() + this.getPerson().getVersion() + this.getPerson().getAddress().getVersion();
  }

  //todo create factory methods in service with default values
  public static UserBuilder builder(String login, String password, String email, Person person,
                                    UserRole role, UserState state, Boolean archive, Double score) {
    return new UserBuilder().login(login).password(password).email(email).person(person)
            .userRole(role).userState(state).archive(archive).score(score);
  }
}
