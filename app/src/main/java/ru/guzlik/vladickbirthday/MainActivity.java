package ru.guzlik.vladickbirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;
    Button button;

    private String[] textArray = {"О! ЗДОРОВА! ТУТ ОДНОГО ЧЕЛА НАДО СОБРАТЬ!" , "ПОШЛИ ПОМОЖЕШЬ!"};
    private int counter = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        button = (Button) findViewById(R.id.button);
        text.setVisibility(View.VISIBLE);
        click();

    }


    void click(){
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                int index = counter % textArray.length;
                text.setText(textArray[index]);
                if (counter >= 4){
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
    }






}