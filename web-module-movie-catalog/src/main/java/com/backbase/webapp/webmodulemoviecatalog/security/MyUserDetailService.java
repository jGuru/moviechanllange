package com.backbase.webapp.webmodulemoviecatalog.security;

import com.backbase.webapp.webmodulemoviecatalog.model.User;
import com.backbase.webapp.webmodulemoviecatalog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserName(userName);
        user.orElseThrow(()->new UsernameNotFoundException("The specified user not found"));
        return user.map(MyUserDetails::new).get();
    }
}
