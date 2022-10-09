package com.example.pr_12_endevinanumero;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class HighScore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        //TextView
        /*
        TextView scores = findViewById(R.id.textView3);
        for (String[] a : MainActivity.highScores){scores.setText(a[0] + ":" + a[1]);};
        */

        //TableLayout
        TableLayout scoreTable = findViewById(R.id.scoresTable);

        TableRow row = new TableRow(this);

        TextView score = new TextView(this);
        score.setText("SCORE");
        score.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        row.addView(score);

        TextView user = new TextView(this);
        user.setText("USERS");
        user.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        row.addView(user);

        scoreTable.addView(row);

        for (String[] a : MainActivity.highScores){

            row = new TableRow(this);

            user = new TextView(this);
            user.setText(a[0]);
            user.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            row.addView(user);

            score = new TextView(this);
            score.setText(a[1]);
            score.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
            row.addView(score);

            scoreTable.addView(row);

        }
    }
}