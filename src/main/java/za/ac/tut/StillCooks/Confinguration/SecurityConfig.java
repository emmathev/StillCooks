package za.ac.tut.StillCooks.Confinguration;


import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import za.ac.tut.StillCooks.Service.StillCooksUserService;

@Configuration
@AllArgsConstructor
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private final StillCooksUserService stillCooksUserService;


    @Bean
    public UserDetailsService userDetailsService() {
        return stillCooksUserService;
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setUserDetailsService(stillCooksUserService);
        provider.setPasswordEncoder(passwordEncoder());
        return provider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        return httpSecurity.csrf(AbstractHttpConfigurer::disable).formLogin(httpForm -> {
                    httpForm.loginPage("/req/login").permitAll();
                    httpForm.defaultSuccessUrl("/index");

                }).logout(logout -> {
                    logout.logoutUrl("/signout") // URL to trigger logout
                            .logoutSuccessUrl("/req/login") // Redirect to login page after logout
                            .invalidateHttpSession(true) // Invalidate the session
                            .clearAuthentication(true); // Clear authentication
                })


                .authorizeHttpRequests(registry -> {
                    registry.requestMatchers("/req/signup", "/css/**", "/js/**", "/favicon.ico").permitAll();
                    registry.anyRequest().authenticated();
                }).build();


    }


}
