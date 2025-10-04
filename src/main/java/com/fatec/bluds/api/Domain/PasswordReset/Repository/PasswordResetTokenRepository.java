package com.fatec.bluds.api.Domain.PasswordReset.Repository;

import com.fatec.bluds.api.Domain.PasswordReset.PasswordResetToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PasswordResetTokenRepository extends JpaRepository<PasswordResetToken, Long> {

}
