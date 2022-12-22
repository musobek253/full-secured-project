package com.xa.fullsecuredproject.repository.auth;

import com.xa.fullsecuredproject.entity.auth.AuthUser;
import com.xa.fullsecuredproject.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthUserRepository extends JpaRepository<AuthUser, Long>, BaseRepository {

    AuthUser findByUsername(String username);

    AuthUser findByCode(UUID code);

}
