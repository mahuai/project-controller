package com.pro.learn.beans;

/**
 * @author ms
 * @Description: class description
 * @Package com.pro.learn.beans
 * @date: Created in 2018/9/27  14:06
 */
public class World {

    private Day day;
    private Ground ground;
    private People people;

    public Day getDay() {
        return day;
    }

    public void setDay(Day day) {
        this.day = day;
    }

    public Ground getGround() {
        return ground;
    }

    public void setGround(Ground ground) {
        this.ground = ground;
    }

    public People getPeople() {
        return people;
    }

    public void setPeople(People people) {
        this.people = people;
    }

    public World(Day day, Ground ground, People people) {
        this.day = day;
        System.out.println(day.getWeather());
        this.ground = ground;
        System.out.println(ground.isGarbage());
        this.people = people;
        System.out.println(people.getSex());
    }

    public static World run(Day day, Ground ground, People people) {
        return new World(day, ground, people);
    }
}
