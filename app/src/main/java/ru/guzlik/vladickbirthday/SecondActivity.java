package ru.guzlik.vladickbirthday;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
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
    TextView text2, text3, text4;

    ImageView creature,creatureSecond,creatureThird, star;
    EditText password;

    EditText сhineseQuestion;

    EditText task;




    private String[] textArray = {"Вот мы и на месте", "Перед тобой 'Мысли вышего существа'", "Нажми на них и взломай", " "};
    private String[] textArrayTask = {"Я думал ты знаешь пароль", "Нужен другой способ взломать", "Попробуй вот это", " "};
    private String[] textArrayInChinese = {"Мне просто нужно было для своих нужд", "Тебе надо перевести это слово", " "};
    private int counter = -1;
    private int counterTask = -1;
    private int counterInChinese = -1;
    private int index;

    private boolean isAnimating = false;
    private String  answer = "4";
    private String  сhinese = "Нахуя тут на китайском написано";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        creature = (ImageView) findViewById(R.id.debil2);
        creatureSecond = (ImageView) findViewById(R.id.debil3);
        creatureThird = (ImageView) findViewById(R.id.debil4);
        star = (ImageView) findViewById(R.id.star);
        password = (EditText) findViewById(R.id.password);
        сhineseQuestion = (EditText) findViewById(R.id.сhineseQuestion);
        creatureSecond.setVisibility(View.GONE);
        creatureThird.setVisibility(View.GONE);
        task = (EditText) findViewById(R.id.task);

        task.setVisibility(View.GONE);
        сhineseQuestion.setVisibility(View.GONE);
        password.setVisibility(View.GONE);
        star.setEnabled(false);
        text2.setVisibility(View.VISIBLE);
        text3.setVisibility(View.VISIBLE);
        text4.setVisibility(View.VISIBLE); // ?
        click();
        showToast();
        clickStar();
        passwordInputListener();
        clickTask();
        QuestionInChinese();

    }

    void click() {
        creature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimating){
                counter++;
                int index = counter % textArray.length;
                animateText2(textArray[index],10);
                if (counter >= 3) {
                    text2.setText("");
                    star.setEnabled(true);
                    creature.setEnabled(false);
                }

            }
        }
    });
}




    void passwordInputListener() {
        password.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    String enteredPassword = password.getText().toString();
                    if (!TextUtils.isEmpty(enteredPassword)) {
                        isAnimating = false;
                        animateText2("ТЫ ЧЁ ЕБЛАН? ТЫ РЕАЛЬНО ДУМАЛ ЧТО У НЕГО ТАКОЙ ПАРОЛЬ?",10);
                        star.setVisibility(View.GONE);
                        password.setVisibility(View.GONE);
                        creature.setEnabled(true);
                        creature.setVisibility(View.GONE);
                        creatureSecond.setVisibility(View.VISIBLE);


                    } else {
                        isAnimating = false;
                        animateText2("ПОСОСИ",10);
                        star.setVisibility(View.GONE);
                        password.setVisibility(View.GONE);
                        creature.setEnabled(true);
                        creature.setVisibility(View.GONE);

                        creatureSecond.setVisibility(View.VISIBLE);

                    }
                    return true;
                }
                return false;
            }
        });
    }


    void clickStar() {

        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                password.setVisibility(View.VISIBLE);
                password.requestFocus();
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.showSoftInput(password, InputMethodManager.SHOW_IMPLICIT);
            }
        });
    }

    void clickTask() {
        creatureSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimating) {
                    text2.setText("");
                    counterTask++;
                    int index = counterTask % textArrayTask.length;
                    animateText3(textArrayTask[index], 10);
                    if (counterTask >= 3) {
                        text3.setText("");
                        task.setVisibility(View.VISIBLE);
                        QuestionAnswerCheck();
                        creatureSecond.setEnabled(false);
                    }
                }
            }
        });
    }

    void QuestionAnswerCheck(){
        task.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (!isAnimating && actionId == EditorInfo.IME_ACTION_DONE) {
                    String enteredTask = task.getText().toString();
                    if(!TextUtils.equals(enteredTask,answer)){
                        isAnimating = false;
                        animateText3("ТЫ ЧЁ? ТЫ БЛЯТЬ НЕ МОЖЕШЬ СЛОЖИТЬ 2+2?. МИША ВСЁ ХУЙНЯ ДАВАЙ ПО НОВОЙ", 10);


                    }
                    else {
                        isAnimating = false;
                        task.setVisibility(View.GONE);
                        animateText3("Молодец ты взломал пентагон но не мысли \"ВЫШЕГО СУЩЕСТВА\"", 10);
                        creatureSecond.setVisibility(View.GONE);
                        creatureSecond.setEnabled(true);
                        creatureThird.setVisibility(View.VISIBLE );
                    }

                    return true;
                } return false;
            }
        });
    }

    void QuestionInChinese() {
        creatureThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimating) {
                    text3.setText("");
                    counterInChinese++;
                    int index = counterInChinese % textArrayInChinese.length;
                    animateText4(textArrayInChinese[index], 10);
                    if (counterInChinese >= 2) {
                        сhineseQuestion.setVisibility(View.VISIBLE);
                        text4.setText("НАХУЯ ТУТ НА КИТАЙСКОМ НАПИСАНО?");
                    }
                }
            }
        });
    }

    void chineseTask(){
        сhineseQuestion.setOnEditorActionListener(new TextView.OnEditorActionListener() {


            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(!isAnimating && actionId == EditorInfo.IME_ACTION_DONE){
                    String enteredTask = task.getText().toString();
                    if(!TextUtils.equals(enteredTask,answer)){
                        isAnimating = false;
                        animateText4("ПРОБУЙ ЕЩЁ!",10);
                    }
                    else {
                        сhineseQuestion.setVisibility(View.GONE);
                        isAnimating = false;
                        animateText4("ХОРОШ!",10);


                    }
                    return true;
                }  return false;

            }

        });
    }



    void animateText2(String text, int delay) {
        isAnimating = true; // set the flag to indicate that the animation is running
        index = 0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                text2.setText(text.substring(0, index++));
                if (index <= text.length()) {
                    handler.postDelayed(this, delay); // delay in milliseconds between characters
                } else {
                    isAnimating = false; // reset the flag when the animation is done
                }
            }
        };
        handler.postDelayed(runnable, delay); // delay before starting the animation
    }




    void animateText3(String text, int delay) {
        isAnimating = true; // set the flag to indicate that the animation is running
        index = 0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                text3.setText(text.substring(0, index++));
                if (index <= text.length()) {
                    handler.postDelayed(this, delay); // delay in milliseconds between characters
                } else {
                    isAnimating = false; // reset the flag when the animation is done
                }
            }
        };
        handler.postDelayed(runnable, delay); // delay before starting the animation
    }



    void animateText4(String text, int delay) {
        isAnimating = true; // set the flag to indicate that the animation is running
        index = 0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                text4.setText(text.substring(0, index++));
                if (index <= text.length()) {
                    handler.postDelayed(this, delay); // delay in milliseconds between characters
                } else {
                    isAnimating = false; // reset the flag when the animation is done
                }
            }
        };
        handler.postDelayed(runnable, delay); // delay before starting the animation
    }


    public void showToast() {
        Toast.makeText(this, "НАЖМИ НА ЧЕЛОВЕЧКА ЧТОБЫ НАЧАТЬ", Toast.LENGTH_LONG).show();
    }
}



