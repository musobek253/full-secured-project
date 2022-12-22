package com.xa.fullsecuredproject.service.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.xa.fullsecuredproject.dto.auth.role.RoleCreateDto;
import com.xa.fullsecuredproject.dto.auth.role.RoleGetDto;
import com.xa.fullsecuredproject.dto.auth.role.RoleUpdateDto;
import com.xa.fullsecuredproject.entity.auth.Role;
import com.xa.fullsecuredproject.exception.NotFoundException;
import com.xa.fullsecuredproject.exception.validator.BadRequestException;
import com.xa.fullsecuredproject.mapper.auth.role.RoleMapper;
import com.xa.fullsecuredproject.repository.auth.role.RoleRepository;
import com.xa.fullsecuredproject.service.AbstractService;
import com.xa.fullsecuredproject.service.GenericService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

@Service
public class RoleService extends AbstractService<RoleMapper, RoleRepository> implements GenericService<RoleCreateDto, RoleUpdateDto, RoleGetDto, UUID> {

    public RoleService(RoleMapper mapper, RoleRepository repository) {
        super(mapper, repository);
    }


    @Override
    public RoleGetDto create(RoleCreateDto DTO) {

        Role role = mapper.fromCreateDTO(DTO);
        Role result = repository.save(role);
        if(Objects.nonNull(result)) return mapper.toGetDTO(result);

        throw new BadRequestException("Role name already exists.");
    }

    @Override
    public RoleGetDto update(RoleUpdateDto DTO) {
        return null;
    }

    @Override
    public RoleGetDto get(UUID code) {

        Role role = repository.findByCode(code);
        if (Objects.nonNull(role)) return mapper.toGetDTO(role);
        throw new NotFoundException("Role not found.");
    }

    @Override
    public List<RoleGetDto> getAll() {
        List<Role> roles = repository.findAll();
        return mapper.toListDTO(roles);
    }

    @Override
    public Boolean delete(UUID key) {
        return null;
    }
}
