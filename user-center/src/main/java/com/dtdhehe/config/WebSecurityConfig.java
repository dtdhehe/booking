package com.dtdhehe.config;

import com.dtdhehe.security.JwtSecurityProperties;
import com.dtdhehe.security.JwtTokenFilter;
import com.dtdhehe.security.handler.FailureHandler;
import com.dtdhehe.security.handler.UnLoginEntryPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import javax.annotation.Resource;

/**
 * @author Xie_东
 * @version 1.0.0
 * @date 2021/2/23 16:15
 * @description
 **/
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "customUserDetailService")
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtSecurityProperties jwtSecurityProperties;
    @Autowired
    private FailureHandler failureHandler;
    @Autowired
    private UnLoginEntryPoint unLoginEntryPoint;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().formLogin()
//                .loginPage("/loginPage")
//                .loginProcessingUrl("/doLogin")
//                .successHandler(successHandler)
                .failureHandler(failureHandler)
                .and()
                .exceptionHandling().authenticationEntryPoint(unLoginEntryPoint)
                .and()
                .authorizeRequests()
                .antMatchers("/loginPage","/doLogin").permitAll()
                .antMatchers(HttpMethod.POST,"/user").permitAll()
                .anyRequest().authenticated()
                .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and().csrf().disable();
        http.addFilterBefore(new JwtTokenFilter(userDetailsService,jwtSecurityProperties.getSecret()), UsernamePasswordAuthenticationFilter.class);
    }


    /**
     * 跨域配置
     * @return
     */
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(source);
    }

}
