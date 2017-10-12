package ge.abara.mobile.security.auth;

import ge.abara.mobile.dto.UsersDTO;
import ge.abara.mobile.security.api.SecurityAPI;
import ge.abara.mobile.security.api.User;
import ge.abara.mobile.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author ucha
 */
@Controller
@RequestMapping
public class AuthController {

    @Autowired
    private UsersService usersService;

    @Autowired(required = false)
    private SecurityAPI secApi;

    @RequestMapping(value = "/login", method = {RequestMethod.GET})
    public String login(HttpServletRequest request) {
        try {
            Integer loginedUserId = (Integer) request.getSession().getAttribute("userId");
            if (loginedUserId == null) {
                return "login";
            } else {
                if ((Integer) request.getSession().getAttribute("typeId") == UsersDTO.USER_ADMIN ||
                        (Integer) request.getSession().getAttribute("typeId") == UsersDTO.USER_ADMIN_MANAGER) {
                    return "redirect:restaurants";
                } else {
                    return "redirect:restinfo";
                }
            }
        } catch (Exception ex) {
            return "login";
        }

    }

//    @RequestMapping(value = "/login", method = {RequestMethod.POST})
//    public String verify(@RequestParam(value = "uri", required = false) String originalUri, HttpServletRequest request, HttpServletResponse response) throws IOException {
//
////        Map<String, Object> params = new HashMap<>();
////
////        originalUri = (originalUri != null && !originalUri.isEmpty()) ? originalUri : secApi.getHomePage();
////        for (String p : secApi.getLoginParameters()) {
////            String v = request.getParameter(p);
////            if (v == null || v.trim().length() < 1) {
//////                response.sendError(400, p + " is required");
////            }
////            params.put(p, v);
////        }
//
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        UsersDTO foundedUser = usersService.login(username, password);
//        if (foundedUser != null) {
//            request.getSession().setAttribute("userId", foundedUser.getUserId());
//            request.getSession().setAttribute("firstname", foundedUser.getFirstname());
//            request.getSession().setAttribute("lastname", foundedUser.getLastname());
//            request.getSession().setAttribute("typeId", foundedUser.getTypeId());
//            request.getSession().setAttribute("restaurantId",
//                    foundedUser.getRestaurantId() != null ? foundedUser.getRestaurantId() : 0);
////            request.getSession().setMaxInactiveInterval(60);
////            response.sendRedirect("/restinfo");
//            if (foundedUser.getTypeId() == UsersDTO.USER_ADMIN || foundedUser.getTypeId() == UsersDTO.USER_ADMIN_MANAGER) {
//                return "redirect:restaurants";
//            } else {
//                return "redirect:restinfo";
//            }
//        } else {
//            response.sendError(400, "Incorrect username or password");
//            return null;
//        }

//        User user = secApi.getUser(params);
//        if (user != null) {
//            request.getSession().setAttribute(AuthInterceptor.CURRENT_USER, user);
//        } else {
//            response.sendError(400, "Incorrect username or password");
//        }
//        return "redirect:" + originalUri;
//    }

    @RequestMapping(value = "/logout", method = {RequestMethod.GET, RequestMethod.POST})
    public String logout(HttpSession session) {
        session.removeAttribute("userId");
        session.removeAttribute("firstname");
        session.removeAttribute("lastname");
        session.removeAttribute("typeId");
        session.removeAttribute("restaurantId");
        session.invalidate();
        return "redirect:" + secApi.getLoginPage();
    }

    @RequestMapping(value = "/status", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public Object status(HttpSession session, HttpServletResponse response) throws IOException {
        User u = (User) session.getAttribute(AuthInterceptor.CURRENT_USER);
        if (u != null) {
            return u;
        }
        response.sendError(400, "Unauthorized");
        return null;
    }

    @ResponseBody
    @RequestMapping(value = "/get-user", method = {RequestMethod.GET, RequestMethod.POST})
    public User getUser(HttpServletRequest httpServletRequest) {
        User user = (User) httpServletRequest.getSession().getAttribute(AuthInterceptor.CURRENT_USER);
        return user;
    }

    @ResponseBody
    @RequestMapping(value = "/get-crnt-user", method = {RequestMethod.GET, RequestMethod.POST})
    public Integer getLoginedUser(HttpServletRequest httpServletRequest) {
        Integer loginedUserId = (Integer) httpServletRequest.getSession().getAttribute("userId");
        return loginedUserId;
    }
}
