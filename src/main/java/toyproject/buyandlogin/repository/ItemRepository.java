package toyproject.buyandlogin.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import toyproject.buyandlogin.domain.jpa.Item.Item;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    /**
     * 저장
     * 단 건 조회
     * 전체 조회
     */

    public void save(Item item){
        em.persist(item);
    }

    public Item findOne(Long id){
        return em.find(Item.class, id);
    }

    public List<Item> findAll(){
        return em.createQuery("select i from Item i", Item.class).getResultList();
    }

}
