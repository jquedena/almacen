package com.almacen.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SeguridadConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
            .userDetailsService(userDetailsService)
            .passwordEncoder(getPasswordEncoder());
        /***
        auth
            .inMemoryAuthentication()
            .passwordEncoder(getPasswordEncoder())
            .withUser("admin").password("admin").roles("ADMIN")
            .and()
            .withUser("user").password("user").roles("ADMIN");
        ***/
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/inicio", "/productos", "/producto")
                .access("hasRole('ROLE_ADMIN')")
            .antMatchers("/paginas")
                .access("hasRole('ROLE_ADMIN')")
            .antMatchers("/servicios/**")
                .authenticated()
            .and()
                .formLogin()
                    .loginPage("/iniciarSesion")
                    .defaultSuccessUrl("/inicio")
                    .failureUrl("/iniciarSesion?error")
            .and()
                .logout()
                    .invalidateHttpSession(true)
                    .deleteCookies("JSESSIONID")
                    .logoutUrl("/iniciarSesion?cerrarSesion")
                    .logoutSuccessUrl("/iniciarSesion")
            .and()
                .exceptionHandling()
                    .accessDeniedPage("/403")
            .and()
            .csrf()
                .disable();
    }

    private PasswordEncoder getPasswordEncoder() {
        return new PasswordEncoder() {
            @Override
            public String encode(CharSequence charSequence) {
                return charSequence.toString();
            }

            @Override
            public boolean matches(CharSequence charSequence, String s) {
                return true;
            }
        };
    }
}
