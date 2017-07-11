package com.mugen.ff14fishingtracker.users.controllers;

import com.mugen.ff14fishingtracker.users.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Mugen on 7/10/2017.
 */

@Controller
public class IndexController extends AbstractController{

    @RequestMapping(value = "/index")
    public String index(Model model){
        // Fetch users and pass to template
        List<User> users = userDao.findAll();

        String fishingList = "fishing List";
        model.addAttribute("users", users);
        model.addAttribute("fishingList", fishingList);

        return "index";
    }
}
