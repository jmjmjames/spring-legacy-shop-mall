package finalterm.controller;

import finalterm.domain.Order;
import finalterm.domain.OrderItem;
import finalterm.domain.User;
import finalterm.dto.LoginDto;
import finalterm.repository.ItemRepository;
import finalterm.repository.OrderRepository;
import finalterm.repository.UserRepository;
import finalterm.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Date;
import java.util.List;

@Controller
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/{itemId}")
    public String orderForm(Integer count, @PathVariable Integer itemId,
                            HttpSession session, Model model) {
        if (count == null) {
            return "redirect:/";
        }

        LoginDto loginDto = (LoginDto) session.getAttribute("auth");
        Order order = orderService.order(loginDto.getUserId(), itemId, count);
        model.addAttribute("order", order);
        model.addAttribute("item", orderService.findItemName(itemId));
        return "/order/orderResult";
    }

    @GetMapping("/orders/{userId}")
    public String historyByUserId(@PathVariable String userId, Model model) {
        List<OrderItem> orderItems = orderService.findByUserId(userId);
        model.addAttribute("orderItems", orderItems);
        return "/order/orders";
    }

    @PostMapping("/orders/search/name")
    public String historyByItemName(String searchCond, Model model, HttpSession session) {

        LoginDto loginDto = (LoginDto) session.getAttribute("auth");

        if (searchCond.isEmpty()) {
            List<OrderItem> orderItems = orderService.findByUserId(loginDto.getUserId());
            model.addAttribute("orderItems", orderItems);
        }

        List<OrderItem> orderItems = orderService.findByItemName(loginDto.getUserId(), searchCond);
        model.addAttribute("orderItems", orderItems);
        return "/order/orders";
    }

    @GetMapping("/orders/search/date")
    public String historyByDate(String startDate, String endDate, Model model, HttpSession session) {

        LoginDto loginDto = (LoginDto) session.getAttribute("auth");

        List<OrderItem> orderItems = orderService.findByDate(loginDto.getUserId(), startDate, endDate);
        model.addAttribute("orderItems", orderItems);
        return "/order/orders";
    }
}
