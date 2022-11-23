package org.romac.mqtt.classes;

import org.romac.mqtt.enums.UnitType;

public class Sensor {
    private String sensorName;
    private int min;
    private int max;
    private int factor;
    private UnitType unit;

    public Sensor(String name, int min, int max, int factor, UnitType unit) {
        this.sensorName = name;
        this.min = min * factor;
        this.max = max * factor;
        if(factor == 0){
            this.factor = 1;
        }
        else{
        this.factor = factor;
        }
        this.unit = unit;
    }

    public byte[] getMeasure(){
        int random = ((int)Math.round((Math.random() * (max - min + 1) + min)) / factor);
        String payload = sensorName +": " + random + " " + unit + "\n ";
        return payload.getBytes();
    }
}
