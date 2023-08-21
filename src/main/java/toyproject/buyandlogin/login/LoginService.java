package toyproject.buyandlogin.login;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.MemberRepository;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final MemberRepository memberRepository;

    public Member login(String loginId, String passWord){
       return memberRepository.findByLoginId(loginId).filter(member -> member.getMemberPassword().equals(passWord)).orElse(null);
    }
}
