package com.may.config;

import com.may.mapper.CompetenceMapper;
import com.may.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    CompetenceMapper competenceMapper;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/").loginProcessingUrl("/login")
                .defaultSuccessUrl("/main")
                .usernameParameter("name")
                .failureForwardUrl("/err");
        http.authorizeRequests().antMatchers("/","/error").permitAll()
                .antMatchers("/emp/**").hasAnyAuthority("admin","root")
                .anyRequest().authenticated();
        http.rememberMe().rememberMeParameter("remember")
                .and().logout().logoutSuccessUrl("/loginOut");
        http.csrf().disable();
    }

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // 设置拦截忽略文件夹，可以对静态资源放行
        web.ignoring().antMatchers("/js/**", "/css/**", "/img/**", "/lib/**");
    }
}
