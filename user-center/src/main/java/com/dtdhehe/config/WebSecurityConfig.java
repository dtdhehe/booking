package com.dtdhehe.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/23 16:15
 * @description
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
//                .loginPage("/loginPage")
//                .loginProcessingUrl("/doLogin")
//                .successHandler(successHandler)
//                .failureHandler(failedHandler)
                .and()
                .authorizeRequests()
                .antMatchers("/loginPage","/doLogin")
                .permitAll().anyRequest().authenticated().and().csrf().disable();
    }

}
