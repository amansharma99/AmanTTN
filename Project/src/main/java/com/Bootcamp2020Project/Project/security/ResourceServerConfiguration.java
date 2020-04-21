package com.Bootcamp2020Project.Project.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
@Configuration
@EnableResourceServer
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Autowired
    AppUserDetailsService userDetailsService;

    public ResourceServerConfiguration() {
        super();
    }

    @Bean
    public static BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }

    @Autowired
    public void configureGlobal(final AuthenticationManagerBuilder authenticationManagerBuilder) {
        authenticationManagerBuilder.authenticationProvider(authenticationProvider());
    }

    @Override
    public void configure(final HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/api/**").authenticated()
                .antMatchers("/").permitAll()
                .antMatchers("/Admin/Home").hasAnyRole("ADMIN")
                .antMatchers("/Seller/Home").hasAnyRole("ADMIN", "SELLER")
                .antMatchers("/Customer/Home").hasAnyRole("ADMIN", "CUSTOMER")
//                .antMatchers("/doLogout").hasAnyRole("ADMIN", "CUSTOMER", "SELLER")
//                .antMatchers("/Customer/GetAddress").hasAnyRole("CUSTOMER")
//                .antMatchers("/Customer/AddAddress").hasAnyRole("CUSTOMER")
//                .antMatchers("/Customer/UpdateAddress/{AddressId}").hasAnyRole("CUSTOMER")
//                .antMatchers("/Customer/DeleteAddress/{AddressId}").hasAnyRole("CUSTOMER")
//                .antMatchers("/Seller/UpdateAddress/{AddressId}").hasAnyRole("SELLER")
                .antMatchers("/getUsers").permitAll()
//                .antMatchers("/Admin/Register").hasAnyRole("ADMIN")
//                .antMatchers("/activateUser/{email}").hasAnyRole("ADMIN")
//                .antMatchers("/deActivateUser/{email}").hasAnyRole("ADMIN")
//                .antMatchers("/customer/register").anonymous() //
//                .antMatchers("/getCustomers").hasAnyRole("ADMIN")
//                .antMatchers("/activateCustomerAccount/{token}").permitAll()
//                .antMatchers("/ReSendLink/{email}").anonymous()
//                .antMatchers("/Customer/UpdateProfile").hasAnyRole("CUSTOMER")
//                .antMatchers("/Customer/UpdatePassword").hasAnyRole("CUSTOMER")
//                .antMatchers("/customer/profile").permitAll()
//                .antMatchers("/seller/registration").anonymous()
//                .antMatchers("/getSellers").hasAnyRole("ADMIN")
//                .antMatchers("/seller/update/profile").hasAnyRole("SELLER")
//                .antMatchers("/seller/update/password").hasAnyRole("SELLER")
//                .antMatchers("/seller/myProfile").hasAnyRole("SELLER")

                .anyRequest().authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .csrf().disable();
    }
}
