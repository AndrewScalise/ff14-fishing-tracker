package com.mugen.ff14fishingtracker.users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mugen on 7/10/2017.
 */
@Entity
@Table(name="fish")
public class Fish extends AbstractEntity {

    private String name;
    private String eorzeanTime;
    private User author;
    private HashMap<Integer, String> location;
    private ArrayList<String> weather;
    private String bait;

    public Fish() {}

    public Fish(String name, String eorzeanTime, User author, HashMap<Integer, String> location, ArrayList<String> weather, String bait){
        super();

        this.name = name;
        this.eorzeanTime = eorzeanTime;
        this.author = author;
        this.location = location;
        this.weather = weather;
        this.bait = bait;

        author.addFish(this);
    }

    @NotNull
    @Column(name="name")
    public String getName() {return name;}

    @NotNull
    @Column(name="time")
    public String getEorzeanTime(){return eorzeanTime;}

    @NotNull
    @Column(name="location")
    public HashMap<Integer, String> getLocation(){return location;}

    @NotNull
    @Column(name="weather")
    public ArrayList<String> getWeather(){return weather;}

    @NotNull
    @Column(name="bait")
    public String getBait(){return bait;}

    @ManyToOne
    public User getAuthor(){return author;}

    public void setName(String name) {
        this.name = name;
    }

    public void setEorzeanTime(String eorzeanTime) {
        this.eorzeanTime = eorzeanTime;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setLocation(HashMap<Integer, String> location) {
        this.location = location;
    }

    public void setWeather(ArrayList<String> weather) {
        this.weather = weather;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }
}
