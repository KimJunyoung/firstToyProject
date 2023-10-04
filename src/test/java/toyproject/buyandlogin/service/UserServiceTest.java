package toyproject.buyandlogin.service;

import org.apache.catalina.User;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import toyproject.buyandlogin.domain.jpa.Address;
import toyproject.buyandlogin.domain.jpa.UserEntity;

import javax.persistence.EntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Transactional
class UserServiceTest {

    @Autowired
    UserService userService;

    @Autowired
    EntityManager em;

    /**
     * 회원가입
     * 회원조회
     * 회원가입 시 중복체크
     * 회원 전체 조회
     */

    @Test
    public void 회원가입 (){
        UserEntity user1 = new UserEntity();
        Address address = new Address("부산", "남구 용소로", "48449");
        user1.makeUser("김준영", "wns8093", "wns6713", address);

        userService.join(user1);
        em.flush();

        assertThat(user1).isEqualTo(userService.findByUserId(user1.getUserIdName()).get(0));

    }

    // 회원 조회

    @Test
    public void 회원조회_ID(){
        UserEntity user1 = new UserEntity();
        Address address = new Address("부산", "남구 용소로", "48449");
        user1.makeUser("김준영", "wns8093", "wns6713", address);

        userService.join(user1);
        em.flush();

        assertThat(user1).isEqualTo(userService.findById(1L));
    }

    @Test
    public void 회원조회_전체(){
        UserEntity user1 = new UserEntity();
        Address address = new Address("부산", "남구 용소로", "48449");
        user1.makeUser("김준영", "wns8093", "wns6713", address);

        userService.join(user1);

        UserEntity user2 = new UserEntity();
        Address address2 = new Address("부산", "남구 용소로", "50000");
        user1.makeUser("김준영", "wns985151", "wns6713", address2);

        userService.join(user2);

        List<UserEntity> findAllUsers = userService.findAll();
        assertThat(findAllUsers.size()).isEqualTo(2);
    }

    @Test
    public void 회원중복_체크(){
        UserEntity user1 = new UserEntity();
        Address address = new Address("부산", "남구 용소로", "48449");
        user1.makeUser("김준영", "wns8093", "wns6713", address);

        userService.join(user1);

        UserEntity user2 = new UserEntity();
        Address address2 = new Address("부산", "남구 용소로", "48449");
        user2.makeUser("김준영", "wns8093", "wns6713", address2);

       assertThatThrownBy(() ->  userService.join(user2)).isInstanceOf(IllegalStateException.class);

    }

}