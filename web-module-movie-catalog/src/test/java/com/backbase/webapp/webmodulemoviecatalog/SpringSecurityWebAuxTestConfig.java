package com.backbase.webapp.webmodulemoviecatalog;


import com.backbase.webapp.webmodulemoviecatalog.model.User;
import com.backbase.webapp.webmodulemoviecatalog.security.MyUserDetails;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import java.util.Arrays;

@TestConfiguration
public class SpringSecurityWebAuxTestConfig {
    @Bean
    @Primary
    public UserDetailsService userDetailsService() {
        MyUserDetails admin_user = new MyUserDetails(new User("mikku", "mikku", "ROLE_ADMIN", true));
        MyUserDetails user_user = new MyUserDetails(new User("neeraj", "neeraj", "ROLE_USER", true));
        return new InMemoryUserDetailsManager(Arrays.asList(admin_user, user_user));
    }
}
