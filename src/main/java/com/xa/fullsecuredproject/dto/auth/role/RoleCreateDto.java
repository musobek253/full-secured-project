package com.xa.fullsecuredproject.dto.auth.role;

import com.xa.fullsecuredproject.dto.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleCreateDto implements BaseDTO {
    private String name;
}
