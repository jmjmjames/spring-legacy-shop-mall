package finalterm.controller;

import finalterm.domain.Item;
import finalterm.dto.ItemDto;
import finalterm.dto.LoginDto;
import finalterm.dto.ItemUpdateDto;
import finalterm.repository.ItemRepository;
import finalterm.repository.UserRepository;
import finalterm.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AdminController {

    private final OrderService orderService;
    private final UserRepository userRepository;
    private final ItemRepository itemRepository;

    public AdminController(OrderService orderService, UserRepository userRepository, ItemRepository itemRepository) {
        this.orderService = orderService;
        this.userRepository = userRepository;
        this.itemRepository = itemRepository;
    }

    /**
     * 새로운 아이템 등록
     */
    @GetMapping("/admin/item/join")
    public String joinForm(@ModelAttribute("itemDto") ItemDto itemDto, HttpSession session) {
        LoginDto admin = (LoginDto) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/";
        }
        return "admin/itemForm";
    }

    @PostMapping("/admin/item/join")
    public String join(@Valid @ModelAttribute("itemDto") ItemDto itemDto, Errors errors, HttpSession session) {

        LoginDto admin = (LoginDto) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/";
        }

        if (errors.hasErrors()) {
            return "admin/itemForm";
        }

        Item item = new Item(null, itemDto.getName(), itemDto.getPrice(), itemDto.getStockQuantity(), itemDto.getdType(),
                itemDto.getCompany(), itemDto.getDetail());
        itemRepository.save(item);
        return "admin/joinResult";
    }

    /**
     * 아이템 추가하기
     */
    @GetMapping("/admin/item/add")
    public String addForm(@ModelAttribute("itemUpdateDto") ItemUpdateDto itemUpdateDto, HttpSession session) {
        LoginDto admin = (LoginDto) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/";
        }
        return "admin/addForm";
    }

    @PostMapping("/admin/item/add")
    public String addStockQuantity(@Valid @ModelAttribute("itemUpdateDto") ItemUpdateDto itemUpdateDto, Errors errors, HttpSession session) {

        LoginDto admin = (LoginDto) session.getAttribute("admin");
        if (admin == null) {
            return "redirect:/";
        }

        if (errors.hasErrors() || itemUpdateDto.getStockQuantity() == null) {
            return "admin/addForm";
        }

        List<Item> item = itemRepository.findByName(itemUpdateDto.getName());
        if (item == null) {
            errors.rejectValue("name", "noFound");
            return "admin/addForm";
        }
        itemRepository.addStock(item.get(0), itemUpdateDto.getStockQuantity());
        return "redirect:/";
    }

}
