package ru.guzlik.vladickbirthday;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class ThirdActivity extends AppCompatActivity {


    TextView text1,text2;
    ImageView imageSaitama, creature, creature2;
    Button answer1,answer2,answer3,answer4;

    private int counter = -1;
    private int counter2 = -1;


    private String[] textArray = {"\nОтлично! Мы взломали воспоминания", "\nТеперь нужно ответить на эту хуету",
            "\n\nБля, ну и хуета, давай отгадывай кто это нарисовал", " "};

    private String[] textArray2 = {"\nВсегда знал что это он!", "\nТеперь переносимся к второму фрагменту", " "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.third_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imageSaitama = (ImageView) findViewById(R.id.imageSaitama);
        creature = (ImageView) findViewById(R.id.debil1);
        creature2 = (ImageView) findViewById(R.id.debil2);
        answer1 = (Button) findViewById(R.id.Answer1);
        answer2 = (Button) findViewById(R.id.Answer2);
        answer3 = (Button) findViewById(R.id.Answer3);
        answer4 = (Button) findViewById(R.id.Answer4);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);

        creature2.setVisibility(View.GONE);


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
                creature2.setVisibility(View.VISIBLE);
                creature.setVisibility(View.GONE);
                creature.setEnabled(true);
                text2.setVisibility(View.GONE);
            }
        });


        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Даб даб да. Это же этот дед ебаный");
                creature.setEnabled(true);
                clickCreature2();
                creature2.setVisibility(View.VISIBLE);
                creature.setVisibility(View.GONE);
                text2.setVisibility(View.GONE);

            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("Да, точно!\nЭто же SCP-096!\nДОЛГОВЯЗЫЙ УЕБАН!");
                creature.setEnabled(true);
                clickCreature2();
                creature2.setVisibility(View.VISIBLE);
                creature.setVisibility(View.GONE);
                text2.setVisibility(View.GONE);

            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("РЕАЛЬНО! ЭТО ЖЕ ЛЕКТОР_98!");
                creature.setEnabled(true);
                clickCreature2();
                creature2.setVisibility(View.VISIBLE);
                creature.setVisibility(View.GONE);
                text2.setVisibility(View.GONE);

            }

        });
    }

    void clickCreature2(){
        creature2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            counter2++;
            int index = counter2 % textArray2.length;
            text1.setText(textArray2[index]);
            if(counter2>=2){

                Intent intent = new Intent(ThirdActivity.this, FourthActivity.class);
                startActivity(intent);

            }
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
