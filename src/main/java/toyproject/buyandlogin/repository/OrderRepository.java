package toyproject.buyandlogin.repository;

import lombok.RequiredArgsConstructor;
import org.aspectj.weaver.ast.Or;
import org.springframework.stereotype.Repository;
import toyproject.buyandlogin.domain.jpa.Order;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class OrderRepository {

    private final  EntityManager em;

    /**
     * Order 저장
     *  조회
     *  삭제
     *  특정 검색 ( 나중에 구현 )
     */

    public void saveOrder(Order order){
        em.persist(order);
    }

    public Order findOne(Long id){
        return em.find(Order.class,id);
    }

    public List<Order> findOrderAll(){
        return em.createQuery("select o from Order o", Order.class).getResultList();
    }

    public void removeOrder(Long id){
        Order wantToRemove = findOne(id);
        em.remove(wantToRemove);
    }

}
