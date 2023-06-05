package pl.zzpj.repository.adapter.user.mapper;

import org.springframework.stereotype.Component;
import pl.zzpj.repository.core.domain.model.userModel.UserRole;
import pl.zzpj.repository.data.user.Role;

@Component
public class RoleMapper {
  public Role mapToDatabaseRole(UserRole userRole) {
    return switch (userRole) {
      case CLIENT -> Role.CLIENT;
      case ADMIN -> Role.ADMIN;
      case GUEST -> Role.GUEST;
    };
  }

  public UserRole mapToDomainModelUserRole(Role role) {
    return switch (role) {
      case CLIENT -> UserRole.CLIENT;
      case ADMIN -> UserRole.ADMIN;
      case GUEST -> UserRole.GUEST;
    };
  }

}
