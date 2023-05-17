package pl.zzpj.rest.dto.output;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserOutputDTO {
  private UUID clientId;
  private String login;
  private String email;
  private String phoneNumber;
  private String socialInsuranceNumber;
  private String creditCard;
  private Double score;
  private PersonOutputDTO person;
}
