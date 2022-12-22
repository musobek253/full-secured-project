package com.xa.fullsecuredproject.dto.auth.role;

import com.xa.fullsecuredproject.dto.GenericDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoleGetDto extends GenericDTO {
    private String name;
}
