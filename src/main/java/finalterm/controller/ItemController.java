package finalterm.controller;

import finalterm.repository.ItemRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;

@Controller
public class ItemController {

    private final ItemRepository itemRepository;

    public ItemController(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    @GetMapping("/item/detail/{id}")
    public String itemInfo(Model model, HttpSession session, @PathVariable Integer id) {
        model.addAttribute("itemInfo", itemRepository.findById(id));

        return "/item/itemInfo";
    }

    @GetMapping("/item/type")
    public String itemSearchType(@ModelAttribute("searchCond") ItemSearchCond searchCond) {
        return "/item/searchForm";
    }

    @PostMapping("/item/type")
    public String itemSearchType(@ModelAttribute("searchCond") ItemSearchCond searchCond, Model model) {
        model.addAttribute("items", itemRepository.findByType(searchCond.getSearch()));
        return "/item/item-list";
    }

    @GetMapping("/item/name")
    public String itemSearchName(@ModelAttribute("searchCond") ItemSearchCond searchCond) {
        return "/item/searchForm";
    }

    @PostMapping("/item/name")
    public String itemSearchName(@ModelAttribute("searchCond") ItemSearchCond searchCond, Model model) {
        model.addAttribute("items", itemRepository.findByName(searchCond.getSearch()));
        return "/item/item-list";
    }

    @GetMapping("/item/company")
    public String itemSearchCompany(@ModelAttribute("searchCond") ItemSearchCond searchCond) {
        return "/item/searchForm";
    }

    @PostMapping("/item/company")
    public String itemSearchCompany(@ModelAttribute("searchCond") ItemSearchCond searchCond, Model model) {
        model.addAttribute("items", itemRepository.findByCompany(searchCond.getSearch()));
        return "/item/item-list";
    }
}
