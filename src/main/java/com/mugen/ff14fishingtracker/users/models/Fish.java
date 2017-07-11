package com.mugen.ff14fishingtracker.users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashMap;

/**
 * Created by Mugen on 7/10/2017.
 */
@Entity
@Table(name="fish")
public class Fish extends AbstractEntity {

    private String name;
    private String time;
    private User author;
    private String location;
    private String weather;
    private String bait;

    public Fish() {}

    public Fish(String name, String time, User author, String location, String weather, String bait){
        super();

        this.name = name;
        this.time = time;
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
    public String getTime(){return time;}

    @NotNull
    @Column(name="location")
    public String getLocation(){return location;}

    @NotNull
    @Column(name="weather")
    public String getWeather(){return weather;}

    @NotNull
    @Column(name="bait")
    public String getBait(){return bait;}

    @ManyToOne
    public User getAuthor(){return author;}

    public void setName(String name) {
        this.name = name;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }
}
