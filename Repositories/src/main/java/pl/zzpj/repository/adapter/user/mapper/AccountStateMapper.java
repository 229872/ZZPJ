package pl.zzpj.repository.adapter.user.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.UserState;
import pl.zzpj.repository.data.user.AccountState;

@Component
public class AccountStateMapper {

  public AccountState mapToDatabaseAccountState(UserState userState) {
    return switch (userState) {
      case ACTIVE -> AccountState.ACTIVE;
      case BLOCKED -> AccountState.BLOCKED;
      case NOT_VERIFIED -> AccountState.NOT_VERIFIED;
      case ARCHIVAL -> AccountState.ARCHIVAL;
    };
  }

  public UserState mapToDomainModelUserState(AccountState accountState) {
    return switch (accountState) {
      case ACTIVE -> UserState.ACTIVE;
      case BLOCKED -> UserState.BLOCKED;
      case NOT_VERIFIED -> UserState.NOT_VERIFIED;
      case ARCHIVAL -> UserState.ARCHIVAL;
    };
  }
}
