package pl.p4welo.fm.domain;

/**
 * Created by parado on 2015-06-15.
 */
public class Team {
    public Team(String name) {
        this.name = name;
    }

    private String name;

    private double power;

    private String color;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPower() {
        return power;
    }

    public void setPower(double power) {
        this.power = power;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
