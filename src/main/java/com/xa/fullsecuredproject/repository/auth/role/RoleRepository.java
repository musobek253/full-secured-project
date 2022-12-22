package com.xa.fullsecuredproject.repository.auth.role;

import com.xa.fullsecuredproject.entity.auth.Role;
import com.xa.fullsecuredproject.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, Long>, BaseRepository {
    Role findByCode(UUID code);
    Role findByName(String name);
}
