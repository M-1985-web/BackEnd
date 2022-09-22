package com.apportfolio.mmm.Security;

import com.apportfolio.mmm.Security.Jwt.JwtEntryPoint;
import com.apportfolio.mmm.Security.Jwt.JwtTokenFilter;
import com.apportfolio.mmm.Security.Service.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//clase que controla el JWT
public class MainSecurity {

  @Autowired
  UserDetailsImpl userDetailsImpl;

  @Autowired
  JwtEntryPoint jwtEntryPoint;

  @Bean
  public JwtTokenFilter jwtTokenFilter() {
    return new JwtTokenFilter();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  //.antMatchers("/auth/**").permitAll()
  //
  //lo realize manualmente override



  // cambio override por @Bean
  // y cambio protected void configure(HttpSecurity http) throws Exception {
  //por //protected void configure(HttpSecurity http) throws Exception {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.cors().and().csrf().disable()
            .exceptionHandling().authenticationEntryPoint(jwtEntryPoint).and()
            .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
            .authorizeRequests()
            .antMatchers("/**").permitAll()
            .anyRequest().authenticated();

    http.addFilterBefore(jwtTokenFilter(),UsernamePasswordAuthenticationFilter.class);

    return http.build();

  }

  //agrego AuthenticationConfiguration authenticationConfiguration en ()
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {

    //return super.authenticationManager();
    return authenticationConfiguration.getAuthenticationManager();
  }



  /*

  @Bean
  @Override
  public AuthenticationManager authenticationManagerBean() throws Exception {
    return super.authenticationManagerBean();
  }

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.userDetailsService(userDetailsImpl).passwordEncoder(passwordEncoder());
  }

 */



}
