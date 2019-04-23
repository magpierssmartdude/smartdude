package com.smartdude;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableGlobalMethodSecurity(prePostEnabled = true)
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

	@Override
    protected void configure(HttpSecurity http) throws Exception {

    	
        http.csrf().disable();
    
        http.httpBasic().and().formLogin().permitAll().defaultSuccessUrl("/welcome",true)
        .and()
        .authorizeRequests()
        .antMatchers("/saveUser").permitAll()
        .antMatchers("/swagger-ui.html").permitAll()
        .antMatchers("/smartdude/*").permitAll()
        .antMatchers("/qm/*").hasAnyRole("VENDOR", "QM")
        .antMatchers("/admin/*").hasAnyRole("ADMIN")
        .antMatchers("/vendor/*").hasAnyRole("VENDOR","ADMIN")
        .anyRequest().authenticated().and()
        .exceptionHandling().accessDeniedPage("/noaccess");
        
    
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
 
}
