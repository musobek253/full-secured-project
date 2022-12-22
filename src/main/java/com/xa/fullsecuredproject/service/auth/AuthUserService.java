package com.xa.fullsecuredproject.service.auth;

import com.auth0.jwt.JWT;
import com.xa.fullsecuredproject.config.AESEncoderAndDecoder;
import com.xa.fullsecuredproject.dto.auth.*;
import com.xa.fullsecuredproject.entity.auth.AuthUser;
import com.xa.fullsecuredproject.entity.auth.Role;
import com.xa.fullsecuredproject.exception.NotFoundException;
import com.xa.fullsecuredproject.exception.UserAlreadyTaken;
import com.xa.fullsecuredproject.mapper.auth.AuthUserMapper;
import com.xa.fullsecuredproject.repository.auth.AuthUserRepository;
import com.xa.fullsecuredproject.repository.auth.role.RoleRepository;
import com.xa.fullsecuredproject.service.AbstractService;
import com.xa.fullsecuredproject.service.BaseService;
import com.xa.fullsecuredproject.service.GenericService;
import com.xa.fullsecuredproject.utils.JwtUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class AuthUserService extends AbstractService<AuthUserMapper, AuthUserRepository>
        implements GenericService<AuthUserCreateDto, AuthUserUpdateDto, AuthUserGetDto, UUID>, UserDetailsService, BaseService {

    private final RoleRepository roleRepository;
    private final AESEncoderAndDecoder aesEncoderAndDecoder;


    public AuthUserService(AuthUserMapper mapper, AuthUserRepository repository, RoleRepository roleRepository, AESEncoderAndDecoder aesEncoderAndDecoder) {
        super(mapper, repository);
        this.roleRepository = roleRepository;
        this.aesEncoderAndDecoder = aesEncoderAndDecoder;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        AuthUser authUser = repository.findByUsername(username);

        if (Objects.isNull(authUser)){
            log.error("User not found {}", username);
            throw  new NotFoundException("User Not Found!");
        }else {
            log.info("User found in the database: {}", username);
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authUser.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });
        return new User(authUser.getUsername(), authUser.getPassword(), authorities);
    }


    @Transactional
    public SessionDto login(LoginDto dto){

        AuthUser user = repository.findByUsername(dto.getUsername());
        try {
            System.out.println(aesEncoderAndDecoder.key.getEncoded());
            if (Objects.nonNull(user)&& dto.getPassword().equals(aesEncoderAndDecoder.decrypt(user.getPassword(), aesEncoderAndDecoder.key))){

                Date expiryForAccessToken = JwtUtils.getExpireDate();
                Date expiryForRefreshToken = JwtUtils.getExpireDateForRefreshToken();
                String accessToken = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(expiryForAccessToken)
                        .withClaim("roles", user.getRoles().stream().map(Role::getName).toList())
                        .withClaim("code", user.getCode().toString())
                        .sign(JwtUtils.getAlgorithm());

                String refreshToken = JWT.create()
                        .withSubject(user.getUsername())
                        .withExpiresAt(expiryForRefreshToken)
                        .sign(JwtUtils.getAlgorithm());

                SessionDto sessionDto = SessionDto.builder()
                        .accessToken(accessToken)
                        .expiresIn(expiryForAccessToken.getTime())
                        .refreshToken(refreshToken)
                        .refreshTokenExpire(expiryForRefreshToken.getTime())
                        .issuedAt(System.currentTimeMillis())
                        .build();

                return sessionDto;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        throw new UsernameNotFoundException("Username or password incorrect.");

    }


    @Override
    public AuthUserGetDto create(AuthUserCreateDto DTO) {

        AuthUser authUser = mapper.fromCreateDTO(DTO);
        try {
            authUser.setPassword(aesEncoderAndDecoder.encrypt(DTO.getPassword(), aesEncoderAndDecoder.key));
        } catch (Exception e) {
            e.printStackTrace();
        }
        authUser.getRoles().add(roleRepository.findByName("ROLE_USER"));
        authUser.getRoles().add(roleRepository.findByName("ROLE_ADMIN"));
        AuthUser result =  repository.save(authUser);
        if  (Objects.nonNull(result)) return mapper.toGetDTO(result);
       
        throw new UserAlreadyTaken("Username already taken.");
    }


    @Override
    public AuthUserGetDto update(AuthUserUpdateDto DTO) {
        return null;
    }


    @Override
    public AuthUserGetDto get(UUID code) {
        return null;
    }


    @Override
    public List<AuthUserGetDto> getAll() {
        return null;
    }


    @Override
    public Boolean delete(UUID key) {
        return null;
    }

    
}
