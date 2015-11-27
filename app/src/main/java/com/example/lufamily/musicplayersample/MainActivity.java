package com.example.lufamily.musicplayersample;

import android.content.Intent;
import android.media.MediaPlayer;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private String[] song;
    public Spinner spinner;
    MediaPlayer mp = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        song = getResources().getStringArray(R.array.songs);
        spinner = (Spinner) findViewById(R.id.spinnerSongs);

        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, song);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void onClickProceed(View v)
    {
        String songz = String.valueOf(spinner.getSelectedItem());   //GET SPINNER VALUE
        Intent output;

        if(songz.equals("Radioactive"))
        {
            stopPlaying();
            Toast.makeText(getApplicationContext(), "Radioactive is playing. . .", Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(MainActivity.this, R.raw.radioactive);
            mp.start();
        }

        else if(songz.equals("Fearless"))
        {
            stopPlaying();
            Toast.makeText(getApplicationContext(), "Fearless is playing. . .", Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(MainActivity.this, R.raw.fearless);
            mp.start();
        }

        else if(songz.equals("Ang Huling El Bimbo"))
        {
            stopPlaying();
            Toast.makeText(getApplicationContext(), "Ang Huling El Bimbo is playing. . .", Toast.LENGTH_SHORT).show();
            mp = MediaPlayer.create(MainActivity.this, R.raw.elbimbo);
            mp.start();
        }
    }

    private void stopPlaying()
    {
        if (mp != null) {
            mp.stop();
            mp.release();
            mp = null;
        }
    }

    public void onClickStop(View v)
    {
        stopPlaying();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
