package com.xa.fullsecuredproject.controller;

import com.xa.fullsecuredproject.service.BaseService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class BaseController<S extends BaseService> {
    protected final S service;
}
