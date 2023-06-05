package pl.zzpj.repository.rest.security;

import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import pl.zzpj.repository.utils.security.JtwUtils;

import java.io.IOException;

import static pl.zzpj.repository.utils.security.RoleName.GUEST;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

  private final String BEARER = "Bearer";
  private final JtwUtils jwtUtils;

  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    String header = request.getHeader(HttpHeaders.AUTHORIZATION);

    if (header == null || !header.startsWith(BEARER)) {
      authorizeAsGuest();
    } else {
      try {
        String token = header.substring(BEARER.length());
        Claims claims = jwtUtils.parseJWT(token).getBody();
        String login = claims.getSubject();
        String role = (String) claims.get("role");

        authorizeWithRole(login, role);
      } catch (Exception e) {
        authorizeAsGuest();
      }
    }
    filterChain.doFilter(request, response);
  }

  private void authorizeAsGuest() {
    authorizeWithRole(GUEST, GUEST);
  }

  private void authorizeWithRole(String login, String role) {
    String roleName = "ROLE_" + role;
    UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
            login, null, AuthorityUtils.createAuthorityList(roleName));
    SecurityContextHolder.getContext().setAuthentication(authenticationToken);
  }
}
