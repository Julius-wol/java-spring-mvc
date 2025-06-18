package vn.hoidanit.laptopshop.controller;

import vn.hoidanit.laptopshop.domain.User;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vn.hoidanit.laptopshop.service.UserService;

@Controller
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    public String getHomePage(Model model) {
        List<User> arrUser = this.userService.getAllUserByEmail("kelennguyen300305@gmail.com");
        System.out.println(arrUser);
        model.addAttribute("newUser", "text");
        return "hello";
    }

    @RequestMapping("/admin/user")
    public String getOverviewUserPage(Model model) {
        List<User> users = this.userService.getAllUser();
        model.addAttribute("users1", users);
        return "admin/user/overview";
    }

    @RequestMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @RequestMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/show";
    }

    @RequestMapping("/admin/user/update/{id}")
    public String getUserUpdatePage(Model model, @PathVariable long id) {
        User currentUser = this.userService.getUserById(id);
        model.addAttribute("newUser", currentUser);
        return "admin/user/update";
    }

    @PostMapping(value = "/admin/user/update")
    public String postUpdateUser(Model model, @ModelAttribute("newUser") User khanhhuyen) {
        User currentUser = this.userService.getUserById(khanhhuyen.getId());
        if (currentUser != null) {
            currentUser.setAddress(khanhhuyen.getAddress());
            currentUser.setFullName(khanhhuyen.getFullName());
            currentUser.setPassword(khanhhuyen.getPassword());
            this.userService.handleSaveUser(currentUser);
        }

        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getUserDeletePage(Model model, @PathVariable long id) {
        model.addAttribute("id", id);
        model.addAttribute("newUser", new User());
        return "admin/user/delete";
    }

    @PostMapping(value = "/admin/user/delete")
    public String postDeleteUser(Model model, @ModelAttribute("newUser") User khanhhuyen) {
        this.userService.deleteById(khanhhuyen.getId());
        return "redirect:/admin/user";
    }

    @RequestMapping(value = "/admin/user/create", method = RequestMethod.POST)
    public String createUserPage(Model model, @ModelAttribute("newUser") User khanhhuyen) {
        System.out.println(khanhhuyen);
        this.userService.handleSaveUser(khanhhuyen);
        return "redirect:/admin/user";
    }
}
