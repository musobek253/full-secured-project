package com.xa.fullsecuredproject.dto.auth;

import com.xa.fullsecuredproject.dto.GenericDTO;
import com.xa.fullsecuredproject.dto.auth.role.RoleGetDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Collection;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserUpdateDto extends GenericDTO {
    private String username;
    private String email;
    private String password;
    private Collection<RoleGetDto> roles = new ArrayList<>();
}
