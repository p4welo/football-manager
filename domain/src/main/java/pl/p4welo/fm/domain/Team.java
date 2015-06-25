package pl.p4welo.fm.domain;

/**
 * Created by parado on 2015-06-15.
 */
public class Team {

    private int id;
    private String name;
    private int power;
    private String color;

    public Team(String name) {
        this.name = name;
    }

    public Team(int id, String name, int power, String color) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
