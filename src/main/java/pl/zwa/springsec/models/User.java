package pl.zwa.springsec.models;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

@Component  //@Component - @Service - @Configuration - @Bean   każda z tych adnotacji zamienia klase w ziarno!!!
@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)  //sesja dla każdego użytkownika może trzymać czy jest zalogowany, ile minut, koszyk itp
public class User {

    private String name;

    public User(){
        name = "Zdzislaw";  //ustawiamy domyslnego usera - wyswietla sie na stronie index
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
