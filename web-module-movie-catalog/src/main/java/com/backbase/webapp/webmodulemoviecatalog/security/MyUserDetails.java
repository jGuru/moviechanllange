package com.backbase.webapp.webmodulemoviecatalog.security;

import com.backbase.webapp.webmodulemoviecatalog.model.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetails implements UserDetails {

    private  String userName;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;
    public MyUserDetails(){}

    public MyUserDetails(User user)
    {
        userName=user.getUserName();
        password=user.getPassword();
        active=user.isActive();
        authorities=Arrays.stream(user.getRoles().split(",")).map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        System.out.println(authorities.size() + ":" +authorities.get(0));
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }

    public String getUserName() {
        return userName;
    }


}
