package com.example.springboot

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
import org.springframework.security.crypto.password.NoOpPasswordEncoder

@Configuration
@EnableWebSecurity
class SecurityConfig : WebSecurityConfigurerAdapter() {

    @Autowired
    lateinit var userDetailServiceImp: UserDetailServiceImp

    override fun configure(http: HttpSecurity?) {
        http
            ?.httpBasic()
            ?.and()
            ?.authorizeRequests()
            ?.antMatchers("/public")?.permitAll()
            ?.antMatchers(HttpMethod.GET,"/person/*")?.authenticated()
            ?.antMatchers(HttpMethod.POST,"/person/", "/person")?.hasRole("USER")
            ?.antMatchers(HttpMethod.DELETE,"/person/", "/person")?.hasRole("ADMIN")
            ?.and()
            ?.userDetailsService(userDetailServiceImp)?.csrf()?.disable()
            ?.formLogin()?.disable()
    }

    @Autowired
    override fun configure(auth: AuthenticationManagerBuilder?) {
        auth
            ?.inMemoryAuthentication()?.passwordEncoder(NoOpPasswordEncoder.getInstance())
            ?.withUser("user")?.password("user")?.roles("USER")
            ?.and()
            ?.withUser("admin")?.password("admin")?.roles("USER","ADMIN")
    }
}