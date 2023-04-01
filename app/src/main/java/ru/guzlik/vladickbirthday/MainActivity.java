package ru.guzlik.vladickbirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;

    ImageView creature;

    private String[] textArray = {"О! ЗДОРОВА! ТУТ ОДНОГО ЧЕЛА НАДО СОБРАТЬ!" , "ПОШЛИ ПОМОЖЕШЬ!"};
    private int counter = 1;


    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        creature = (ImageView) findViewById(R.id.debil);
        text.setVisibility(View.VISIBLE);
        click();
        showToast();

    }


    void click() {
        creature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                int index = counter % textArray.length;
                text.setText(textArray[index]);
                if (counter >= 4) {
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    public void showToast(){
        Toast.makeText(this, "НАЖМИ НА ЧЕЛОВЕЧКА ЧТОБЫ НАЧАТЬ", Toast.LENGTH_LONG).show();
    }



}