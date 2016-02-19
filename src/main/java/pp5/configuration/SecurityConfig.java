package pp5.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


/**
 * Created by Rafał on 2016-02-18.
 */
@Configuration
//@ComponentScan(basePackageClasses = CustomUserDetailsService.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;
    @Override protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth
            .jdbcAuthentication()
            .dataSource(dataSource)
            .passwordEncoder(passwordencoder());
//                .usersByUsernameQuery(
//                        "select username,password, enabled from users where username=?")
//                .authoritiesByUsernameQuery(
//                        "select username, role from user_roles where username=?");
    //            .passwordEncoder(passwordencoder());
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/hello").access("hasRole('ROLE_USER')")
                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login")
                .and()
                .logout().logoutSuccessUrl("/login?logout")
                .and()
                .exceptionHandling().accessDeniedPage("/403")
                .and()
                .csrf();
    }

    @Bean(name="passwordEncoder")
    public PasswordEncoder passwordencoder(){
        return new BCryptPasswordEncoder();
    }
}