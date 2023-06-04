package pl.zzpj.repository.adapter.user.mapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.UserAccountInformations;
import pl.zzpj.repository.data.user.Account;

@Component
@RequiredArgsConstructor
public class UserAccountInformationMapper {

  public UserAccountInformations mapToUserAccountInformations(Account account) {
    return new UserAccountInformations(
            account.getFailedLoginCounter(),
            account.getLastIpLogin(),
            account.getLastIpWrongLogin(),
            account.getLastCorrectAuthenticationTime(),
            account.getLastFailedAuthenticationTime(),
            account.getBlockadeBegin(),
            account.getBlockadeEnd()
    );
  }
}
