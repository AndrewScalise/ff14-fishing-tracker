package com.mugen.ff14fishingtracker.users.controllers;

import com.mugen.ff14fishingtracker.users.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Mugen on 7/10/2017.
 */

@Controller
public class IndexController extends AbstractController{

    @RequestMapping(value = "/index")
    public String index(HttpServletRequest request, Model model){

        //Get current user id
        HttpSession session = request.getSession(true);
        int uid = (int)session.getAttribute(userSessionKey);

        // Fetch users and pass to template
        List<User> users = userDao.findAll();

        //make current user object
        User user = userDao.findByUid(uid);

        //get current user name
        String name = user.getUsername();

        String fishingList = "fishing List";

        if(name == null){
            model.addAttribute("username", "");
        }else {
            model.addAttribute("username", name);
        }
        model.addAttribute("users", users);
        model.addAttribute("fishingList", fishingList);

        return "index";
    }
}
