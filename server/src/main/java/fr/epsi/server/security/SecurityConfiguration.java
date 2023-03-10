package fr.epsi.server.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.channel.ChannelProcessingFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import java.util.function.Function;

@Configuration
public class SecurityConfiguration {

    @Autowired
    private fr.epsi.server.security.CORSFilter corsFilter;

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username("user")
                .password( "password" )
                .roles( "USER" )
                .build();
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username( "admin" )
                .password( "password" )
                .roles( "USER", "ADMIN" )
                .build();
        return new InMemoryUserDetailsManager( user, admin );
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        http
                .csrf().disable()
                .addFilterBefore(corsFilter, ChannelProcessingFilter.class)
                .authorizeHttpRequests()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
        return http.build();
    }


}
