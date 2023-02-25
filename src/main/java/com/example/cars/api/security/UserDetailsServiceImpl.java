package com.example.cars.api.security;

import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service(value = "userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User.UserBuilder users = User.withDefaultPasswordEncoder();
        if (username.equals("user")) {
            return User.withUsername(username).password(encoder().encode("user")).roles("USER").build();
        } else if (username.equals("admin")) {
            return User.withUsername(username).password(encoder().encode("admin")).roles("USER", "ADMIN").build();
        }
        throw new UsernameNotFoundException("User not found.");
    }

    @Bean
    public static PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
