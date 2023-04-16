package com.joshscoper.customfood.food.effects;

public class Effect {

    private int duration;
    private String name;

    public Effect(String name, int duration){
        this.duration = duration;
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
