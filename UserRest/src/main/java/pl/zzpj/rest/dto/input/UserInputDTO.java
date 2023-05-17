package pl.zzpj.rest.dto.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserInputDTO {
  @NotBlank(message = "login can't be empty")
  private String login;
  @NotBlank
  @Size(min = 8)
  private String password;
  @Email
  @NotBlank
  private String email;
  @NotNull
  @Valid
  private PersonInputDTO person;
  private String phoneNumber;
  private String socialInsuranceNumber;
  private String creditCard;
  private Double score;

}
