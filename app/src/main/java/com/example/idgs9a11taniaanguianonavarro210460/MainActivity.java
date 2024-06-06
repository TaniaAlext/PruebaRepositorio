package com.example.idgs9a11taniaanguianonavarro210460;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btn_roll;
    private Random random;
    private int currentDiceRoll;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.iv_dice);
        btn_roll = findViewById(R.id.btn_roll);
        random = new Random();


        // Restaurar el estado si existe
        if (savedInstanceState != null) {
            currentDiceRoll = savedInstanceState.getInt("currentDiceRoll");
            updateDiceImage(currentDiceRoll);
        } else {
            currentDiceRoll = 1; // Valor inicial
            updateDiceImage(currentDiceRoll);
        }

        btn_roll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                rollDice();
            }
        });
    }

    private void rollDice() {
        currentDiceRoll = random.nextInt(6) + 1; // Genera un número entre 1 y 6
        updateDiceImage(currentDiceRoll);
    }

    private void updateDiceImage(int roll) {
        int drawableResource = getResources().getIdentifier(
                "dice_" + roll, "drawable", getPackageName());
        imageView.setImageResource(drawableResource);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("currentDiceRoll", currentDiceRoll); // Guardar el estado del dado
    }
}