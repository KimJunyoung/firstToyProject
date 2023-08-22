package toyproject.buyandlogin;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import toyproject.buyandlogin.domain.Item;
import toyproject.buyandlogin.domain.ItemRepository;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.MemberRepository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;

@Component
@RequiredArgsConstructor
public class TestDataInit {

    private final MemberRepository memberRepository;
    private final ItemRepository itemRepository;

    @PostConstruct
    public void init(){
        Member member = new Member();
        member.setMemberName("Junyoung");
        member.setMemberId("test");
        member.setMemberPassword("test!");
        member.setItems(new ArrayList<>());
        memberRepository.save(member);

        Item item1 = new Item("스파크", "car", 5000000);
        Item item2 = new Item("베뉴", "car", 17000000);

        itemRepository.save(item1);
        itemRepository.save(item2);

    }
}
