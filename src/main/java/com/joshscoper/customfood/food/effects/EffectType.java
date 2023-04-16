package com.joshscoper.customfood.food.effects;

public enum EffectType {
    WELL_FED(WellFed.class);

    private Class<? extends Effect> effect;

    EffectType(Class<? extends Effect> effect){
        this.effect = effect;
    }

    public Class<?extends Effect> getEffect() {return effect;}


}
