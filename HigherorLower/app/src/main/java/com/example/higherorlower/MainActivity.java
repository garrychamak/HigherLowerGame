package com.example.higherorlower;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int chosenNumber;

    public void generatedRandomNumber(){
        Random rand = new Random();
        chosenNumber = rand.nextInt(20)+1;
    }
    public void onGuess (View view) {
        Log.i("Info", "Button pressed");



        EditText editText = (EditText) findViewById(R.id.editTextGussedNumber);

        Log.i("Info", editText.getText().toString() );

        String guessedNumber = editText.getText().toString();

        double guessedNumberInDouble = Double.parseDouble(editText.getText().toString());

        if(chosenNumber == guessedNumberInDouble)
        {
            Toast.makeText(this, "You are correct. The number is " + chosenNumber, Toast.LENGTH_SHORT).show();
            generatedRandomNumber();
        }
        else if ( guessedNumberInDouble < 1 || guessedNumberInDouble > 20)
        {
            Toast.makeText(this, "You are wrong. The number has to between 1 and 20, Try Again! " , Toast.LENGTH_SHORT).show();

        }
        else if (chosenNumber > guessedNumberInDouble)
        {
            Toast.makeText(this, "You are wrong. The number is HIGHER, Try Again! " , Toast.LENGTH_SHORT).show();
        }
        else if (chosenNumber < guessedNumberInDouble)
        {
            Toast.makeText(this, "You are wrong. The number is LOWER, Try Again! " , Toast.LENGTH_SHORT).show();
        }



    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       generatedRandomNumber();
    }
}