package com.example.simeon.eventer;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.eventer.dbEvents.EventAsyncTask;
import com.eventer.dbEvents.EventDB;



public class WelcomeScreen extends ActionBarActivity {

    private Button cameraButton;
    private Button loggin;
    private Button events;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);
        cameraButton = (Button) findViewById(R.id.cameraButton);
        loggin = (Button) findViewById(R.id.logginButton);
        events = (Button) findViewById(R.id.eventButton);

        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(WelcomeScreen.this, CameraActivity.class);
                startActivity(i);
            }
        });
        loggin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EventAsyncTask db = new EventAsyncTask(WelcomeScreen.this);
                db.execute();
            }
        });

        events.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(WelcomeScreen.this, EventActivity.class);
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_welcome_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
