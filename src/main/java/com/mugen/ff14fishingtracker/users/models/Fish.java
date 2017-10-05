package com.mugen.ff14fishingtracker.users.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Time;
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
    private int locationID;
    private String weather;
    private String bait;

    public Fish() {}

    public Fish(String name, String time, User author, String location, int locationID, String weather, String bait){
        super();

        this.name = name;
        this.time = time;
        this.author = author;
        this.location = location;
        this.weather = weather;
        this.bait = bait;
        this.locationID = locationID;



        author.addFish(this);
    }

    @NotNull
    @Column(name="name")
    @Size(min=1, max=20)
    public String getName() {return name;}

    @NotNull
    @Column(name="time")
    public String getTime(){return time;}

    @NotNull
    @Column(name="location")
    public String getLocation(){return location;}

    @NotNull
    @Column(name="locationID")
    public int getLocationID(){return locationID;}

    @NotNull
    @Column(name="weather")
    public String getWeather(){return weather;}

    @NotNull
    @Column(name="bait")
    @Size(min=1, message = "Must specify bait")
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

    public void setLocationID(int locationID){this.locationID = locationID;}

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public void setBait(String bait) {
        this.bait = bait;
    }
}
