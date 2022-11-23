package org.romac.mqtt;

import org.romac.WaterMeter;
import org.romac.mqtt.classes.Sensor
import org.romac.mqtt.enums.UnitType;

import java.util.UUID;

public class App {
    public static void main(String[] args) throws InterruptedException {
        String publisherID = UUID.randomUUID().toString();
        String BROKER_URL = "tcp://localhost:1883";
        String topic = "Water_Stats";
        Sensor sensors[] = new Sensor[4];//listu
        sensors[0] = new Sensor("Temp", -32668, 32668, 10, UnitType.Celsius);
        sensors[1] = new Sensor("Pressure", 0, 65336, 1000, UnitType.Bar);
        sensors[2] = new Sensor("ConsumptionMin", 0, 65336, 0, UnitType.Liter);
        sensors[3] = new Sensor("ConsumptionCubic", 0, 65336, 10, UnitType.Cubicmeter);

        WaterMeter test = new WaterMeter();
        test.run(publisherID, BROKER_URL, topic, sensors);
    }
}

