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
    public Authentication authenticate(Authentication auth) throws AuthenticationException
    {

        System.out.println(userService.getUser(1));
        System.out.println("test");
        Authentication retVal = null;
        List<GrantedAuthority> grantedAuths = new ArrayList<>();

        if (auth != null)
        {
            String name = auth.getName();
            String password = auth.getCredentials().toString();
            System.out.println("name: " + name);
            System.out.println("password: " + password);

            List<User> users = userService.getAllUsers();
            for(User user : users) {
                if(user.getUsername().equals(name) && user.getPassword().equals(password)) {
                    grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                    grantedAuths.add(new SimpleGrantedAuthority("ROLE_STAFF"));
                    grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                    retVal = new UsernamePasswordAuthenticationToken(
                            name, "", grantedAuths
                    );
                    System.out.println("grant database");
                    return retVal;
                }
            }
            if (name.equals("admin") && password.equals("admin12345"))
            {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_STAFF"));
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                retVal = new UsernamePasswordAuthenticationToken(
                        name, "", grantedAuths
                );
                System.out.println("grant Admin");
            }
            else if (name.equals("staff1") && password.equals("staff12345"))
            {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_STAFF"));
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                retVal = new UsernamePasswordAuthenticationToken(
                        name, "", grantedAuths
                );
                System.out.println("grant Staff");
            }
            else if (name.equals("user1") && password.equals("user12345"))
            {
                grantedAuths.add(new SimpleGrantedAuthority("ROLE_USER"));

                retVal = new UsernamePasswordAuthenticationToken(
                        name, "", grantedAuths
                );
                System.out.println("grant User");
            }
        }
        else
        {
            System.out.println("invalid login");
            retVal = new UsernamePasswordAuthenticationToken(
                    null, null, grantedAuths
            );
            System.out.println("bad Login");
        }

        System.out.println("return login info");
        return retVal;
    }

    @Override
    public boolean supports(Class<?> tokenType)
    {
        return tokenType.equals(UsernamePasswordAuthenticationToken.class);
    }
}