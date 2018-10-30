package com.pro.learn.beans;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.beans
 * @date: Created in 2018/9/27  14:06
 */
public class Day {

    private String weather;

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public Day(String weather) {
        this.weather = weather;
    }
}
