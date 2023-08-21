package toyproject.buyandlogin.controller;


import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import toyproject.buyandlogin.domain.Member;

@Slf4j
@Controller
public class HomeController {

    @GetMapping("/")
    public String welcomeHome(@SessionAttribute(name = "CookieSession", required = false)Member loginMember, Model model){

        if(loginMember == null){
            return "/home";
        }

        model.addAttribute(loginMember);
        return "/loginHome";
    }

}
