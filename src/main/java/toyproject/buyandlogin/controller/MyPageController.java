package toyproject.buyandlogin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.MemberRepository;
import toyproject.buyandlogin.domain.UpdateForm;

@Controller
@Slf4j
@RequiredArgsConstructor
public class MyPageController {
    private final MemberRepository memberRepository;

    @GetMapping("/{id}")
    public String myPage(@PathVariable long id, Model model){
        Member member = memberRepository.findById(id);
        model.addAttribute(member);
        return "/mypage/myPage";
    }

    @GetMapping("/{id}/edit")
    public String myPageEdit(@PathVariable long id, Model model){
        Member member = memberRepository.findById(id);
        model.addAttribute(member);
        return "/mypage/edit";
    }

    @PostMapping("/{id}/edit")
    public String myPageEditPost(@PathVariable long id, @Validated @ModelAttribute("member") UpdateForm member, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "/mypage/edit";
        }

        Member member1 = new Member();

        member1.setMemberName(member.getMemberName());
        member1.setMemberPassword(member.getMemberPassword());
        member1.setMemberId(member.getMemberId());

        memberRepository.update(id, member1);

        return "redirect:/";
    }

}
