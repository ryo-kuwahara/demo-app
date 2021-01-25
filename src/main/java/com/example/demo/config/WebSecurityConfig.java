package com.example.demo.config;

import com.example.demo.service.LoginMemberDetailsService;
import com.example.demo.service.LoginMemberDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    LoginMemberDetailsService userDetailsService;


    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/favicon.ico", "/css/**", "/js/**", "/images/**", "/fonts/**");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests() // 認証が必要となるURLを設定します
                .antMatchers("/loginForm").permitAll()
                .antMatchers("/member/**").permitAll() // /member以下のURLも認証不要
                .antMatchers("/**").authenticated() // それ以外はすべて認証された状態じゃなきゃダメだよ〜
                .and()
                .formLogin() // ログインページに飛ばすよ
                .loginPage("/loginForm") // ログインページのURL
                .loginProcessingUrl("/login") // ログイン処理をするURL
                .usernameParameter("name")
                .passwordParameter("password")
                .defaultSuccessUrl("/member", true) // 認証成功時の遷移先
                .failureUrl("/loginForm?error=true").permitAll()// ログイン処理失敗時の遷移先
                .and()
                .logout();

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SessionRegistry sessionRegistry() {
        SessionRegistry sessionRegistry = new SessionRegistryImpl();
        return sessionRegistry;
    }
}
