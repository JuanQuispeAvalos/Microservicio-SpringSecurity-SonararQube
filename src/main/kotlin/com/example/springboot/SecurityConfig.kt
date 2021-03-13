package com.example.springboot

import org.springframework.context.annotation.Configuration
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {
    override fun configure(http: HttpSecurity?) {
        http
            ?.authorizeRequests()
            ?.antMatchers("/public")?.permitAll()
            ?.antMatchers("/authenticated")?.authenticated()
            ?.antMatchers("/role/user")?.hasRole("USER")
            ?.antMatchers("/role/admin")?.hasRole("ADMIN")
            ?.and()?.httpBasic()
    }

    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth
            ?.inMemoryAuthentication()?.passwordEncoder(NoOpPasswordEncoder.getInstance())
            ?.withUser("user")?.password("user")?.roles("USER")
            ?.and()
            ?.withUser("admin")?.password("admin")?.roles("ADMIN")
    }
}