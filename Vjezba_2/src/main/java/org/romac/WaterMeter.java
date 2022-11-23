package org.romac;

import org.romac.mqtt.classes.Publisher;
import org.romac.mqtt.classes.Sensor;
import org.eclipse.paho.client.mqttv3.MqttClient;


public class WaterMeter {
    public static void run(String publisherID, String BROKER_URL, String topic, Sensor[] sensors){
/*
        Sensor wTemp = new Sensor("Temp", -32668, 32668, 10, UnitType.Celsius);
        Sensor wPressure = new Sensor("Pressure", 0, 65336, 1000, UnitType.Bar);
        Sensor wConsumption = new Sensor("ConsumptionMin", 0, 65336, 0, UnitType.Liter);
        Sensor wConsumptionCubic = new Sensor("ConsumptionCubic", 0, 65336, 10, UnitType.Cubicmeter);
*/
        Publisher p = new Publisher(publisherID, BROKER_URL, topic);
        MqttClient client = p.clientStart();

        for(Sensor sensor : sensors) {
            p.publish(client, sensor.getMeasure());
            p.publish(client, sensor.getMeasure());
            p.publish(client, sensor.getMeasure());
            p.publish(client, sensor.getMeasure());
        }

    }
}