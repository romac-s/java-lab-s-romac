package org.romac.mqtt.classes;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttSecurityException;

import java.util.UUID;

public class Publisher {
    private String waterStats ;
    private String broker_url;
    private String publisher_id;

    public Publisher(String publisherID, String BROKER_URL, String topic){
        this.publisher_id = publisherID;
        this.broker_url = BROKER_URL;
        this.waterStats = topic;
    }

    public MqttClient clientStart() {
        //String publisherID = UUID.randomUUID().toString();
        //String BROKER_URL = "tcp://localhost:1883";
        MqttClient client = null;
        try {
            client = new MqttClient(broker_url, publisher_id);
        } catch (MqttException e) {
            e.printStackTrace();
            System.exit(1);
        }
        return client;
    }

    public void publish (MqttClient client, byte[] payload) {
        MqttMessage message = new MqttMessage();
        message.setPayload(payload);
        try {
            client.connect();
            client.publish(waterStats, message);
            client.disconnect();
        } catch (MqttException e) {
            e.printStackTrace();
        }
    }
}
