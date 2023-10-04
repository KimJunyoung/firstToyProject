package toyproject.buyandlogin.domain.jpa;

import lombok.Builder;
import lombok.Getter;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

@Entity
@Getter
public class Delivery {

    @Id
    @GeneratedValue
    @Column(name = "delivery_id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    private Order order;

    @Embedded
    private Address deliveryAddress;

    private DeliveryStatus deliveryStatus;

    public void addOrder(Order order){
        this.order = order;
    }

    public Delivery() {
    }

    @Builder
    public Delivery(Address deliveryAddress, DeliveryStatus deliveryStatus) {
        this.deliveryAddress = deliveryAddress;
        this.deliveryStatus = deliveryStatus;
    }


    public static Delivery createDelivery(Address deliveryAddress, DeliveryStatus deliveryStatus){
        Delivery delivery = Delivery.builder().deliveryAddress(deliveryAddress).deliveryStatus(deliveryStatus).build();
        return delivery;
    }
}
