package com.football.betting.api.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().authorizeRequests()
                .antMatchers(HttpMethod.GET, SecurityConstants.PREDICTIONS).permitAll()
                .antMatchers(HttpMethod.GET, SecurityConstants.HISTORIC_BETS).permitAll()
                .antMatchers(HttpMethod.GET, SecurityConstants.FUTURE_BETS).permitAll()
                .anyRequest().authenticated();
    }
}
