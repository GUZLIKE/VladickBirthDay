package ru.guzlik.vladickbirthday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text;


    ImageView creature;

    private String[] textArray = {"Ты где пропадал?!" , "У тебя такое важное задание, а ты хуи пинаешь", "" +
            "Тебе нужно собрать фрагменты 'ВЫШЕГО СУЩЕСТВА' ","БЕЗ НЕГО НАШ МИР БУДЕТ ОБРЕЧЁН!!! ",
            "Нету времени объяснять, отправляем тебя его спасать!"};
    private int counter = -1;


    FrameLayout frameLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = (TextView) findViewById(R.id.text);
        creature = (ImageView) findViewById(R.id.debil);
        frameLayout = (FrameLayout) findViewById(R.id.frame);




        text.setVisibility(View.VISIBLE);
        clickCreature();


    }


    void clickCreature() {
        frameLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                int index = counter % textArray.length;
                text.setText(textArray[index]);
                if (counter >= 5) {
                    text.setText("");
                    Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
//
//    public void showToast(){
//        Toast.makeText(this, "НАЖМИ НА ЧЕЛОВЕЧКА ЧТОБЫ НАЧАТЬ", Toast.LENGTH_LONG).show();
//    }





}