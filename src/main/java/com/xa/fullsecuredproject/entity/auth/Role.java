package com.xa.fullsecuredproject.entity.auth;

import com.xa.fullsecuredproject.entity.Auditable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Role extends Auditable {

    @Column(name = "name", unique = true)
    private String name;

}
