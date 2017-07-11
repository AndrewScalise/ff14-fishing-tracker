package com.mugen.ff14fishingtracker.users.controllers;

import com.mugen.ff14fishingtracker.users.models.Fish;
import com.mugen.ff14fishingtracker.users.models.User;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mugen on 7/11/2017.
 */
@Controller
public class FishController extends AbstractController {

    @RequestMapping(value= "/addFish", method = RequestMethod.GET)
    public String displayAddFishForm(Model model){
        model.addAttribute(new Fish());
        model.addAttribute("title", "Add Fish");

        //Create Hashmap for locations
        HashMap<Integer, String> locations = new HashMap<>();

        locations.put(156,"Isle of Endless Summer North Shore");
        locations.put(157, "Kugane Piers");
        locations.put(158, "The Ruby Price");
        locations.put(159,"Hells' Lid");
        locations.put(160,"The Isle of Bekko");
        locations.put(161,"Shoal Rock");
        locations.put(162,"Onokoro");
        locations.put(163, "Isari");
        locations.put(164,"The Isle of Zekki");
        locations.put(165,"The Heron's Nest");
        locations.put(166, "The Heron's Way");
        locations.put(167,"Namai");
        locations.put(168,"Prism Lake");
        locations.put(169,"Prism Canyon");
        locations.put(170,"Doma Castle");
        locations.put(171,"Mercantile Docks");
        locations.put(172,"The One River East");
        locations.put(173,"The One River West");
        locations.put(174,"Plum Spring");
        locations.put(175,"Nem Khaal");
        locations.put(176,"Hak Khaal");
        locations.put(177,"Upper Yat Khaal");
        locations.put(178,"Azim Khaal");
        locations.put(179,"Tao Khaal");
        locations.put(180,"Lower Yat Khaal");
        locations.put(181,"Dotharl Khaa");
        locations.put(182,"Upper Mirage Creek");
        locations.put(183,"Rhalgr's Reach");
        locations.put(184,"The Outer Fist");
        locations.put(185,"Timmon Beck");
        locations.put(186, "Dimwold");
        locations.put(187,"The Comet's Tail");
        locations.put(188,"The Velodyna River");
        locations.put(189,"Mirage Creek");
        locations.put(190,"Grymm and Enid");
        locations.put(191,"The Slow Wash");
        locations.put(192, "Heather Falls");
        locations.put(193,"The Ephor");
        locations.put(194,"The Bull's Bath");
        locations.put(195, "The Arms of Meed");
        locations.put(196,"Loch Seld");
        locations.put(197,"Shirogane");
        locations.put(198,"The Silver Canal");

        model.addAttribute("locations", locations);



        //Create Array List for different weather
        ArrayList<String> weather = new ArrayList<>();

        weather.add("Blizzard");
        weather.add("Clear Skies");
        weather.add("Clouds");
        weather.add("Fog");
        weather.add("Dust");
        weather.add("Gales");
        weather.add("Gloom");
        weather.add("Heat Waves");
        weather.add("Rain");
        weather.add("Sandstorms");
        weather.add("Showers");
        weather.add("Snow");
        weather.add("Sunshine");
        weather.add("Thunder");
        weather.add("Thunderstorms");
        weather.add("Umbral Static");
        weather.add("Umbral Wind");
        weather.add("Wind");

        model.addAttribute("weather", weather);


        return "addFish";
    }

    @RequestMapping(value="/addFish", method = RequestMethod.POST)
    public String processAddFish(HttpServletRequest request, Model model){

        //Implement add fish to user's list



        //get request parameters
        String name = request.getParameter("name");
        String time = request.getParameter("time");
        String bait = request.getParameter("bait");
        String error = request.getParameter("error");
        String locations = request.getParameter("locations");
        String weather = request.getParameter("weather");


        HttpSession session = request.getSession(true);
        int uid = (int) session.getAttribute(userSessionKey);
        User user = userDao.findByUid(uid);

        if(!name.equals(null)){
            Fish fish = new Fish(name, time, user, locations, weather, bait);
            fishDao.save(fish);
            return "/index";
        }
        else if(!error.equals(null)){
            return "You must be logged in to add a fish!";
        }

        return "redirect:/index";
    }


}
