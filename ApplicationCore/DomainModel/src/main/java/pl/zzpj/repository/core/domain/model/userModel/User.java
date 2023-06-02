package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PROTECTED)
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
  private UserAccountInformations userAccountInformations;

  public Long getSumOfVersions() {
    return this.getVersion() + this.getPerson().getVersion() + this.getPerson().getAddress().getVersion();
  }

  public void update(User user) {
    this.phoneNumber = user.phoneNumber != null ? user.phoneNumber : phoneNumber;
    this.socialInsuranceNumber = user.socialInsuranceNumber != null ? user.socialInsuranceNumber : socialInsuranceNumber;
    this.creditCard = user.creditCard != null ? user.creditCard : creditCard;
    //todo
  }

  static UserBuilder builder(String login, String password, String email, Person person,
                                    UserRole role, UserState state, Double score) {
    return new UserBuilder().login(login).password(password).email(email).person(person)
            .userRole(role).userState(state).score(score);
  }

  public static UserBuilder userBuilderWithDefaultsForRestClientAdapter(String login, String password,
                                                                  String email, Person person) {

    return builder(login, password, email, person, UserRole.CLIENT, UserState.ACTIVE, 0.0);
  }

  public static UserBuilder userBuilderWithDefaultsForRestAdapter(String login, String password,
                                                                  String email, Person person,
                                                                  UserRole userRole) {

    return builder(login, password, email, person, userRole, UserState.ACTIVE, 0.0);
  }

  public static UserBuilder userBuilderWithDefaultsForRepositoryAdapter(UUID id, Long version, String login,
                                                                        String password, String email, Person person,
                                                                        UserRole userRole, UserState userState,
                                                                        Double score) {
    return builder(login, password, email, person, userRole, userState, score).clientId(id).version(version);
  }
}
