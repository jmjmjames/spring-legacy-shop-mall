package finalterm.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = req.getSession();

        if (session != null) {
            Object authInfo = session.getAttribute("auth");
            if (authInfo != null) {
                return true;
            }
        }
        response.sendRedirect(req.getContextPath() + "/login");
        return false;
    }
}

