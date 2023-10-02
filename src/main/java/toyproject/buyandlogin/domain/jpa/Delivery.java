package toyproject.buyandlogin.domain.jpa;

import javax.persistence.*;

@Entity
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

}
