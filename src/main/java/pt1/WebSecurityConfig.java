package pt1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailService;

    //verkkoohjain
    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable());//poistaa csrf suojauksen
        
        http.cors(cors -> cors.disable())//poistaa cors suojauksen
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/api/trainings/**").permitAll() // mahdollistaa kaikkien trainingsien hakemisen
                .requestMatchers("/login").permitAll()
                .anyRequest().authenticated())
            .formLogin(formlogin -> formlogin
                .defaultSuccessUrl("/traininglist", true)
                .permitAll())
            .logout(logout -> logout
                .permitAll());
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(new BCryptPasswordEncoder());
    }
}

