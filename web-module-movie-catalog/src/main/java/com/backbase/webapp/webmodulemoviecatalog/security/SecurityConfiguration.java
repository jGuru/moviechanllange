package com.backbase.webapp.webmodulemoviecatalog.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * THis class is used to configure spring security
 * */
@EnableWebSecurity
public class SecurityConfiguration  extends WebSecurityConfigurerAdapter {

    final MyUserDetailService userDetailsService;
    public SecurityConfiguration(MyUserDetailService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    /*The Below method provides authentication based on JPA i.e. from the mysql db users table*/
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        super.configure(auth);
    }


    /*Below method provides authorization to the selected user which has selected role*/
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/menu/","/menu","/moviesearch","/moviesearch/").hasAnyRole("ADMIN", "USER")
                .antMatchers("/","/login","/login/","/logout/").permitAll().anyRequest().authenticated()
                .and().formLogin().defaultSuccessUrl("/menu", true);
    }
    @Bean
     public PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
