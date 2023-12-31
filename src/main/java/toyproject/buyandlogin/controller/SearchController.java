package toyproject.buyandlogin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import toyproject.buyandlogin.additems.AddItems;
import toyproject.buyandlogin.annotation.Login;
import toyproject.buyandlogin.domain.OldItem;
import toyproject.buyandlogin.domain.OldItemRepository;
import toyproject.buyandlogin.domain.Member;
import toyproject.buyandlogin.search.SearchAddForm;
import toyproject.buyandlogin.search.SearchForm;

import java.util.List;

@Controller
@Slf4j
@RequiredArgsConstructor
public class SearchController {
    private final OldItemRepository oldItemRepository;
    private final AddItems addItems;

    @GetMapping("/search")
    public String searchGet(@ModelAttribute("item") SearchForm item){
        return "/search/searchPage";
    }

    @PostMapping("/search")
    public String searchPost(@ModelAttribute("item") SearchForm item, RedirectAttributes redirectAttributes){

        String category = item.getCategory();
        redirectAttributes.addAttribute("category", category);

        return "redirect:/search/{category}";
    }

    @GetMapping("/search/{category}")
    public String searchCategoryGet(@PathVariable String category, @ModelAttribute("itemcate") SearchAddForm item, Model model){

        List<OldItem> byCategory = oldItemRepository.findByCategory(category);
        model.addAttribute("items", byCategory);

        return "/search/category";
    }

    @PostMapping("/search/{category}")
    public String searchCategoryPost(@PathVariable String category, @Login Member loginMember,
                                     @ModelAttribute("item") SearchAddForm item, RedirectAttributes redirectAttributes, Model model){


        String category2 = item.getCategory();
        redirectAttributes.addAttribute("category", category2);

        return "redirect:/search/{category}";
    }



}
