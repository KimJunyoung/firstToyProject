package toyproject.buyandlogin.domain.jpa;

import lombok.Builder;
import lombok.Getter;
import toyproject.buyandlogin.domain.jpa.Item.Item;

import javax.persistence.*;

@Entity
@Getter
@Table(name = "order_item")
public class OrderItem {

    @Id
    @GeneratedValue
    @Column(name = "order_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "item_id")
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    private int count;
    private int orderPrice;


    public OrderItem() {
    }

    @Builder
    public OrderItem(Item item, int count, int orderPrice) {
        this.item = item;
        this.count = count;
        this.orderPrice = orderPrice;
    }

    // 연관관계 메서드
    public void addOrder(Order order){
        this.order = order;
    }

    public static OrderItem createOrderItems(Item item, int count, int orderPrice){
        OrderItem orderItem = OrderItem.builder().item(item).count(count).orderPrice(orderPrice).build();
        item.removeStack(count);

        return orderItem;
    }

    // 서비스 로직
    public void cancel() {
        getItem().addStock(count);
    }
}
