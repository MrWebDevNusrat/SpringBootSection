package com.example.demolearnproject.security;

import javax.sql.DataSource;

import com.example.demolearnproject.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.*;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /*@Autowired
    private DataSource dataSource;
*/

    @Autowired
    private UserService userService;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {

        /*auth.jdbcAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .dataSource(dataSource)
                .usersByUsernameQuery("select username, password, enabled from user where username=?")
                .authoritiesByUsernameQuery("select username, role from user where username=?")
                .getUserDetailsService()
        ;*/

        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .antMatchers("/user/**").hasRole("USER")
                .antMatchers("/visitor/**").hasRole("VISITOR")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                    .permitAll()
                    .defaultSuccessUrl("/admin", true)
                .and()
                .logout().permitAll()
        .and()
        .httpBasic();
    }
}