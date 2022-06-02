package com.stefanp.springboot.security;

import java.util.ArrayList;
import java.util.List;

import com.stefanp.springboot.model.User;
import com.stefanp.springboot.service.UserService;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserAuthenticationService
        implements AuthenticationProvider
{
    @Resource
    UserService userService;

    @Override
    public Authentication authenticate(Authentication auth) throws AuthenticationException {

        Authentication retVal;
        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        if (auth != null) {
            String name = auth.getName();
            String password = auth.getCredentials().toString();

            List<User> users = userService.getAllUsers();
            for (User user : users) {
                if (user.getUsername().equals(name) && user.getPassword().equals(password)) {
                    if (user.getUsername().equals("gossipgirl"))
                        grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    else
                        grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                    retVal = new UsernamePasswordAuthenticationToken(name, "", grantedAuths);
                    return retVal;
                }
            }
        }
        return new UsernamePasswordAuthenticationToken(null, null, grantedAuths);
    }

    @Override
    public boolean supports(Class<?> tokenType)
    {
        return tokenType.equals(UsernamePasswordAuthenticationToken.class);
    }
}