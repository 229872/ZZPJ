package pl.zzpj.repository.adapter.user.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.repository.data.user.Account;

@Component
public class AccountToUserMapper {
  public User mapToUser(Account account) {
    return new User(
            account.getId(),
            account.getLogin(),
            account.getPassword(),
            account.getEmail(),
            null  //fixme change
    );
  }
}
