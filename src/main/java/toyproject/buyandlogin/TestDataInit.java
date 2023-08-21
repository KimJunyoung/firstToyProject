package toyproject.buyandlogin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;

    @PostConstruct
    public void init(){
        Member member = new Member();
        member.setMemberName("Junyoung");
        member.setMemberId("test");
        member.setMemberPassword("test!");
        memberRepository.save(member);
    }
}
