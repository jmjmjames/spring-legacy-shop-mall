package finalterm.controller;

import finalterm.domain.User;
import finalterm.dto.LoginDto;
import finalterm.dto.ModifyDto;
import finalterm.dto.UserDto;
import finalterm.repository.OrderRepository;
import finalterm.repository.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
public class UserController {

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    public UserController(UserRepository userRepository, OrderRepository orderRepository) {
        this.userRepository = userRepository;
        this.orderRepository = orderRepository;
    }

    @GetMapping("/user/join")
    public String joinForm(@ModelAttribute("userDto") UserDto userDto) {
        return "user/joinForm";
    }

    @PostMapping("/user/join")
    public String join(@Valid @ModelAttribute("userDto") UserDto userDto, Errors errors) {

        User findUserByUserId = userRepository.findByUserId(userDto.getUserId());
        User findUserByEmail = userRepository.findByEmail(userDto.getEmail());
        User findUserByPhoneNumber = userRepository.findByPhoneNumber(userDto.getPhoneNumber());

        if (findUserByUserId != null) {
            errors.rejectValue("userId", "duplicated");
        }
        if (findUserByEmail != null) {
            errors.rejectValue("email", "duplicated");
        }
        if (findUserByPhoneNumber != null) {
            errors.rejectValue("phoneNumber", "duplicated");
        }

        if (errors.hasErrors()) {
            return "user/joinForm";
        }

        User user = new User(null, userDto.getUserId(), userDto.getPwd(), userDto.getName(), userDto.getBirthday(),
                userDto.getEmail(), userDto.getAddress(), userDto.getPhoneNumber());
        userRepository.save(user);

        return "user/joinResult";
    }


    @GetMapping("/login")
    public String login(@ModelAttribute("loginDto") LoginDto loginDto,
                        @CookieValue(value = "REMEMBERID", required = false) Cookie rCookie,
                        HttpSession session) {
        if (session == null || session.getAttribute("auth") == null) {
            if (rCookie != null) {
                loginDto.setUserId(rCookie.getValue());
                loginDto.setRememberId(true);
            }
        }
        return "/user/loginForm";
    }

    @PostMapping("/login")
    public String loginResult(@Valid @ModelAttribute("loginDto") LoginDto loginDto, Errors errors,
                              HttpSession session, HttpServletResponse response) {

        User findUser = userRepository.findByUserId(loginDto.getUserId());

        if (findUser == null) {
            return "user/loginForm";
        } else {
            if (findUser.getPwd().equals(loginDto.getPwd())) {
                session.setAttribute("auth", loginDto);
                if (findUser.getUserId().equals("admin")) {
                    session.setAttribute("admin", loginDto);
                }
            } else {
                errors.rejectValue("pwd", "notCorrectPwd");
            }
        }

        if (errors.hasErrors()) {
            return "user/loginForm";
        }

        Cookie rememberCookie = new Cookie("REMEMBERID", loginDto.getUserId());
        rememberCookie.setPath("/login");

        if (loginDto.getRememberId()) {
            rememberCookie.setMaxAge(60 * 60 * 24 * 30);
        } else {
            rememberCookie.setMaxAge(0);
        }

        response.addCookie(rememberCookie);

        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        if (session != null) {
            session.invalidate();
        }
        return "user/logout";
    }

    @GetMapping("/user-info/{id}")
    public String userInfo(Model model, HttpSession session, @PathVariable String id) {

        LoginDto loginDto = (LoginDto) session.getAttribute("auth");
        model.addAttribute("userInfo", userRepository.findByUserId(loginDto.getUserId()));

        return "/user/userInfo";
    }

    @GetMapping("/user-info/modify/{id}")
    public String modifyUserInfo(@ModelAttribute("modifyDto") ModifyDto modifyDto, @PathVariable String id) {
        return "/user/modifyUserInfo";
    }

    @PostMapping("/user-info/modify/{id}")
    public String modifyUserInfoResult(@Valid @ModelAttribute("modifyDto") ModifyDto modifyDto, Errors errors,
                                       @PathVariable String id, Model model) {

        User findUserByUserId = userRepository.findByUserId(id);
        User findUserByEmail = userRepository.findByEmail(modifyDto.getEmail());
        User findUserByPhoneNumber = userRepository.findByPhoneNumber(modifyDto.getPhoneNumber());

        if (findUserByEmail != null) {
            errors.rejectValue("email", "duplicated");
        }
        if (findUserByPhoneNumber != null) {
            errors.rejectValue("phoneNumber", "duplicated");
        }

        if (errors.hasErrors()) {
            return "/user/modifyUserInfo";
        }

        findUserByUserId.setEmail(modifyDto.getEmail());
        findUserByUserId.setAddress(modifyDto.getAddress());
        findUserByUserId.setPhoneNumber(modifyDto.getPhoneNumber());
        userRepository.update(findUserByUserId);

        model.addAttribute("userInfo", findUserByUserId);

        return "/user/userInfo";
    }

    @GetMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable String id, HttpSession session) {
        User user = userRepository.findByUserId(id);
        orderRepository.deleteByUserId(user.getId());
        userRepository.delete(id);
        session.invalidate();
        return "redirect:/";
    }
}


