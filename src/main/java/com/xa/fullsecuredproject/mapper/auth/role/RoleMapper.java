package com.xa.fullsecuredproject.mapper.auth.role;

import com.xa.fullsecuredproject.dto.auth.role.RoleCreateDto;
import com.xa.fullsecuredproject.dto.auth.role.RoleGetDto;
import com.xa.fullsecuredproject.dto.auth.role.RoleUpdateDto;
import com.xa.fullsecuredproject.entity.auth.Role;
import com.xa.fullsecuredproject.mapper.GenericMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper extends GenericMapper<RoleCreateDto, RoleUpdateDto, RoleGetDto, Role> {
}
