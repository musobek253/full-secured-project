package com.xa.fullsecuredproject.controller;

import com.xa.fullsecuredproject.dto.auth.AuthUserCreateDto;
import com.xa.fullsecuredproject.dto.auth.AuthUserGetDto;
import com.xa.fullsecuredproject.dto.auth.LoginDto;
import com.xa.fullsecuredproject.dto.auth.SessionDto;
import com.xa.fullsecuredproject.response.Data;
import com.xa.fullsecuredproject.service.auth.AuthUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/v1/")
public class AuthUserController extends BaseController<AuthUserService>{

    public AuthUserController(AuthUserService service) {
        super(service);
    }

    @PostMapping("login")
    public ResponseEntity<Data<SessionDto>> login(@RequestBody LoginDto dto){
        return new ResponseEntity<>(new Data<>(service.login(dto)), HttpStatus.OK);
    }

    @PostMapping("registration")
    public ResponseEntity<Data<AuthUserGetDto>> registration(@RequestBody AuthUserCreateDto dto){
        return new ResponseEntity<>(new Data<>(service.create(dto)), HttpStatus.OK);
    }

    

    @GetMapping("admin")
    @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
    public ResponseEntity<Data<String>> getTest(){
        return new ResponseEntity<>(new Data<>("admin page"), HttpStatus.OK);
    }
}
