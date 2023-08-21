package toyproject.buyandlogin.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberRepositoryTest {

    MemberRepository memberRepository = new MemberRepository();

    @AfterEach
    void clear(){
        memberRepository.clear();
    }


    @Test
    void save(){
        Member member1 = new Member("junYoung", "wns8093", "1234");
        Member member2 = new Member("junYoungKim", "wns6713", "1234");
        memberRepository.save(member1);
        memberRepository.save(member2);

        assertThat(memberRepository.findAll().size()).isEqualTo(2);

    }

    @Test
    void findById(){
        Member member1 = new Member("junYoung", "wns8093", "1234");
        memberRepository.save(member1);

        Member member = memberRepository.findById(1L);
        assertThat(member).isEqualTo(member1);
    }

    @Test
    void findByMemberId(){
        Member member1 = new Member("junYoung", "wns8093", "1234");
        memberRepository.save(member1);

        Member member = memberRepository.findByLoginId("wns8093").get();
        assertThat(member).isEqualTo(member1);
    }

}