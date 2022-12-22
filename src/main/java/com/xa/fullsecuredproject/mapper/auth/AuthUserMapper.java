package com.xa.fullsecuredproject.mapper.auth;


import com.xa.fullsecuredproject.dto.auth.AuthUserCreateDto;
import com.xa.fullsecuredproject.dto.auth.AuthUserGetDto;
import com.xa.fullsecuredproject.dto.auth.AuthUserUpdateDto;
import com.xa.fullsecuredproject.entity.auth.AuthUser;
import com.xa.fullsecuredproject.mapper.GenericMapper;
import com.xa.fullsecuredproject.mapper.auth.role.RoleMapper;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {RoleMapper.class})
public interface AuthUserMapper extends GenericMapper<AuthUserCreateDto, AuthUserUpdateDto, AuthUserGetDto, AuthUser> {
}
