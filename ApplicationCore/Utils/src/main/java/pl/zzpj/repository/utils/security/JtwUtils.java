package pl.zzpj.repository.utils.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JtwUtils {

  @Value("${security.token.time.ms}")
  private long tokenTime;
  @Value("${account.token.time.ms}")
  private long accountConfirmTime;

  @Value("${jwt.key}")
  private String key;

  public String generateToken(String login, String role) {
    long currentTime = System.currentTimeMillis();

    return Jwts.builder()
            .setSubject(login)
            .setIssuedAt(new Date(currentTime))
            .setExpiration(new Date(currentTime + tokenTime))
            .claim("role", role.toUpperCase())
            .signWith(SignatureAlgorithm.HS512, key)
            .compact();
  }


  public String generateConfirmationToken(String login) {
    long currentTime = System.currentTimeMillis();

    return Jwts.builder()
            .setSubject(login)
            .setIssuedAt(new Date(currentTime))
            .setExpiration(new Date(currentTime + accountConfirmTime))
            .signWith(SignatureAlgorithm.HS512, key)
            .compact();
  }

  public Jws<Claims> parseJWT(String token) {
    return Jwts.parser().setSigningKey(key).parseClaimsJws(token);
  }
}
