package ru.guzlik.vladickbirthday;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView textLang;


    ImageView creature;

    private String[] textArray = {"Ты где пропадал?!" , "У тебя такое важное задание, а ты хуи пинаешь", "" +
            "Тебе нужно собрать фрагменты 'ВЫШЕГО СУЩЕСТВА' ","БЕЗ НЕГО НАШ МИР БУДЕТ ОБРЕЧЁН!!! ",
            "Нету времени объяснять, отправляем тебя его спасать!"};
    private int counter = -1;
    private int index;

    private boolean isAnimating = false;

    FrameLayout frameLayout;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.activity_main);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textLang = (TextView) findViewById(R.id.text);
        creature = (ImageView) findViewById(R.id.debil);
        frameLayout = (FrameLayout) findViewById(R.id.layout);




        textLang.setVisibility(View.VISIBLE);
        clickCreature();


    }


    void clickCreature() {
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimating) {
                    counter++;
                    int index = counter % textArray.length;
                    animateText(textArray[index], 10); // call the new animateText() method with the current text
                    if (counter >= 5) {
                        textLang.setText("");
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }

    void animateText(String text, int delay) {
        isAnimating = true; // set the flag to indicate that the animation is running
        index = 0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                textLang.setText(text.substring(0, index++));
                if (index <= text.length()) {
                    handler.postDelayed(this, delay); // delay in milliseconds between characters
                } else {
                    isAnimating = false; // reset the flag when the animation is done
                }
            }
        };
        handler.postDelayed(runnable, delay); // delay before starting the animation
    }






}