package ru.guzlik.vladickbirthday;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class FourthActivity extends AppCompatActivity {

    TextView text1,text2, berserk;

    ImageView creature,creature2;

    Button answer1, answer2, answer3, answer4;

    private int counter = -1;
    private int counter2 = -1;

    private String[] textArray = {"\nОтлично! Мы получили первый фрагмент", "\nТеперь нужно ответить на эту хуету",
            "\n\nЭто изи для тебя будет", " "};

    private String[] textArray2 = {"\n 0 ошибок гений!", "\n Мы получили второй фрагмент",
            "\n\nТеперь переходим в последний", " "};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.fourth_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        creature = (ImageView) findViewById(R.id.debil1);
        creature2 = (ImageView) findViewById(R.id.debil2);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        creature2.setVisibility(View.GONE);
        text2.setVisibility(View.GONE);


        berserk = (TextView) findViewById(R.id.berserk);

        answer1 = (Button) findViewById(R.id.Answer1);
        answer2 = (Button) findViewById(R.id.Answer2);
        answer3 = (Button) findViewById(R.id.Answer3);
        answer4 = (Button) findViewById(R.id.Answer4);
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);


        clickCreature();
        clickAnswers();


    }

    void clickAnswers() {
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Почти угадал");
                creature.setEnabled(false);
            }
        });


        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Смысле не правильно?!");
                creature.setEnabled(false);
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Не понял :(");
                creature.setEnabled(false);
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("ДА!");
                creature.setVisibility(View.GONE);
                creature2.setVisibility(View.VISIBLE);
                text2.setVisibility(View.VISIBLE);
                creature.setEnabled(true);
                clickCreature2();
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

    void clickCreature2() {
        creature2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("");
                counter2++;
                int index = counter2 % textArray2.length;
                text2.setText(textArray2[index]);
                if (counter2 >= 4) {
                    text2.setText("");
                    Intent intent = new Intent(FourthActivity.this, FifthActivity.class);
                    startActivity(intent);

                }
            }
        });
    }




}
