package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Builder
@Data
public class UserAccountInformations {
  private Integer failedLoginCounter;
  private String lastLoginIpAddress;
  private String lastFailedLoginIpAddress;
  private LocalDateTime lastCorrectAuthenticationTime;
  private LocalDateTime lastFailedAuthenticationTime;
  private LocalDateTime blockadeStart;
  private LocalDateTime blockadeEnd;
}
