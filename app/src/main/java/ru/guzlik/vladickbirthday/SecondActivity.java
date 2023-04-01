package ru.guzlik.vladickbirthday;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView text2;

    ImageView creature;

    private String[] textArray = {"Вот и ты на месте"};
    private int counter = -1;

    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        text2 = (TextView) findViewById(R.id.text2);

        creature = (ImageView) findViewById(R.id.debil2);

        text2.setVisibility(View.VISIBLE);
        click();
        showToast();

    }
    void click() {
        creature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                int index = counter % textArray.length;
                text2.setText(textArray[index]);

            }
        });
    }

    public void showToast(){
        Toast.makeText(this, "НАЖМИ НА ЧЕЛОВЕЧКА ЧТОБЫ НАЧАТЬ", Toast.LENGTH_LONG).show();
    }

}
