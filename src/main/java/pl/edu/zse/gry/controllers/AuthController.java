package pl.edu.zse.gry.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.edu.zse.gry.services.IAuthenticationService;
import pl.edu.zse.gry.session.SessionObject;

import javax.annotation.Resource;

@Controller
public class AuthController {

    @Autowired
    IAuthenticationService authenticationService;

    @Resource
    SessionObject sessionObject;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestParam String login,
                        @RequestParam String password) {
        this.authenticationService.authenticate(login, password);

        if(this.sessionObject.isLogged()) {
            return "redirect:/main";
        } else {
            return "redirect:/login";
        }
    }
}
