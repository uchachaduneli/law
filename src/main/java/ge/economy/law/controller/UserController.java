package ge.abara.mobile.controller;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import ge.abara.mobile.dao.AddUserRequest;
import ge.abara.mobile.dto.ErrorCodesDTO;
import ge.abara.mobile.dto.MobileUsersDTO;
import ge.abara.mobile.dto.UsersDTO;
import ge.abara.mobile.misc.Response;
import ge.abara.mobile.service.AbaraException;
import ge.abara.mobile.service.UsersService;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @author ucha
 */
@RequestMapping("/users")
@Controller
public class UserController {

    @Autowired
    private UsersService usersService;

    @RequestMapping("/get-mobile-users")
    @ResponseBody
    private List<MobileUsersDTO> getMobileUsers() throws Exception {
        return usersService.getMobileUsers();
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    @ResponseBody
    private MobileUsersDTO addApplicant(HttpServletRequest request) throws Exception {
//        int loginType, String firstName, String lastName, String email, String password,
//                String pushToken, String phoneNumber, String viber, String skype


        if (request.getParameter("loginType") == null || request.getParameter("loginType").length() == 0
                || Integer.parseInt(request.getParameter("loginType")) < 1) {
            throw new AbaraException("ავტორიზაციის ტიპის(loginType) მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
        }
        if (request.getParameter("firstName") == null || request.getParameter("firstName").length() == 0) {
            throw new AbaraException("firstName -ის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
        }
        if (request.getParameter("lastName") == null || request.getParameter("lastName").length() == 0) {
            throw new AbaraException("lastName -ის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
        }
        int loginType = Integer.parseInt(request.getParameter("loginType"));
        if (loginType != MobileUsersDTO.LOGIN_TYPE_USER_PASS) {
            if (request.getParameter("token") == null || request.getParameter("token").length() == 0) {
                throw new AbaraException("token -ის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
            }
        } else {
            if (request.getParameter("email") == null || request.getParameter("email").length() == 0) {
                throw new AbaraException("email -ის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
            }
            if (request.getParameter("password") == null || request.getParameter("password").length() == 0) {
                throw new AbaraException("პაროლის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
            }
        }
        if (loginType == MobileUsersDTO.LOGIN_TYPE_FACEBOOK) {//ფეისბუქის უზერით რეგისტრაცია
            FacebookClient facebookClient = new DefaultFacebookClient(request.getParameter("token"), Version.VERSION_2_10);
            com.restfb.types.User user = facebookClient.fetchObject("me", com.restfb.types.User.class, Parameter.with("fields", "id,name,last_name,email,birthday,first_name,last_name"));
//                System.out.println("ID=" + user.getId());
//                System.out.println("name=" + user.getName());
//                System.out.println("email= " + user.getEmail());
            if (user == null || user.getEmail().length() == 0) {
                throw new AbaraException("თოქენით ელ. ფოსტის ამოღება ვერ მოხერხდა", ErrorCodesDTO.INCORRECT_TOKEN);
            }
            return usersService.addUser(MobileUsersDTO.LOGIN_TYPE_FACEBOOK, request.getParameter("firstName"),
                    request.getParameter("lastName"), user.getEmail(), user.getEmail(),
                    request.getParameter("push_token"), request.getParameter("phone_number"),
                    request.getParameter("viber"), request.getParameter("skype"));
        } else if (loginType == MobileUsersDTO.LOGIN_TYPE_GOOGLE) {//გუგლის უზერით რეგისტრაცია
            HttpClient client = new HttpClient();
            GetMethod method = new GetMethod("https://www.googleapis.com/userinfo/v2/me?access_token=" + request.getParameter("token"));
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3, false));
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }
            byte[] responseBody = method.getResponseBody();
            JSONObject myObject = new JSONObject(new String(responseBody));
            method.releaseConnection();

            if (myObject.getString("email") == null || myObject.getString("email").length() == 0) {
                throw new AbaraException("თოქენით ელ. ფოსტის ამოღება ვერ მოხერხდა", ErrorCodesDTO.INCORRECT_TOKEN);
            }
            return usersService.addUser(MobileUsersDTO.LOGIN_TYPE_GOOGLE, request.getParameter("firstName"),
                    request.getParameter("lastName"), myObject.getString("email"), myObject.getString("email"),
                    request.getParameter("push_token"), request.getParameter("phone_number"),
                    request.getParameter("viber"), request.getParameter("skype"));
        } else {// ჩვენი უზერით რეგისტრაცია
            return usersService.addUser(MobileUsersDTO.LOGIN_TYPE_USER_PASS, request.getParameter("firstName"),
                    request.getParameter("lastName"), request.getParameter("email"), request.getParameter("password"),
                    request.getParameter("push_token"), request.getParameter("phone_number"),
                    request.getParameter("viber"), request.getParameter("skype"));
        }
    }

    @RequestMapping("/change-password")
    @ResponseBody
    private UsersDTO changePassword(HttpSession session, @RequestBody AddUserRequest request) throws Exception {
        request.setUserId((Integer) session.getAttribute("userId"));
        UsersDTO userDTO = usersService.changePassword(request);
        return userDTO;
    }

    @RequestMapping(value = "/restorepassword", method = RequestMethod.POST)
    @ResponseBody
    private MobileUsersDTO restorePassword(HttpServletRequest request) throws Exception {

        if (request.getParameter("email") == null || request.getParameter("email").length() == 0) {
            throw new AbaraException("ელ. ფოსტის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
        }
        if (request.getParameter("code") == null || request.getParameter("code").length() == 0) {
            throw new AbaraException("აქტივაციის კოდის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
        }
        if (request.getParameter("new_password") == null || request.getParameter("new_password").length() == 0) {
            throw new AbaraException("ახალი პაროლის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
        }
        MobileUsersDTO mobileUserDTO = usersService.restorePassword(
                request.getParameter("email"),
                request.getParameter("code"),
                request.getParameter("new_password")
        );
        return mobileUserDTO;
    }

    @RequestMapping(value = "/resetpassword", method = RequestMethod.POST)
    @ResponseBody
    private MobileUsersDTO resetPassword(HttpServletRequest request) throws Exception {
        if (request.getParameter("email") == null || request.getParameter("email").length() == 0) {
            throw new AbaraException("ელ. ფოსტის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
        }
        MobileUsersDTO mobileUserDTO = usersService.resetPassword(request.getParameter("email"));
        return mobileUserDTO;
    }

    @ResponseBody
    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    private MobileUsersDTO mobileLogin(HttpServletRequest request) throws Exception {
        if (request.getParameter("loginType") == null || request.getParameter("loginType").length() == 0) {
            throw new AbaraException("ავტორიზაციის ტიპის(loginType) მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
        }
        int loginType = Integer.parseInt(request.getParameter("loginType"));
        if (loginType != MobileUsersDTO.LOGIN_TYPE_USER_PASS) {
            if (request.getParameter("token") == null || request.getParameter("token").length() == 0) {
                throw new AbaraException("token -ის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
            }
        } else {
            if (request.getParameter("client_id") == null || request.getParameter("client_id").length() == 0) {
                throw new AbaraException("client_id -ის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
            }
            if (request.getParameter("password") == null || request.getParameter("password").length() == 0) {
                throw new AbaraException("პაროლის მითითება სავალდებულოა", ErrorCodesDTO.INCORRECT_REQUEST_FORMAT);
            }
        }
        if (loginType == MobileUsersDTO.LOGIN_TYPE_FACEBOOK) {//ფეისბუქის უზერით ავტორიზაცია
            FacebookClient facebookClient = new DefaultFacebookClient(request.getParameter("token"), Version.VERSION_2_10);
            com.restfb.types.User user = facebookClient.fetchObject("me", com.restfb.types.User.class, Parameter.with("fields", "id,name,email,birthday,first_name,last_name"));
            return usersService.login(user.getEmail(), null, MobileUsersDTO.LOGIN_TYPE_FACEBOOK);
        } else if (loginType == MobileUsersDTO.LOGIN_TYPE_GOOGLE) {//გუგლის უზერით ავტორიზაცია
            HttpClient client = new HttpClient();
            GetMethod method = new GetMethod("https://www.googleapis.com/userinfo/v2/me?access_token=" + request.getParameter("token"));
            method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,
                    new DefaultHttpMethodRetryHandler(3, false));
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("Method failed: " + method.getStatusLine());
            }
            byte[] responseBody = method.getResponseBody();
            JSONObject myObject = new JSONObject(new String(responseBody));
            method.releaseConnection();
            return usersService.login(myObject.getString("email"), null, MobileUsersDTO.LOGIN_TYPE_GOOGLE);
        } else {// ჩვენი უზერით ავტორიზაცია
            String username = request.getParameter("client_id");
            String password = request.getParameter("password");
            MobileUsersDTO foundedUser = usersService.login(username, password, loginType);
            if (foundedUser != null) {
                request.getSession().setAttribute("userId", foundedUser.getId());
                return foundedUser;
            } else {
                throw new AbaraException("მომხმარებელი ვერ მოიძებნა", ErrorCodesDTO.INCORRECT_CLIENT_ID);
            }
        }
    }
}
