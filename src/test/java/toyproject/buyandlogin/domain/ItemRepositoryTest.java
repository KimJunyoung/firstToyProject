package toyproject.buyandlogin.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;


class ItemRepositoryTest {

    ItemRepository itemRepository = new ItemRepository();


    @AfterEach
    void clear(){
        itemRepository.clear();
    }


    @Test
    void save() {
        Item item1 = new Item("Car1", "car", 100);
        Item item2 = new Item("Car2", "car", 100);

        itemRepository.save(item1);
        itemRepository.save(item2);

        assertThat(itemRepository.findAll().size()).isEqualTo(2);
    }

    @Test
    void findById() {
        Item item1 = new Item("Car1", "car", 100);
        itemRepository.save(item1);

        Item byId = itemRepository.findById(1L);

        assertThat(byId).isEqualTo(item1);


    }

    @Test
    void findByCategory() {
        Item item1 = new Item("Car1", "car", 100);
        Item item2 = new Item("Car2", "car", 100);
        itemRepository.save(item1);
        itemRepository.save(item2);


        List<Item> car = itemRepository.findByCategory("car");

        car.forEach(item -> System.out.println(item.getItemName()));

        assertThat(car.get(0)).isEqualTo(item1);


    }
}