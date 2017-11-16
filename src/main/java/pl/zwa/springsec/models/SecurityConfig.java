package pl.zwa.springsec.models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//SpringSecurity odpowiada za logike logowania, hasła itp

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/").permitAll()  //strona domyślna index otworzy sie automatycznie bez logowania
                .antMatchers("/cos").hasAuthority("MODERATOR")
                .antMatchers("/admin").hasAnyAuthority("ADMIN")
                //.anyRequest().denyAll()  //inne odwolania jak np. /distance zostaną przekierowane na formLogin
                .anyRequest().hasAnyAuthority("USER","ADMIN")
                .and()  //kolejna sesja
                .formLogin()  //utworzy sie domyslna strona logowania pod linkiem /login
                .permitAll()
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403");
    }


    //poniższa autentykacja nie korzysta z bazy danych, jest inMemory!!!
    @Autowired
    public void configureGlobal (AuthenticationManagerBuilder auth) throws Exception{
        auth.inMemoryAuthentication()
                .withUser("zwa")
                .password("zw1234")
                .authorities("ADMIN");
    }
}
