package toyproject.buyandlogin.domain;

import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class OldItemRepository {
    private final Map<Long, OldItem> store = new HashMap<>();
    private Long sequence = 0L;

    public OldItem save(OldItem oldItem){
        oldItem.setId(++sequence);
        store.put(oldItem.getId(), oldItem);
        return oldItem;
    }

    public OldItem findById(Long id){
        OldItem oldItem = store.get(id);
        return oldItem;
    }

    public List<OldItem> findByCategory(String category){
        List<OldItem> collect = findAll().stream().filter(item -> item.getCategory().equals(category)).collect(Collectors.toList());
        return collect;
    }

    public List<OldItem> findAll(){
        return new ArrayList<>(store.values());
    }

    public void clear(){
        store.clear();
    }

}
