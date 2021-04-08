
package com.heap.heap_project.security.config;

import com.heap.heap_project.security.jwt.JwtConfig;
import com.heap.heap_project.security.jwt.JwtCredentialsAuthFilter;
import com.heap.heap_project.security.jwt.JwtTokenFilter;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@ConditionalOnProperty(prefix = "app", name = "security", havingValue = "false" , matchIfMissing = true)
@EnableGlobalMethodSecurity(prePostEnabled = true) //Permet l'utilisation de PreAuthorize dans le controller
@AllArgsConstructor
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
                .csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .addFilter(new JwtCredentialsAuthFilter(authenticationManager(), jwtConfig))
                .addFilterAfter(new JwtTokenFilter(jwtConfig),JwtCredentialsAuthFilter.class)
                .authorizeRequests()
//              .antMatchers(/*"/", "/index",*/ "/registration").permitAll().
                .anyRequest()
                .authenticated();
    }

    //Liste d'exclusion des URI voulues public de nos filtres
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/inscription/**", "/error");

    }

    @Bean
    BCryptPasswordEncoder passwordEncoder(){
        /*Utilisation de BCrypt pour crypter nos passwords */
        return new BCryptPasswordEncoder(10);
    }
}

