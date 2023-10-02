package toyproject.buyandlogin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.buyandlogin.domain.jpa.UserEntity;
import toyproject.buyandlogin.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)

public class UserService {

    private final UserRepository userRepository;

    /**
     *  회원 가입
     *  회원 수정
     *  회원 전체 조회
     *  회원 ID 로 조회
     */

    @Transactional
    public void join(UserEntity user){
        duplicated(user.getUserId());
        userRepository.save(user);
    }

    @Transactional
    public void update(Long id, UserEntity user){
        UserEntity findUser = userRepository.findById(id);
        findUser.makeUser(user.getUserName(), user.getUserId(), user.getUserPassword(), user.getUserAddress());
    }

    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    public UserEntity findById(Long id){
        return userRepository.findById(id);
    }

    public List<UserEntity> findByUserId(String userId){
        return userRepository.findByLoginId(userId);
    }

    public void duplicated(String userId){
        List<UserEntity> findUser = userRepository.findByLoginId(userId);
        if(!findUser.isEmpty()){
            throw new IllegalStateException("이미 존재하는 ID 입니다");
        }
    }
}
