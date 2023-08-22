package toyproject.buyandlogin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import toyproject.buyandlogin.additems.AddItems;

import toyproject.buyandlogin.domain.Member;


@Controller
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/add")
public class AddItemController {


    private final AddItems addItems;

    @GetMapping("/{id}")
    public String AddItemGet(){
        return "/add/items";
    }

    @PostMapping("/{id}")
    public String AddItemPost(@PathVariable Long id, @SessionAttribute(name = "CookieSession", required = false) Member loginMember){;
        addItems.save(loginMember, id);
        return "redirect:/add/{id}";
    }



}
