package com.xa.fullsecuredproject.entity.auth;

import com.xa.fullsecuredproject.entity.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Where;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Where(clause = "is_deleted = false")
@Table(indexes = {@Index(name = "auth_user_code_index", columnList = "code", unique = true),
        @Index(name = "auth_user_username_index", columnList = "username", unique = true),
        @Index(name = "auth_user_email_index", columnList = "email", unique = true)})
public class AuthUser extends Auditable {

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<Role> roles = new ArrayList<>();

}
