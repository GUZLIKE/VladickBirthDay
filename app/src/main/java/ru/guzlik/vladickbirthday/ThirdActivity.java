package ru.guzlik.vladickbirthday;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ThirdActivity extends AppCompatActivity {


    TextView text1;
    ImageView imageSaitama, creature;
    Button answer1,answer2,answer3,answer4;

    private int counter = -1;


    private String[] textArray = {"\nОтлично! Мы взломали воспоминания", "\nТеперь нужно ответить на эту хуету",
            "\n\nБля, ну и хуета, давай отгадывай кто это нарисовал", " "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imageSaitama = (ImageView) findViewById(R.id.imageSaitama);
        creature = (ImageView) findViewById(R.id.debil1);
        answer1 = (Button) findViewById(R.id.Answer1);
        answer2 = (Button) findViewById(R.id.Answer2);
        answer3 = (Button) findViewById(R.id.Answer3);
        answer4 = (Button) findViewById(R.id.Answer4);
        text1 = (TextView) findViewById(R.id.text1);


        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);

        clickCreature();
        clickAnswers();

    }

    void clickAnswers(){
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("РЕАЛЬНО! ЭТО ЖЕ ЭТОТ LEKNER_89!");
                creature.setEnabled(true);
            }
        });


        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Даб даб да. Это же этот дед ебаный");
                creature.setEnabled(true);
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Да, точно!\nЭто же SCP-096!\nДОЛГОВЯЗЫЙ УЕБАН!");
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("РЕАЛЬНО! ЭТО ЖЕ ЛЕКТОР_98!");
            }
        });
    }





    void clickCreature() {
        creature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    counter++;
                    int index = counter % textArray.length;
                    text1.setText(textArray[index]);
                    if (counter >= 4) {
                        text1.setText("");
                        creature.setEnabled(false);
                        answer1.setEnabled(true);
                        answer2.setEnabled(true);
                        answer3.setEnabled(true);
                        answer4.setEnabled(true);
                    }
                }
            });
    }


}
