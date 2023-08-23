package toyproject.buyandlogin.validation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.MemberRepository;

import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class FindDuplication {
    private final MemberRepository memberRepository;

    public boolean findDuplicate(String name){


        Optional<Member> loginId = memberRepository.findByLoginId(name);

        log.info("member1={}", loginId);

        if(loginId.isEmpty()){
            return false;
        }

        return true;

    }
}
