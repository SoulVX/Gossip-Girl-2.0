package com.stefanp.springboot.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.
        authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.
        method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.
        web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.
        SavedRequestAwareAuthenticationSuccessHandler;

import com.stefanp.springboot.security.UserAuthenticationService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
public class WebAppSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    private UserAuthenticationService authenticationProvider;

    @Autowired
    private AccessDeniedHandler accessDeniedHandler;

    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http
                .authorizeRequests()
                .antMatchers("/assets/**", "/public/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                //Asigur persistenta link-ului anterior, care a cerut autentificarea
                .successHandler(new SavedRequestAwareAuthenticationSuccessHandler())
                .defaultSuccessUrl("/secure/index", false).failureUrl("/public/authFailed")
                .and()
                .logout().logoutSuccessUrl("/public/logout")
                .permitAll()
                .and()
                .exceptionHandling().accessDeniedHandler(accessDeniedHandler);
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authMgrBuilder)
            throws Exception
    {
        authMgrBuilder.authenticationProvider(authenticationProvider);
    }
}
