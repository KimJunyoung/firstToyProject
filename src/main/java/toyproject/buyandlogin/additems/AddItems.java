package toyproject.buyandlogin.additems;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import toyproject.buyandlogin.domain.Item;
import toyproject.buyandlogin.domain.ItemRepository;
import toyproject.buyandlogin.domain.Member;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddItems {

    private final ItemRepository itemRepository;

//    public List<Item> save(Member member, Long id) {
//        Item item= itemRepository.findById(id);
//        List<Item> items = member.getItems();
//        items.add(item);
//        return items;
//    }
}
