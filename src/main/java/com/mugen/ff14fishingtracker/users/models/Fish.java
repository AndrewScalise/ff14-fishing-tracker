package com.mugen.ff14fishingtracker.users.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Mugen on 7/10/2017.
 */
@Entity
@Table(name="fish")
public class Fish extends AbstractEntity {

    private String name;
    private Time eorzeanTime;
    private User author;
    private String location;
    private String weather;
    private String bait;

    public Fish() {}

    public Fish(String name, Time eorzeanTime, User author, String location, String weather, String bait){
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
    public Time getEorzeanTime(){return eorzeanTime;}

    @NotNull
    @Column(name="location")
    public String getLocation(){return location;}

    @NotNull
    @Column(name="weather")
    public String getWeather(){return weather;}

    @NotNull
    @Column(name="bait")
    public String getBait(){return bait;}
}
