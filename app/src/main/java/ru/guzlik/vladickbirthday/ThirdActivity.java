package ru.guzlik.vladickbirthday;

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


    private String[] textArray = {"Вот мы и на месте", "Перед тобой 'Мысли вышего существа'", "Нажми на них и взломай", " "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        imageSaitama = (ImageView) findViewById(R.id.imageSaitama);
        creature = (ImageView) findViewById(R.id.debil1);
        Button answer1 = findViewById(R.id.Answer1);
        Button answer2 = findViewById(R.id.Answer2);
        Button answer3 = findViewById(R.id.Answer3);
        Button answer4 = findViewById(R.id.Answer4);
        imageSaitama.setVisibility(View.GONE);
        answer1.setVisibility(View.GONE);
        answer2.setVisibility(View.GONE);
        answer3.setVisibility(View.GONE);
        answer4.setVisibility(View.GONE);


    }
    void click() {
        creature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    counter++;
                    int index = counter % textArray.length;
                    text1.setText(textArray[index]);
                    if (counter >= 3) {
                        text1.setText("");
                        creature.setEnabled(false);
                    }

            }
        });
    }



    void zaebal() {
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


    }
}
