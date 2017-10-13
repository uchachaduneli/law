package ge.economy.law.controller;

import ge.economy.law.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * @author ucha
 */
@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

//    @RequestMapping("/get-mobile-users")
//    @ResponseBody
//    private List<MobileUsersDTO> getMobileUsers() throws Exception {
////        return usersService.getMobileUsers();
//        return null;
//    }

}
