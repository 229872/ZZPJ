package pl.zzpj.repository.core.domain.model.userModel;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@AllArgsConstructor
@Data
public class UserAccountInformations {
  private Integer failedLoginCounter;
  private String lastLoginIpAddress;
  private String lastFailedLoginIpAddress;
  private LocalDateTime createdAt;
  private String createdBy;
  private LocalDateTime updatedAt;
  private String updatedBy;
  private LocalDateTime blockadeStart;
  private LocalDateTime blockadeEnd;
}
