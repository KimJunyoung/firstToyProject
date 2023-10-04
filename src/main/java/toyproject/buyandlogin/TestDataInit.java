package toyproject.buyandlogin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toyproject.buyandlogin.domain.OldItem;
import toyproject.buyandlogin.domain.OldItemRepository;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.MemberRepository;

import javax.annotation.PostConstruct;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;
    private final OldItemRepository oldItemRepository;

    @PostConstruct
    public void init(){
        Member member = new Member();
        member.setMemberName("Junyoung");
        member.setMemberId("test");
        member.setMemberPassword("test!");
        memberRepository.save(member);

        OldItem oldItem1 = new OldItem("스파크", "car", 5000000);
        OldItem oldItem2 = new OldItem("베뉴", "car", 17000000);

        oldItemRepository.save(oldItem1);
        oldItemRepository.save(oldItem2);

    }
}
