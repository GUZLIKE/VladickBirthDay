package ru.guzlik.vladickbirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public static void hello(){
        System.out.printf("asdsadfdga");
        int i = 0;
    }
}