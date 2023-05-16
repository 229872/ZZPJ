package pl.zzpj.adapter.user.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.data.user.Account;

@Component
public class UserToAccountMapper {
  public Account mapToAccount(User user) {
    return Account.builder()
            .login(user.getLogin())
            .email(user.getEmail())
            .password(user.getPassword())
            .person(null) //fixme change
            .build();
  }

}
