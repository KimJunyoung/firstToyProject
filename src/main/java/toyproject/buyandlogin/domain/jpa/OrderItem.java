package toyproject.buyandlogin.domain.jpa;

import javax.persistence.*;

@Entity
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    private Item item;

    private Order order;

    private int count;
    private int orderPrice;



}
