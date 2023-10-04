package toyproject.buyandlogin.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.domain.jpa.UserEntity;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    private final EntityManager em;

    public void save(UserEntity userEntity){
        em.persist(userEntity);
    }

    public UserEntity findById(Long id){
      return  em.find(UserEntity.class, id);
    }

    public List<UserEntity> findByLoginId(String userId){
        return em.createQuery("select u from UserEntity u" +
                " where u.userIdName = :userIdName", UserEntity.class).setParameter("userIdName", userId)
                                                                                                .getResultList();
    }

    public List<UserEntity> findAll(){
        return em.createQuery("select u from UserEntity u", UserEntity.class).getResultList();
    }

}
