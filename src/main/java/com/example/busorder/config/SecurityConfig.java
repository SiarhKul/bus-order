package com.example.busorder.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
