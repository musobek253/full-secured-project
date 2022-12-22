package com.xa.fullsecuredproject.service;

import com.xa.fullsecuredproject.dto.BaseDTO;
import com.xa.fullsecuredproject.dto.GenericDTO;

import java.io.Serializable;
import java.util.List;

public interface GenericService<CD extends BaseDTO, UD extends GenericDTO, GD extends BaseDTO, K extends Serializable> extends BaseService{

    GD create(CD DTO);

    GD update(UD DTO);

    GD get(K code);

    List<GD> getAll();

    Boolean delete(K key);
}
