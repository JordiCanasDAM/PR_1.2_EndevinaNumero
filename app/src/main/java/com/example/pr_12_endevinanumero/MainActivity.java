package com.example.pr_12_endevinanumero;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //COMPONENTS
        EditText guess = findViewById(R.id.editTextGuess);
        Button check = findViewById(R.id.buttonCheck);

        //BUTTON CLICK
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i("INFO","El número introduït és: ");
            }//onClick method
        });//onClickListener
    }
}