package toyproject.buyandlogin.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import toyproject.buyandlogin.domain.jpa.*;
import toyproject.buyandlogin.domain.jpa.Item.Item;
import toyproject.buyandlogin.repository.ItemRepository;
import toyproject.buyandlogin.repository.OrderRepository;
import toyproject.buyandlogin.repository.UserRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;
    private final ItemRepository itemRepository;
    private final UserRepository userRepository;

    @Transactional
    public void saveOrder(Long UserId, Long itemId, int count){
        // 엔티티 조회
        UserEntity findUser = userRepository.findById(UserId);
        Item findItem = itemRepository.findOne(itemId);

        //Delivery 생성
        Delivery delivery = Delivery.createDelivery(new Address("서울", "테헤란로", "123"),DeliveryStatus.NOT);

        //OrderItem 만들기
        OrderItem orderItem = OrderItem.createOrderItems(findItem, count, findItem.getPrice());

        //order 생성
        Order order = Order.createOrder(findUser,delivery,orderItem);

        // order 저장
        orderRepository.saveOrder(order);
    }

    public void addItemsOrder(Long orderId, Long itemId, int count){
        // 엔티티 조회
        Order findOrder = orderRepository.findOne(orderId);
        Item item = itemRepository.findOne(itemId);

        // OrderItems 생성
        OrderItem orderItems = OrderItem.createOrderItems(item, count, item.getPrice());

        findOrder.addOrderItems(orderItems);
    }

}
