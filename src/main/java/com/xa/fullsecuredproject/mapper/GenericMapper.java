package com.xa.fullsecuredproject.mapper;

import com.xa.fullsecuredproject.dto.BaseDTO;
import com.xa.fullsecuredproject.dto.GenericDTO;
import com.xa.fullsecuredproject.entity.BaseEntity;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface GenericMapper<CD extends BaseDTO, UD extends GenericDTO, GD extends GenericDTO, E extends BaseEntity> extends BaseMapper {

    E fromCreateDTO(CD createDTO);

    E fromUpdateDTO(UD updateDTO, @MappingTarget E entity);

    GD toGetDTO(E entity);

    List<GD> toListDTO(List<E> entities);

}
