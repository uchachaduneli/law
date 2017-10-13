package ge.economy.law.security.auth;

import ge.economy.law.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author ucha
 */
@Controller
@RequestMapping
public class AuthController {

    @Autowired
    private UsersService usersService;

//    @RequestMapping(value = "/login", method = {RequestMethod.GET})
//    public String login(HttpServletRequest request) {
//        try {
//            Integer loginedUserId = (Integer) request.getSession().getAttribute("userId");
//            if (loginedUserId == null) {
//                return "login";
//            } else {
//                if ((Integer) request.getSession().getAttribute("typeId") == UsersDTO.USER_ADMIN ||
//                        (Integer) request.getSession().getAttribute("typeId") == UsersDTO.USER_ADMIN_MANAGER) {
//                    return "redirect:restaurants";
//                } else {
//                    return "redirect:restinfo";
//                }
//            }
//        } catch (Exception ex) {
//            return "login";
//        }
//
//    }
}
