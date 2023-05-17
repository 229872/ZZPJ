package pl.zzpj.repository.adapter.user.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.core.domain.model.userModel.User;
import pl.zzpj.repository.data.user.Account;
import pl.zzpj.repository.data.user.Person;

@Component
@AllArgsConstructor
public class AccountMapper {
  private final PersonMapper personMapper;

  public User mapToUser(Account account) {
    var person = personMapper.mapToDomainModelPerson(account.getPerson());

    return User.builder(account.getLogin(), account.getPassword(), account.getEmail(), person)
            .clientId(account.getId())
            .phoneNumber(account.getPhoneNumber())
            .socialInsuranceNumber(account.getSocialInsuranceNumber())
            .creditCard(account.getCreditCard())
            .build();

  }

  public Account mapToAccount(User user) {
    Person person = personMapper.mapToDatabasePerson(user.getPerson());

    return Account.builder(user.getLogin(), user.getPassword(), user.getEmail(), person)
            .phoneNumber(user.getPhoneNumber())
            .socialInsuranceNumber(user.getSocialInsuranceNumber())
            .creditCard(user.getCreditCard())
            .build();
  }
}
