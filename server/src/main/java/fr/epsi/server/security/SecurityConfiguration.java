package fr.epsi.server.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
public class SecurityConfiguration {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails user = User.withDefaultPasswordEncoder()
                .username( "user" )
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
    protected CorsConfigurationSource corsConfigurationSource() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", new CorsConfiguration().applyPermitDefaultValues());
        return source;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors()
                .and().authorizeRequests()
                .anyRequest().permitAll()
                .and().csrf().disable();
    }
}
