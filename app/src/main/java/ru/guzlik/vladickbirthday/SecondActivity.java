package ru.guzlik.vladickbirthday;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    TextView text2;

    ImageView creature, star;
    EditText password;

    private String[] textArray = {"Вот и ты на месте", "qweqwr", "sdfdfgdgg", "fdefwegrg", "fwefwegweg"};
    private int counter = -1;



    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        text2 = (TextView) findViewById(R.id.text2);
        creature = (ImageView) findViewById(R.id.debil2);
        star = (ImageView) findViewById(R.id.star);
        password = (EditText) findViewById(R.id.password);


        password.setVisibility(View.GONE);
        star.setEnabled(false);
        text2.setVisibility(View.VISIBLE);
        click();
        showToast();
        clickStar();
        passwordInputListener();

    }
    void click() {
        creature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                int index = counter % textArray.length;
                text2.setText(textArray[index]);
                if (counter >= 5){
                    text2.setText("");
                    star.setEnabled(true);
                }

            }
        });
    }

    public void showToast(){
        Toast.makeText(this, "НАЖМИ НА ЧЕЛОВЕЧКА ЧТОБЫ НАЧАТЬ", Toast.LENGTH_LONG).show();
    }



    void passwordInputListener(){
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE){
                    String enteredPassword = password.getText().toString();
                    if (!TextUtils.isEmpty(enteredPassword)){
                        text2.setText("\t\t\nТЫ ЧЁ ЕБЛАН? \t\t\nТЫ РЕАЛЬНО ДУМАЛ ЧТО \t\t\nУ НЕГО ТАКОЙ ПАРОЛЬ?");
                        password.setVisibility(View.GONE);
                    } else {
                        text2.setText("ПОСОСИ");
                    }
                    return true;
                }
                return false;
            }
        });
    }


    void clickStar(){
        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                star.setVisibility(View.GONE);
                password.setVisibility(View.VISIBLE);
                    password.requestFocus();
                    InputMethodManager imm = (InputMethodManager)
                            getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.showSoftInput(password,InputMethodManager.SHOW_IMPLICIT);
            }
        });
    }



}


