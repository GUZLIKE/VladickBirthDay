package ru.guzlik.vladickbirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    View mainView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText(mainView);




    }


    public void showText(View view) {
        Toast.makeText(this, "О! ЗДАРОВА ЧЕЛИК! ТУТ КОРОЧЕ НАДО ОДНОГО ЧУВАКА СОБРАТЬ" +
                "ПОШЛИ, ПОМОЖЕШЬ!", Toast.LENGTH_LONG).show();
    }



}