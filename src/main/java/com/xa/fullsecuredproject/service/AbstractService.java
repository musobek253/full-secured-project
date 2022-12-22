package com.xa.fullsecuredproject.service;

import com.xa.fullsecuredproject.mapper.BaseMapper;
import com.xa.fullsecuredproject.repository.BaseRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractService<M extends BaseMapper, R extends BaseRepository> {
    protected final M mapper;
    protected final R repository;
}
