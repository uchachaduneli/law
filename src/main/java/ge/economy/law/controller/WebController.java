package ge.economy.law.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ucha
 */
@Controller
@RequestMapping
public class WebController {

    @RequestMapping("/home")
    public String homeFc() {
        return "home";
    }

    @RequestMapping("/users")
    public String users() {
        return "users";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/")
    public String defaultFnc() {
        return "login";
    }

}
