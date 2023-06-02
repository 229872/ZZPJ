package pl.zzpj.repository.rest.adapter.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.UserRole;
import pl.zzpj.repository.rest.exception.UserCreationException;

@Component
public class RestRoleMapper {
  public UserRole mapToUserRole(String role) throws UserCreationException {
    try {
      UserRole userRole = UserRole.valueOf(role.toUpperCase());

      if (userRole.equals(UserRole.GUEST)) {
        throw new UserCreationException("Administrator can't create guest");
      }
      return userRole;

    } catch (IllegalArgumentException | NullPointerException e) {
      throw new UserCreationException("Can't create user with wrong role name", e);
    }
  }

  public String mapRoleToString(UserRole role) {
    if (role == null) {
      return null;
    }
    return role.toString();
  }
}
