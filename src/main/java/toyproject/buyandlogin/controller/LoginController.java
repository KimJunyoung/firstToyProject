package toyproject.buyandlogin.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.MemberRepository;
import toyproject.buyandlogin.login.LoginForm;
import toyproject.buyandlogin.login.LoginService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Slf4j
@RequiredArgsConstructor
@Controller
@RequestMapping
public class LoginController {

    private final MemberRepository memberRepository;
    private final LoginService loginService;

    @GetMapping("/login")
    public String loginPage(@ModelAttribute("loginForm") LoginForm form){

        return "/login/loginForm";
    }

    @PostMapping("/login")
    public String loginPost(@Validated @ModelAttribute("loginForm") LoginForm form, BindingResult bindingResult, HttpServletRequest request){

        if(bindingResult.hasErrors()){
            return "login/loginForm";
        }

        Member memberLogin = loginService.login(form.getMemberId(), form.getMemberPassword());

        if(memberLogin == null){
            bindingResult.reject("loginFail", "아이디와 비밀번호가 맞지 않습니다");
            return "login/loginForm";
        }

        // 성공세션
        HttpSession session = request.getSession();
        session.setAttribute("CookieSession", memberLogin);

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession(false);
        if(session != null){
            session.invalidate();
        }

        return "redirect:/";
    }

}
