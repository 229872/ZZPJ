package pl.zzpj.repository.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.zzpj.repository.data.user.Account;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<Account, UUID> {
    @Query("SELECT a FROM Account a WHERE a.login = ?1")
    Optional<Account> findByLogin(String login);

    @Query("SELECT a FROM Account a WHERE a.email = ?1")
    Optional<Account> findByEmail(String email);
}
