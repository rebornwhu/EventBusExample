package com.example.eventbusexample;

/**
 * Step 1. Define event class, also define the params you wanna pass into that event
 */
// This is just a POJO, seems like EventBus don't wanna confine the information be sent to be just
// bundle type, you can define whatever complicated data structure as you want
public class ChargingEvent {
    private String data;

    public ChargingEvent(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}