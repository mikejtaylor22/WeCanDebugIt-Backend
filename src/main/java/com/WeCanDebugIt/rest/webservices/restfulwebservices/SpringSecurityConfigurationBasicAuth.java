package com.WeCanDebugIt.rest.webservices.restfulwebservices;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfigurationBasicAuth extends WebSecurityConfigurerAdapter {

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//
//        http
//                .csrf().disable()
//                .authorizeRequests()
//                .antMatchers(HttpMethod.OPTIONS, "/**").permitAll()
//                .anyRequest().authenticated()
//                .and()
//                .httpBasic();
//    }
@Override
protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests().antMatchers("/login", "/h2-console/**").permitAll()
            .antMatchers("/", "/*todo*/**").access("hasRole('USER')").and()
            .formLogin();

    http.csrf().disable();
    http.headers().frameOptions().disable();
}

//        http.csrf().disable().antMatcher(HttpMethod.OPTIONS, "/**" ).permitAll().authorizeRequests((requests)-> {
//            ((ExpressionUrlAuthorizationConfigurer.AuthorizedUrl)requests.anyRequest()).authenticated();
//
//        });
//
//        http.httpBasic();
//    }
}
