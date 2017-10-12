package ge.abara.mobile.controller;

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

    @RequestMapping("/restinfo")
    public String restinfo() {
        return "restinfo";
    }

    @RequestMapping("/restaurants")
    public String restaurants() {
        return "restaurants";
    }

    @RequestMapping("/")
    public String defaultFnc() {
        return "login";
    }

    @RequestMapping("/dishes")
    public String dishes() {
        return "dishes";
    }

    @RequestMapping("/offers")
    public String offers() {
        return "offers";
    }

    @RequestMapping("/restdashboard")
    public String restdashboard() {
        return "restdashboard";
    }

    @RequestMapping("/statistics")
    public String statistics() {
        return "statistics";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

}
