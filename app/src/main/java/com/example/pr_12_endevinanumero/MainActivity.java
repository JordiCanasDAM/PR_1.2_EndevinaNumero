package com.example.pr_12_endevinanumero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variables
        Random rng = new Random();
        int objective = rng.nextInt(99)+1;
        final int[] tries = {0};
        Log.i("INFO","Objective: "+ objective );

        //COMPONENTS
        EditText guess = findViewById(R.id.editTextGuess);
        Button check = findViewById(R.id.buttonCheck);
        TextView inputsBoard = findViewById(R.id.inputsBoard);
        inputsBoard.setMovementMethod(new ScrollingMovementMethod());

        //BUTTON CLICK
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (guess.getText().toString().isEmpty() == false) {
                    tries[0] += 1;
                    Log.i("INFO", "Tries: " + tries[0]);
                    if (Integer.parseInt(guess.getText().toString()) < objective) {
                        Log.i("INFO", "Smaller than obj");
                        Toast.makeText(getBaseContext(), "El nombre és major", Toast.LENGTH_SHORT).show();
                    }
                    if (Integer.parseInt(guess.getText().toString()) > objective) {
                        Log.i("INFO", "Greater than obj");
                        Toast.makeText(getBaseContext(), "El nombre és menor", Toast.LENGTH_SHORT).show();
                    }
                    if (objective == Integer.parseInt(guess.getText().toString())) {
                        Log.i("INFO", "WINNER");
                        Toast.makeText(getBaseContext(), "Ho has endevinat!", Toast.LENGTH_SHORT).show();
                        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                        alert.setTitle("VICTORIA");
                        alert.setMessage("Vols registrar la teva victòria a la taula de rècords?");
                        alert.setPositiveButton("Si", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("INFO","Si");
                            }
                        });
                        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("INFO","No");
                            }
                        });
                        alert.create().show();
                    }
                    inputsBoard.setText(inputsBoard.getText().toString()+"Intent: "+tries[0]+") Numero: "+guess.getText().toString()+"\n");
                }
            }//onClick method
        });//onClickListener
    }
}