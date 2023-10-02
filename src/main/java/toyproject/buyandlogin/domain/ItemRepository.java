package toyproject.buyandlogin.domain;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class ItemRepository {
    private final Map<Long, Item> store = new HashMap<>();
    private Long sequence = 0L;

    public Item save(Item item){
        item.setId(++sequence);
        store.put(item.getId(), item);
        return item;
    }

    public Item findById(Long id){
        Item item = store.get(id);
        return item;
    }

    public List<Item> findByCategory(String category){
        List<Item> collect = findAll().stream().filter(item -> item.getCategory().equals(category)).collect(Collectors.toList());
        return collect;
    }

    public List<Item> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clear(){
        store.clear();
    }

}
