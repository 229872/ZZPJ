package pl.zzpj.repository.rest.adapter.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.UserTimeZone;
import pl.zzpj.repository.rest.exception.UserCreationException;

@Component
public class RestTimeZoneMapper {

  public UserTimeZone mapToUserTimeZone(String timeZone) throws UserCreationException {
    try {
      return UserTimeZone.valueOf(timeZone);
    } catch (IllegalArgumentException e) {
      throw new UserCreationException("Wrong time zone", e);
    }
  }
}
