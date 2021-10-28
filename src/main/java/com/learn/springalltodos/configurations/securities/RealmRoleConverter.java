package com.learn.springalltodos.configurations.securities;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class RealmRoleConverter implements Converter <Jwt, Collection<GrantedAuthority>>{
    @Override
    public Collection<GrantedAuthority> convert(Jwt jwt) {
        List<String> roles = List.of("todo_read_all");
        return roles.stream().map(role -> "ROLE_" + role)
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}
