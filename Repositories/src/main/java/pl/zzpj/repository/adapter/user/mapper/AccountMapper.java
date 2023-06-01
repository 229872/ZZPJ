package pl.zzpj.repository.adapter.user.mapper;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.User;
import pl.zzpj.repository.data.user.Account;
import pl.zzpj.repository.data.user.Person;

@Component
@AllArgsConstructor
public class AccountMapper {
  private final PersonMapper personMapper;
  private final TimeZoneMapper timeZoneMapper;
  private final RoleMapper roleMapper;
  private final AccountStateMapper accountStateMapper;

  public User mapToUser(Account account) {
    var person = personMapper.mapToDomainModelPerson(account.getPerson());

    User.UserBuilder userBuilder = User.builder(
            account.getLogin(),
            account.getPassword(),
            account.getEmail(),
            person,
            roleMapper.mapToDomainModelUserRole(account.getRole()),
            accountStateMapper.mapToDomainModelUserState(account.getAccountState()),
            account.getArchive(),
            account.getScore()
    );

    return userBuilder
            .locale(account.getLocale())
            .userTimeZone(timeZoneMapper.mapToDomainModelTimeZone(account.getTimeZone()))
            .clientId(account.getId())
            .version(account.getVersion())
            .phoneNumber(account.getPhoneNumber())
            .socialInsuranceNumber(account.getSocialInsuranceNumber())
            .creditCard(account.getCreditCard())
            .build();

  }

  public Account mapToAccount(User user) {
    Person person = personMapper.mapToDatabasePerson(user.getPerson());

    Account.AccountBuilder accountBuilder = Account.builder(
            user.getLogin(),
            user.getPassword(),
            user.getEmail(),
            person,
            roleMapper.mapToDatabaseRole(user.getUserRole()),
            accountStateMapper.mapToDatabaseAccountState(user.getUserState())
    );


    return accountBuilder
            .archive(user.isArchive())
            .locale(user.getLocale())
            .timeZone(timeZoneMapper.mapToDatabaseTimeZone(user.getUserTimeZone()))
            .phoneNumber(user.getPhoneNumber())
            .socialInsuranceNumber(user.getSocialInsuranceNumber())
            .creditCard(user.getCreditCard())
            .build();
  }
}
