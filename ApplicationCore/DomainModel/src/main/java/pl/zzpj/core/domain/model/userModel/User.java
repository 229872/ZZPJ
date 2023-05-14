package pl.zzpj.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
  private UUID clientId;
  private String login;
  private String password;
  private String email;
  private Person person;
}
