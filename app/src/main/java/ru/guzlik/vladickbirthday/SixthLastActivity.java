package ru.guzlik.vladickbirthday;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class SixthLastActivity extends AppCompatActivity {


    TextView textEnd, textEnd2;

    ImageView debilEnd,debilEnd2,gigaGuz,gigaDed, cake;

    Button buttonBlow;


    MediaPlayer dark;

    String[] arrayTextEnd = {"Вот мы и добрались до сюда...", "Наконец-то твой путь завершается...",
            "Давай я покажу зачем мы собирали эти элементы...", " "};

    String[] arrayTextEnd2 = {"Как ты мог забыть что у тебя день рожденья?",
            "Тебе исполнилось 20! Уже через 10 лет ты сможешь стать магом!", "Загадывай желание и задувай свечи!", " ", " "};

    int counter = -1;

    int counter2 = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.sixlast_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        cake = (ImageView) findViewById(R.id.cake);
        gigaGuz = (ImageView) findViewById(R.id.gigaGuz);
        gigaDed = (ImageView) findViewById(R.id.gigaDed);
        textEnd = (TextView) findViewById(R.id.textEnd);
        textEnd2 = (TextView) findViewById(R.id.textEnd2);
        debilEnd = (ImageView) findViewById(R.id.debilEnd);
        debilEnd2 = (ImageView) findViewById(R.id.debilEnd2);
        buttonBlow = (Button) findViewById(R.id.buttonBlow);
        dark = (MediaPlayer) MediaPlayer.create(SixthLastActivity.this,R.raw.dark);
        debilEnd2.setVisibility(View.GONE);
        gigaDed.setVisibility(View.GONE);
        gigaGuz.setVisibility(View.GONE);
        cake.setVisibility(View.GONE);
        buttonBlow.setVisibility(View.GONE);
        textEnd2.setVisibility(View.GONE);
        clickDebilEnd();
        clickDebilEnd2();
        clickButtonBlow();
        dark.start();
        dark.setVolume(10,10);
    }


    void clickDebilEnd() {
        debilEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextAnimation.isAnimating) {
                    counter++;
                    int index = counter % arrayTextEnd.length;
                    TextAnimation.animateText(textEnd, arrayTextEnd[index], 10);
                    if (counter >= 4){
                        debilEnd.setEnabled(false);
                        debilEnd.setVisibility(View.GONE);
                        debilEnd2.setVisibility(View.VISIBLE);
                        cake.setVisibility(View.VISIBLE);
                        gigaGuz.setVisibility(View.VISIBLE);
                        gigaDed.setVisibility(View.VISIBLE);
                        textEnd2.setVisibility(View.VISIBLE);
                        textEnd.setVisibility(View.GONE);

                    }

                }
            }
        });

    }


    void clickDebilEnd2(){
        debilEnd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextAnimation.isAnimating){
                    counter2++;
                    int index = counter2 % arrayTextEnd2.length;
                    TextAnimation.animateText(textEnd2, arrayTextEnd2[index],10);
                    if (counter2 >= 4){
                        debilEnd2.setEnabled(false);
                        buttonBlow.setVisibility(View.VISIBLE);
                    }
                }
            }
        });
    }

    void clickButtonBlow(){
        buttonBlow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dark.stop();
                Intent intent = new Intent(SixthLastActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
