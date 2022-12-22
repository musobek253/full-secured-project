package com.xa.fullsecuredproject.dto.auth;

import com.xa.fullsecuredproject.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AuthUserCreateDto implements BaseDTO {
    private String username;
    private String email;
    private String password;
}
