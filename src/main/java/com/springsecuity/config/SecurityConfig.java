package com.springsecuity.config;

<<<<<<< HEAD
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
=======
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
>>>>>>> b91b944 ( adding database)
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
<<<<<<< HEAD
=======
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
>>>>>>> b91b944 ( adding database)
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

<<<<<<< HEAD
=======
    @Autowired
    private UserDetailsService userDetailsService;

>>>>>>> b91b944 ( adding database)
    @Bean
    public SecurityFilterChain securityFilterChain (HttpSecurity http) throws Exception {

        /*http.csrf(customizer ->customizer.disable());
<<<<<<< HEAD
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
=======
        http.authorizeHttpReqUserDetailsServiceuests(request -> request.anyRequest().authenticated());
>>>>>>> b91b944 ( adding database)
        //http.formLogin(Customizer.withDefaults());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        */

        http.csrf(customizer ->customizer.disable())
                .authorizeHttpRequests(request -> request.anyRequest().authenticated())
                .httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        //http.formLogin(Customizer.withDefaults());

        /*Customizer<CsrfConfigurer<HttpSecurity>> custcsrf= new Customizer<CsrfConfigurer<HttpSecurity>>() {
            @Override
            public void customize(CsrfConfigurer<HttpSecurity> customizer) {
                customizer.disable();
            }
        }*/
        return http.build();
    }
<<<<<<< HEAD
=======

//    @Bean
//    public UserDetailsService userDetailsService (){
//        UserDetails user1 = User
//                .withDefaultPasswordEncoder()
//                .username("Harsh")
//                .password("h@123")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails user2 = User
//                .withDefaultPasswordEncoder()
//                .username("Rishabh")
//                .password("r@123")
//                .roles("ADMIN")
//                .build();
//        return  new InMemoryUserDetailsManager(user1,user2);
//    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
        provider.setUserDetailsService(userDetailsService);
        return provider;
    }
>>>>>>> b91b944 ( adding database)
}
