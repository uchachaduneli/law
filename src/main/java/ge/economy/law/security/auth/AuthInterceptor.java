package ge.economy.law.security.auth;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ucha
 */
@Component
public class AuthInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler) throws IOException {

        Integer userId = (Integer) request.getSession().getAttribute("userId");

        if (userId == null && request.getHeader("X-Requested-With") == null) {
            response.sendRedirect("login");
            return false;
        } else if (userId == null) {
            response.sendError(353, "სესიას გაუვიდა ვადა, გთხოვთ თავიდან გაიაროთ ავტორიზაცია");
            return false;
        }
        return true;
    }
}
