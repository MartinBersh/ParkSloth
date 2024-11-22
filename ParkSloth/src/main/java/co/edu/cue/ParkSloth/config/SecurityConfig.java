package co.edu.cue.ParkSloth.config;

import co.edu.cue.ParkSloth.services.impl.CustomUserDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.util.CollectionUtils;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig{
    private final CustomUserDetailsService userDetailsService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception
    {
        return http
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(authRequest ->
                        authRequest
                                .requestMatchers("/**").permitAll()
//                                .requestMatchers("/User/**").hasRole("ADMIN")
//                                .requestMatchers("/Fee/**").hasRole("ADMIN")
//                                .requestMatchers("/ParkingLot/**").hasRole("ADMIN")
//                                .requestMatchers("/PaymentMethod/**").hasRole("ADMIN")
//                                .requestMatchers("/Reservation/**").hasRole("ADMIN")
//                                .requestMatchers("/Schedule/**").hasRole("ADMIN")
//                                .requestMatchers("/ScheduleDay/**").hasRole("ADMIN")
//                                .requestMatchers("/Slot/**").hasRole("ADMIN")
//                                .requestMatchers("/AddOnService/**").hasRole("ADMIN")
//                                .requestMatchers("/User/create").hasRole("ADMINP")
//                                .requestMatchers("/ParkingLot/update").hasRole("ADMINP")
//                                .requestMatchers("/Schedule/**").hasRole("ADMINP")
//                                .requestMatchers("/ScheduleDay/**").hasRole("ADMINP")
//                                .requestMatchers("/Slot/**").hasRole("ADMINP")
//                                .requestMatchers("/Fee/**").hasRole("ADMINP")
//                                .requestMatchers("/AddOnServices/**").hasRole("ADMINP")

                                .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .build();
    }
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        return authProvider;
    }

    @Bean
    CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.addAllowedMethod("*");
        config.addAllowedHeader("*");
        config.addAllowedOrigin("*");

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        if (!CollectionUtils.isEmpty(config.getAllowedOrigins()) || !CollectionUtils.isEmpty(config.getAllowedOriginPatterns())) {
            source.registerCorsConfiguration("/**", config);
        }
        return new CorsFilter(source);
    }
}