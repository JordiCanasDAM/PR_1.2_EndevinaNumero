package com.example.pr_12_endevinanumero;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.app.Activity;
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

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int tries = 0;
    static ArrayList<String[]> highScores = new ArrayList<String[]>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Variables
        Random rng = new Random();
        int objective = rng.nextInt(99)+1;
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
                if (!guess.getText().toString().isEmpty()) {
                    tries += 1;
                    Log.i("INFO", "Tries: " + tries);
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
                                //Inserció a records
                                EditText name = new EditText(MainActivity.this);
                                alert.setTitle("Registre a la taula de rècords");
                                alert.setMessage("Escriu el teu nom:");
                                alert.setPositiveButton("Registrar", new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {
                                        if(name.length()>0) {
                                            //Guardat de record
                                            String[] record = new String[2];
                                            record[0] = String.valueOf(tries);
                                            record[1] = name.getText().toString();
                                            highScores.add(record);
                                            Log.i("Info","Registrat");
                                            //Canvi de pantalla
                                            Intent intent = new Intent(MainActivity.this, HighScore.class);
                                            finish();
                                            intent.putExtra("Scores", highScores);
                                            startActivity(intent);
                                        }
                                    }
                                });
                                alert.setNegativeButton("Cancelar", new DialogInterface.OnClickListener(){
                                    @Override
                                    public void onClick(DialogInterface dialogInterface, int i) {

                                    }
                                });
                                alert.setView(name);
                                alert.create().show();
                            }
                        });
                        alert.setNegativeButton("No", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                Log.i("INFO","No");
                                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                                finish();
                                startActivity(intent);
                            }
                        });
                        alert.create().show();
                    }
                    inputsBoard.setText(inputsBoard.getText().toString()+"Intent: "+tries+") Numero: "+guess.getText().toString()+"\n");
                }
            }//onClick method
        });//onClickListener
    }
}