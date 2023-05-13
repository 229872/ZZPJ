package pl.zzpj.core.domain.model.clientModel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.util.UUID;

@Data
@AllArgsConstructor
public class User {
  private UUID clientId;
  private String name;
  private String lastName;
  private String login;
  private String password;
  private String email;
  private String gender;
  private LocalDate dateOfBirth;
  private Address address;
}
