package com.example.spring_begin_07_06.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    public static final String SIGNUP_ENDPOINT = "/register";
    public static final String SIGNIN_ENDPOINT = "/login";
    public static final String LOGIN_ERROR = "/login?error";

    private final UserDetailsService userDetailsService;
    private final AuthenticationSuccessHandler authenticationSuccessHandler;

    public SecurityConfig(UserDetailsService userDetailsService, AuthenticationSuccessHandler authenticationSuccessHandler) {
        this.userDetailsService = userDetailsService;
        this.authenticationSuccessHandler = authenticationSuccessHandler;
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable();
        http
                .formLogin()
                .loginPage(SIGNIN_ENDPOINT)
                .failureUrl(LOGIN_ERROR)
                .permitAll()
                .successHandler(authenticationSuccessHandler);
        http
                .authorizeRequests()
                .antMatchers("/css/**", "/js/**")
                .permitAll();
        http
                .authorizeRequests()
                .antMatchers(SIGNUP_ENDPOINT)
                .permitAll();

        http
                .authorizeRequests()
                .antMatchers("/users/**").hasAnyAuthority("ADMIN")
                .anyRequest()
                .authenticated();
        http
                .logout()
                .invalidateHttpSession(true)
                .permitAll();
    }
    @Bean
    public AuthenticationProvider daoAuthManager(){
        DaoAuthenticationProvider daoAuthenticationProvider =new DaoAuthenticationProvider();
        daoAuthenticationProvider.setUserDetailsService(userDetailsService);
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        return daoAuthenticationProvider;
    }
}
