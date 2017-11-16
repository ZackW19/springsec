package pl.zwa.springsec.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ExceptionController {

    @GetMapping("/403")
    @ResponseBody
    public String accessDenied(){
        return "<center><b>Nie masz prawa widzieć co tutaj jest, zaloguj się!</b></center>";
    }
}
