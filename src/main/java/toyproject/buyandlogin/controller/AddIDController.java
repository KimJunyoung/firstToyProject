package toyproject.buyandlogin.controller;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.MemberRepository;
import toyproject.buyandlogin.validation.FindDuplication;
import toyproject.buyandlogin.upload.FileStore;
import toyproject.buyandlogin.upload.UploadFile;
import toyproject.buyandlogin.upload.UploadForm;

import java.io.IOException;

@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/members")
public class AddIDController {

    private final MemberRepository memberRepository;
    private final FileStore fileStore;
    private final FindDuplication findDuplication;

    @GetMapping("/add")
    public String addForm(@ModelAttribute("member") UploadFile member){
        return "/addid/addMemberForm";
    }

    @PostMapping("/add")
    public String addPost(@Validated @ModelAttribute("member") UploadFile member, BindingResult bindingResult) throws IOException {

        Boolean duplicateCheck = getDuplicateCheck(member);

        if(duplicateCheck){
            bindingResult.rejectValue("memberId","Duplication");
            return "addid/addMemberForm";
        }

        if(bindingResult.hasErrors()){
            return "addid/addMemberForm";
        }

        log.info("첨부파일 이름 ={}",member.getMultipartFile().getOriginalFilename());

        UploadForm uploadForm = fileStore.storeFile(member.getMultipartFile());
        Member member1 = new Member();
        member1.setMemberName(member.getMemberName());
        member1.setMemberPassword(member.getMemberPassword());
        member1.setMemberId(member.getMemberId());
        member1.setAttachFile(uploadForm);


        memberRepository.save(member1);
        return "redirect:/";
    }

    private Boolean getDuplicateCheck(UploadFile member) {
        Boolean duplicateCheck = findDuplication.findDuplicate(member.getMemberId());
        return duplicateCheck;
    }
}
