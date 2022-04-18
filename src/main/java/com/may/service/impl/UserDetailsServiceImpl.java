package com.may.service.impl;

import com.may.mapper.CompetenceMapper;
import com.may.mapper.EmployeeMapper;
import com.may.pojo.Employee;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    CompetenceMapper competenceMapper;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        Employee user = employeeMapper.queryByName(name);
        if (user == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        String role = competenceMapper.query(user.getCompetenceId()).getName();
        List<GrantedAuthority> authorities = new ArrayList<>();
        GrantedAuthority authority = new SimpleGrantedAuthority(role);
        authorities.add(authority);
        return new User(user.getName(), new BCryptPasswordEncoder().encode(user.getPassword()),authorities);
    }
}
