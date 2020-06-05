package main.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http
            .csrf()
            .disable()
            .httpBasic()
            .and()
            .authorizeRequests()
            .antMatchers("/css/**", "/js/**", "/img/**", "/").permitAll()
            .antMatchers(HttpMethod.GET, "/login/userInfo").permitAll()
            .antMatchers(HttpMethod.POST, "/login/signUp").permitAll()
            .anyRequest().authenticated()
            .and()
            .formLogin()
            .loginPage("/login")
            .defaultSuccessUrl("/")
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/")
            .permitAll();

  }
}

