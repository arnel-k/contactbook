package ba.arnel.spring.mvc.controllers;
import ba.arnel.spring.mvc.viewmodels.UserInputVM;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.ArrayList;



@Controller
public class HomeController {
    private int id = 0;
    private UserInputVM input;

    public HomeController() {
        input = new UserInputVM();
        UserInputVM.rows = new ArrayList<>();
    }

    @GetMapping("/")
    public String index(@ModelAttribute("user") UserInputVM.Row user, ModelMap model) {
        model.addAttribute("users", UserInputVM.rows);
        model.addAttribute("alert", UserInputVM.alertNoData);
        model.addAttribute("alertSuccess", UserInputVM.alertSuccessAdd);
        return "index";
    }

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    public ModelAndView showUser() {
        return new ModelAndView("showuser", "user", new UserInputVM.Row());
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String submit(@Valid @ModelAttribute("user") UserInputVM.Row user, BindingResult result, ModelMap model) {
        if (result.hasErrors()) {
            return "error";
        }

        user.setId(id);
        UserInputVM.rows.add(user);

        ++id;
        model.addAttribute("users", UserInputVM.rows);
        model.addAttribute("alert", UserInputVM.alertSuccessAdd);
        return "index";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    public String Delete(@PathVariable("id") int id, ModelMap model) {
        UserInputVM.Delete(id);

        model.addAttribute("users", UserInputVM.rows);

        return "index";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.GET)
    public ModelAndView Update(@PathVariable("id") int id, ModelMap model) {
        UserInputVM.Row user = new UserInputVM.Row();
        for (UserInputVM.Row u : UserInputVM.rows) {
            if (u.getId() == id) {
                user = u;
            }
        }
        model.addAttribute("user",user);
        return new ModelAndView("update");
    }
    @RequestMapping(value="/updateUser", method = RequestMethod.POST)
    public ModelAndView updateUser(@Valid @ModelAttribute("user") UserInputVM.Row user){
        for(UserInputVM.Row u : UserInputVM.rows){
            if(u.getId() == user.getId()){
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setAddress(user.getAddress());
            }
        }
        return new ModelAndView("redirect:/");
    }
}
