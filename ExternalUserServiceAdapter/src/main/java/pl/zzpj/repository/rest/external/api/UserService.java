package pl.zzpj.repository.rest.external.api;

import pl.zzpj.repository.rest.external.dto.UserInputDto;

public interface UserService {

  UserInputDto add(UserInputDto user);
}
