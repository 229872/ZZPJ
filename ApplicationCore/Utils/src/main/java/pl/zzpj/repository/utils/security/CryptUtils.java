package pl.zzpj.repository.utils.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CryptUtils {

  @Value("${cost.factor:12}")
  private int BCRYPT_COST_FACTOR;

  public String hashPassword(String password) {
    return BCrypt.withDefaults().hashToString(BCRYPT_COST_FACTOR, password.toCharArray());
  }

  public boolean verifyPassword(String password, String hash) {
    return BCrypt.verifyer().verify(password.toCharArray(), hash.toCharArray()).verified;
  }
}
