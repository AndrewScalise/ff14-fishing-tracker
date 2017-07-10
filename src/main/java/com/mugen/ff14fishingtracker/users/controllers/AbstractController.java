package com.mugen.ff14fishingtracker.users.controllers;

import com.mugen.ff14fishingtracker.users.models.User;
import com.mugen.ff14fishingtracker.users.models.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Mugen on 7/10/2017.
 */
public abstract class AbstractController {

    @Autowired
    protected UserDao userDao;

    public static final String userSessionKey = "user_id";

    protected User getUserFromSession(HttpSession session) {

        Integer userId = (Integer) session.getAttribute(userSessionKey);
        return userId == null ? null : userDao.findByUid(userId);
    }

    protected void setUserInSession(HttpSession session, User user) {
        session.setAttribute(userSessionKey, user.getUid());
    }

    public void loginHelper(HttpServletRequest request, User user){
        HttpSession thisSession = request.getSession();
        setUserInSession(thisSession, user);
    }

}
