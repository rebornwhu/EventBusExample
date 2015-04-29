package com.example.eventbusexample;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import de.greenrobot.event.EventBus;


public class DisplayActivity extends Activity {

    private EventBus bus = EventBus.getDefault(); // get instance

    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        view = new TextView(this);

        view.setTextSize(20f);
        view.setPadding(20, 20, 20, 20);
        view.setText("Waiting for events...");

        setContentView(view);

        bus.register(this); // Register as a subscriber
    }

    @Override
    protected void onDestroy() {
        bus.unregister(this); // Unregister
        super.onDestroy();
    }


    public void onEvent(ChargingEvent event) { // implementation of event listener
        view.setText(view.getText() + "\n" + event.getData());
    }
}
