package toyproject.buyandlogin.domain;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.*;

@Slf4j
@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final Map<Long, Member> store = new HashMap<>();
    private Long sequence = 0L;

    public Member save(Member member){
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    public Member findById(Long id){
        Member member = store.get(id);
        return member;
    }

    public Optional<Member> findByLoginId(String loginId){
       return findAll().stream().filter(member -> member.getMemberId().equals(loginId)).findFirst();
   }

    public List<Member> findAll(){
        return new ArrayList<>(store.values());
    }

    public void update(Long id, Member member){
        Member member1 = findById(id);
        member1.setMemberId(member.getMemberId());
        member1.setMemberPassword(member.getMemberPassword());
        member1.setMemberName(member.getMemberName());
    }

    public void clear(){
        store.clear();
    }

}
