package com.backbase.webapp.webmodulemoviecatalog.security;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
public class PasswordEncoder {
        public static void main(String[] args) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(10);
            System.out.println(encoder.encode("foo"));

    }
}
