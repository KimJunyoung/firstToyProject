package toyproject.buyandlogin.domain.jpa;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    @Column(name = "order_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "order")
    private List<OrderItem> orderItems = new ArrayList<>();

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "delivery_id")
    private Delivery delivery;

    private OrderStatus orderStatus;

    public Order() {
    }

    @Builder
    public Order(UserEntity userEntity, Delivery delivery) {
        this.userEntity = userEntity;
        this.delivery = delivery;
        this.orderStatus = OrderStatus.ORDER;

        // 연관관계
        delivery.addOrder(this);
    }

    // 연관관계 메서드
    public void addOrderItems(OrderItem orderItem){
        this.orderItems.add(orderItem);
        orderItem.addOrder(this);
    }

    private void setStatus(OrderStatus orderStatus){
        this.orderStatus = orderStatus;
    }


    // 생성메서드
    public static Order createOrder(UserEntity user, Delivery delivery, OrderItem... orderItems){
        Order order = Order.builder().userEntity(user).delivery(delivery).build();
        for (OrderItem orderItem : orderItems) {
            order.addOrderItems(orderItem);
        }

        return order;
    }

    // 서비스 로직
    public void cancel(){
        if(delivery.getDeliveryStatus() == DeliveryStatus.COMP) {
            throw new IllegalStateException("이미 배송완료된 상품은 취소가 불가능합니다.");
        }
        this.setStatus(OrderStatus.CANCEL);
        for (OrderItem orderItem : orderItems) {
            orderItem.cancel();
        }
    }

}
