package pl.zzpj.rest.security;

import at.favre.lib.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Component;

@Component
public class CryptUtils {
  private final int BCRYPT_COST_FACTOR = 12;

  public String hashPassword(String password) {
    return BCrypt.withDefaults().hashToString(BCRYPT_COST_FACTOR, password.toCharArray());
  }

  public boolean verifyPassword(String password, String hash) {
    return BCrypt.verifyer().verify(password.toCharArray(), hash.toCharArray()).verified;
  }
}
