package model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Weapon {

    public enum Type {
        ARTILLERY, FLAMETHROWER, EXPLOSIVE, FIREARM, BLADED, THROWING, IMPACT
    }
    private Type type;
    private String name;
    private int damages;
    private int cost;
    private int level;
    private Location location;



    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDamages() {
        return damages;
    }

    public void setDamages(int damages) {
        this.damages = damages;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return damages == weapon.damages &&
                cost == weapon.cost &&
                level == weapon.level &&
                type == weapon.type &&
                Objects.equals(name, weapon.name) &&
                Objects.equals(location, weapon.location);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, name.toLowerCase(), damages, cost, level, location);
    }



    public static class Builder {
        private final Weapon newWeapon;

        public Builder() {
            newWeapon = new Weapon();
        }

        public Builder withType(Type type){
            newWeapon.type = type;
            return this;
        }

        public Builder withName(String name){
            newWeapon.name = name;
            return this;
        }

        public Builder withDamages(int damages){
            newWeapon.damages = damages;
            return this;
        }

        public Builder withCost(int cost){
            newWeapon.cost = cost;
            return this;
        }

        public Builder withLevel(int level){
            newWeapon.level = level;
            return this;
        }

        public Builder withLocation(Location location){
            newWeapon.location = location;
            return this;
        }



        public Weapon build(){
            return newWeapon;
        }
    }

    @Override
    public String toString() {
        return "Weapon { " +
                "type = " + type +
                ", name = '" + name + '\'' +
                ", level = " + level +
                ", damages = " + damages +
                ", cost = " + cost +
                ", location = " + location +
                '}';
    }
    public Weapon fromString(String input) {
        Weapon newObj = new Weapon();
        input = input.replaceAll("Weapon", "");
        input = input.replaceAll("[\\{}]", "");
        input = input.replaceAll("'", "");
        String locinp = input.split("Location")[1];
        input = input.split("Location")[0];


        String type = input.substring(input.indexOf("type = ")+7, input.indexOf(","));
        input = input.split(type+", ")[1];

        String name = input.substring(input.indexOf("name = ")+7, input.indexOf(","));
        input = input.split(name+", ")[1];

        int level = Integer.parseInt(input.substring(input.indexOf("level = ")+8, input.indexOf(",")));
        input = input.split("level = " + level + ", ")[1];

        int damages = Integer.parseInt(input.substring(input.indexOf("damages = ")+10, input.indexOf(",")));
        input = input.split("damages = " + damages + ", ")[1];

        int cost = Integer.parseInt(input.substring(input.indexOf("cost = ")+7, input.indexOf(",")));
        input = input.split("cost = " + cost + ", ")[1];

        newObj.type = Type.valueOf(type);
        newObj.name = name;
        newObj.level = level;
        newObj.damages = damages;
        newObj.cost = cost;
        newObj.location = new Location().fromString(locinp);

        return newObj;
    }

}
