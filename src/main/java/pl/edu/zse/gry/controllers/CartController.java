package pl.edu.zse.gry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.edu.zse.gry.services.ICartService;
import pl.edu.zse.gry.session.SessionObject;

import javax.annotation.Resource;

@Controller
@RequestMapping(value = "/cart")
public class CartController {

    @Autowired
    ICartService cartService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/add/{id}", method = RequestMethod.GET)
    public String addToCart(@PathVariable int id) {
        this.cartService.addGameByIdToCart(id);
        return "redirect:/main";
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String cart(Model model) {
        model.addAttribute("user", this.sessionObject.getUser());
        model.addAttribute("games", this.sessionObject.getCart());
        return "cart";
    }
}
