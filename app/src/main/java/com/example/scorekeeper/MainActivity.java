package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static String STATE_SCORE_1;
    private static String STATE_SCORE_2;
    int scoreT1 = 0;
    int scoreT2 = 0;
    private TextView puntosT1;
    private TextView puntosT2;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.night_mode:
                int nm = AppCompatDelegate.getDefaultNightMode();
                if (nm == AppCompatDelegate.MODE_NIGHT_YES) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                }
                recreate();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
//Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        STATE_SCORE_1 = "team1";
        STATE_SCORE_2 = "team2";
        puntosT1 = findViewById(R.id.textoPuntosT1);
        puntosT2 = findViewById(R.id.textoPuntosT2);
        if (savedInstanceState != null) {
            scoreT1 = savedInstanceState.getInt(STATE_SCORE_1);
            scoreT2 = savedInstanceState.getInt(STATE_SCORE_2);
//Set the score text views
            puntosT1.setText(String.valueOf(scoreT1));
            puntosT2.setText(String.valueOf(scoreT2));

        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
//Save the scores
        outState.putInt(STATE_SCORE_1, scoreT1);
        outState.putInt(STATE_SCORE_2, scoreT2);
        super.onSaveInstanceState(outState);
    }

    public void increaseScore(View v) {
        if (v.equals(findViewById(R.id.masT1))) {
            this.scoreT1++;
            puntosT1.setText(Integer.toString(scoreT1));
        }
        if (v.equals(findViewById(R.id.masT2))) {
            this.scoreT2++;
            puntosT2.setText(Integer.toString(scoreT2));
        }
    }

    public void decreaseScore(View v) {
        if (v.equals(findViewById(R.id.menosT1))) {
            this.scoreT1--;
            puntosT1.setText(Integer.toString(scoreT1));
        }
        if (v.equals(findViewById(R.id.menosT2))) {
            this.scoreT2--;
            puntosT2.setText(Integer.toString(scoreT2));
        }
    }


}
