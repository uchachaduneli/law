package ge.economy.law.controller;

import ge.economy.law.misc.Response;
import ge.economy.law.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * @author ucha
 */
@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/get-users")
    @ResponseBody
    private Response getUsers() throws Exception {
        return Response.withSuccess(usersService.getUsers());
    }

}
