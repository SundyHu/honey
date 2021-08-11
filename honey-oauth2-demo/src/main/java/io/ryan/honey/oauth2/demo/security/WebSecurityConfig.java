package io.ryan.honey.oauth2.demo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * WebSecurityConfig
 *
 * @author hkc
 * @version 1.0.0
 * @date 2021-08-10 13:45
 */
@Configuration
@Order(300)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        List<String> permitAllResouces = new ArrayList<>();
        //Swagger资源
        permitAllResouces.addAll(Arrays.asList("/data/**", "/oauth/**", "/login/**", "/logout/**", "/test/**", "/swaggger-ui.html", "/doc.html", "/v2/**", "/swagger-resources", "/swagger-resources/**", "/webjars/**"));
        String[] resouceArray = permitAllResouces.toArray(new String[]{});
        http.csrf().disable();
        http
                .requestMatchers().antMatchers("/oauth/**", "/login/**", "/logout/**")
                .and()
                .authorizeRequests()
                .antMatchers("/oauth/**").authenticated()
                .and()
                .formLogin().permitAll()
                .and().authorizeRequests().mvcMatchers(resouceArray).permitAll(); //新增login form支持用户登录及授权
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().passwordEncoder(passwordEncoder())
                .withUser("Ryan")
                .password(passwordEncoder().encode("123456"))
                .roles("ADMIN");
    }
}
