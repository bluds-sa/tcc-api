package com.fatec.bluds.api.Domain.PasswordReset.Repository;

import com.fatec.bluds.api.Domain.PasswordReset.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

    Optional<PasswordResetToken> findByToken(String token);
}
