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
  private String login;
  private String password;
  private String email;
  private String phoneNumber;
  private String socialInsuranceNumber;
  private String creditCard;
  private Double score;
  private Person person;

  public static UserBuilder builder(String login, String password, String email, Person person) {
    return new UserBuilder().login(login).password(password).email(email).person(person);
  }
}
