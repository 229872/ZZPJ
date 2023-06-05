package pl.zzpj.repository.rest.adapter.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.UserState;

@Component
public class RestUserStateMapper {

  public String mapUserStateToString(UserState userState) {
    if (userState == null) {
      return null;
    }
    return userState.toString();
  }
}
