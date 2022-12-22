package com.xa.fullsecuredproject.controller.role;

import com.xa.fullsecuredproject.controller.BaseController;
import com.xa.fullsecuredproject.dto.auth.role.RoleCreateDto;
import com.xa.fullsecuredproject.dto.auth.role.RoleGetDto;
import com.xa.fullsecuredproject.response.Data;
import com.xa.fullsecuredproject.service.auth.RoleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1/role/")
public class RoleController extends BaseController<RoleService> {

    public RoleController(RoleService service) {
        super(service);
    }

    @GetMapping("get/all")
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    public ResponseEntity<Data<List<RoleGetDto>>> getAll(){
        return new ResponseEntity<>(new Data<>(service.getAll()), HttpStatus.OK);
    }

    @PostMapping("create")
    @PreAuthorize("hasRole('MANAGER') or hasRole('ADMIN')")
    public ResponseEntity<Data<RoleGetDto>> create(@RequestBody RoleCreateDto dto){
        return new ResponseEntity<>(new Data<>(service.create(dto)), HttpStatus.OK);
    }
}
