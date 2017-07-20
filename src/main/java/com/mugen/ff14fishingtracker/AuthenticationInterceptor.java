package com.mugen.ff14fishingtracker;

import com.mugen.ff14fishingtracker.users.controllers.AbstractController;
import com.mugen.ff14fishingtracker.users.models.User;
import com.mugen.ff14fishingtracker.users.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class AuthenticationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    UserDao userDao;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        List<String> authPages = Arrays.asList("/addFish");
        List<String> authPagesTwo = Arrays.asList("/remove");

        // Require sign-in for auth pages
        if ( authPages.contains(request.getRequestURI()) || authPagesTwo.contains(request.getRequestURI())) {

            boolean isLoggedIn = false;
            User user;
            Integer userId = (Integer) request.getSession().getAttribute(AbstractController.userSessionKey);

            if (userId != null) {
                user = userDao.findByUid(userId);

                if (user != null) {
                    isLoggedIn = true;
                }
            }

            // If user not logged in, redirect to login page
            if (!isLoggedIn) {
                response.sendRedirect("/login");
                return false;
            }
        }

        return true;
    }

}
