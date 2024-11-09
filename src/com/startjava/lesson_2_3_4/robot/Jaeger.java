package com.startjava.lesson_2_3_4.robot;

public class Jaeger {

    private String name;
    private int launched;
    private String status;
    private int height;
    private String weapons;
    private int amountAmmunition;

    public Jaeger() {}

    public Jaeger(String name, int launched, String status,
            int height, String weapons, int amountAmmunition) {
        this.name = name;
        this.launched = launched;
        this.status = status;
        this.height = height;
        this.weapons = weapons;
        this.amountAmmunition = amountAmmunition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLaunched() {
        return launched;
    }

    public void setLaunched(int launched) {
        this.launched = launched;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getWeapons() {
        return weapons;
    }

    public void setWeapons(String weapons) {
        this.weapons = weapons;
    }

    public int getAmountAmmunition() {
        return amountAmmunition;
    }

    public void setAmountAmmunition(int amountAmmunition) {
        this.amountAmmunition = amountAmmunition;
    }

    public void useWeapon() {
        System.out.println(name + " использует оружие: " + weapons);
    }
}