package com.example.eventbusexample;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.format.Time;

import de.greenrobot.event.EventBus;

/**
 * Step 2. Fire that event
 */
public class ChargingReceiver extends BroadcastReceiver {

    private EventBus bus = EventBus.getDefault();

    @Override
    public void onReceive(Context context, Intent intent) {
        ChargingEvent event = null;

        // Get current time
        Time now = new Time();
        now.setToNow();
        String timeOfEvent = now.format("%H:%M:%S");

        String eventData = "@" + timeOfEvent + " this device started ";
        if (intent.getAction().equals(Intent.ACTION_POWER_CONNECTED)) {
            event = new ChargingEvent(eventData + "charging."); // prepare the argument you wanna pass in
        }
        else if (intent.getAction().equals(Intent.ACTION_POWER_DISCONNECTED)) {
            event = new ChargingEvent(eventData+"discharging.");
        }

        // Post the event
        bus.post(event); // post that event
    }

}
