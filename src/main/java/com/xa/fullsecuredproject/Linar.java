package com.xa.fullsecuredproject;

import com.xa.fullsecuredproject.dto.auth.role.RoleCreateDto;
import com.xa.fullsecuredproject.service.auth.AuthUserService;
import com.xa.fullsecuredproject.service.auth.RoleService;
import org.springframework.boot.CommandLineRunner;

// @Component
public class Linar implements CommandLineRunner {
   private final AuthUserService authService;
   private final RoleService roleService;

   public Linar(AuthUserService authService, RoleService roleService) {
       this.authService = authService;
       this.roleService = roleService;
   }

   @Override
   public void run(String... args) throws Exception {
       roleService.create(new RoleCreateDto("ROLE_ADMIN"));
       roleService.create(new RoleCreateDto("ROLE_USER"));
       roleService.create(new RoleCreateDto("ROLE_MANAGER"));
   }
}
