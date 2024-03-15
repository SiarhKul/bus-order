package com.example.busorder.config;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
//@RequiredArgsConstructor
//@EnableWebSecurity
@Configuration
public class SecurityConfig {
    //    private final AuthProviderImpl authProvider;
//    private final ClientServiceDetailsImpl clientServiceDetails;

//    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//        auth.authenticationProvider(authProvider);
//        auth.userDetailsService(clientServiceDetails);
//    }

//    protected void configure(HttpSecurity http) throws Exception {
//        http.csrf(AbstractHttpConfigurer::disable)
//                .cors(AbstractHttpConfigurer::disable)
//                .authorizeRequests().anyRequest().authenticated()
//                .and().formLogin(login -> login
//                        .loginPage("http://localhost:4200/auth")
//                        .loginProcessingUrl("http://localhost:4200/auth")
//                        .defaultSuccessUrl("http://localhost:4200", true)
//                        .permitAll());
//    }

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.setAllowedOriginPatterns(Collections.singletonList("*"));
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
