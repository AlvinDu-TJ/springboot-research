package security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class SecurityConfigUser extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(password());
    }
    @Bean
    public PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 配置403 无权限访问页面
        http.exceptionHandling().accessDeniedPage("/unauth.html");
        // 自定义登录界面
        http.formLogin().loginPage("/login.html").loginProcessingUrl("/user/login").defaultSuccessUrl("/test/index").permitAll()
        .and().authorizeRequests().antMatchers("/","/test/hello","/user/login").permitAll()
                .antMatchers("/test/index").hasAuthority("admins")
//                .antMatchers("/text/index").hasRole("sales")
        .anyRequest().authenticated()
        .and().csrf().disable();
    }
}

