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

public class FifthActivity extends AppCompatActivity {

    TextView text1,text2 ,textIvan, textlove , text3,text4;

    ImageView creature,creature2,ivan ,petyx,spirt ,creature3,creature4,love;

    Button answer1, answer2, answer3, answer4 , answer11, answer22, answer33, answer44, answer111, answer222, answer333, answer444;

    MediaPlayer boom,bury;

    private int counter = -1;
    private int counter2 = -1;
    private int counter3 = -1;
    private int counter4 = -1;

    private String[] textArray = {"\nВот и почти конец...", "\nУ нас 2 из 3 фрагмента",
            "\n\nОстался последний получить", "ЕБАТЬ ЧТО ЭТО?",""};

    private String[] textArray2 = {"\nОтлично!", "\nПродолжай в том же духе",
            "\n\nОн что то опять готовит", "ОПЯТЬ?!?!",""};

    private String[] textArray3 = {"\nОстался последний вопрос", "\nДаже представить не могу что там может быть",
            "\n\nЯ ВЕРЮ В ТЕБЯ", "ВОТ ОН!",""};

    private String[] textArray4 = {"\nОТЛИЧНО", "\nМЫ ЕГО ПОБЕДИЛИ",
            "\n\nМЫ СОБРАЛИ ВСЕ 3 ФРАГМЕНТА", "Отправлсяемся к 'Вышему существу'",""};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setContentView(R.layout.fifth_activity);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        creature = (ImageView) findViewById(R.id.debil1);
        creature2 = (ImageView) findViewById(R.id.debil2);
        creature3 = (ImageView) findViewById(R.id.debil3);
        creature4 = (ImageView) findViewById(R.id.debil4);
        spirt = (ImageView) findViewById(R.id.spirt);
        love=(ImageView) findViewById(R.id.love);
        text1 = (TextView) findViewById(R.id.text1);
        text2 = (TextView) findViewById(R.id.text2);
        text3 = (TextView) findViewById(R.id.text3);
        text4 = (TextView) findViewById(R.id.text4);
        textlove = (TextView) findViewById(R.id.textlove);
        textIvan = (TextView) findViewById(R.id.textIvan);
        ivan = (ImageView) findViewById(R.id.ivan);
        petyx = (ImageView) findViewById(R.id.petyx);
        boom = (MediaPlayer) MediaPlayer.create(FifthActivity.this, R.raw.boom);
        bury = (MediaPlayer) MediaPlayer.create(FifthActivity.this, R.raw.bury);
        boom.setVolume(10,10);
        bury.setVolume(10,10);

        answer1 = (Button) findViewById(R.id.Answer1);
        answer2 = (Button) findViewById(R.id.Answer2);
        answer3 = (Button) findViewById(R.id.Answer3);
        answer4 = (Button) findViewById(R.id.Answer4);
        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);

        answer11 = (Button) findViewById(R.id.Answer11);
        answer22 = (Button) findViewById(R.id.Answer22);
        answer33 = (Button) findViewById(R.id.Answer33);
        answer44 = (Button) findViewById(R.id.Answer44);
        answer11.setEnabled(false);
        answer22.setEnabled(false);
        answer33.setEnabled(false);
        answer44.setEnabled(false);


        answer111 = (Button) findViewById(R.id.Answer111);
        answer222 = (Button) findViewById(R.id.Answer222);
        answer333 = (Button) findViewById(R.id.Answer333);
        answer444 = (Button) findViewById(R.id.Answer444);
        answer111.setEnabled(false);
        answer222.setEnabled(false);
        answer333.setEnabled(false);
        answer444.setEnabled(false);

        ivan.setVisibility(View.GONE);
        petyx.setVisibility(View.GONE);
        answer1.setVisibility(View.GONE);
        answer2.setVisibility(View.GONE);
        answer3.setVisibility(View.GONE);
        answer4.setVisibility(View.GONE);
        spirt.setVisibility(View.GONE);
        love.setVisibility(View.GONE);
        textlove.setVisibility(View.GONE);


        answer11.setVisibility(View.GONE);
        answer22.setVisibility(View.GONE);
        answer33.setVisibility(View.GONE);
        answer44.setVisibility(View.GONE);

        answer111.setVisibility(View.GONE);
        answer222.setVisibility(View.GONE);
        answer333.setVisibility(View.GONE);
        answer444.setVisibility(View.GONE);
        clickCreature();




    }

    void clickAnswers() {
        answer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("ПРОЕБАЛИ -1 ЖИЗНЬ!");
                creature.setEnabled(false);
            }
        });


        answer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("БЛЯЯЯЯЯ -1 ЖИЗНЬ!");
                creature.setEnabled(false);
            }
        });

        answer3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();

                text2.setText("ХОРОШ!");
                creature.setEnabled(true);
                text1.setVisibility(View.GONE);

                creature.setVisibility(View.GONE);

                petyx.setVisibility(View.GONE);
                answer1.setVisibility(View.GONE);
                answer2.setVisibility(View.GONE);
                answer3.setVisibility(View.GONE);
                answer4.setVisibility(View.GONE);
                clickCreature2();
            }
        });

        answer4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text1.setText("ПИЗДА -1 ЖИЗНЬ!!!");
                creature.setEnabled(false);
//                clickCreature2();
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
                if (counter >= 3) {

                    text1.setText("");

                    ivan.setVisibility(View.VISIBLE);
                    bury.start();
                    boom.start();
                    textIvan.setText("ХА ХА ХА ТЕБЕ НЕ ПОЛУЧИТЬ ПОСЛЕДНИЙ ФРАГМЕНТ!");
                    if(counter>=4){
                        text1.setText("У тебя 3 жизни если проебёшься гг вп тебе!");
                        if(counter>=5) {
                            textIvan.setText("");

                            petyx.setVisibility(View.VISIBLE);
                            clickAnswers();
                            answer1.setVisibility(View.VISIBLE);
                            answer2.setVisibility(View.VISIBLE);
                            answer3.setVisibility(View.VISIBLE);
                            answer4.setVisibility(View.VISIBLE);
                            creature.setEnabled(false);

                            answer1.setEnabled(true);
                            answer2.setEnabled(true);
                            answer3.setEnabled(true);
                            answer4.setEnabled(true);

                        }

                    }
                }
            }
        });
    }

    void clickAnswers2() {
        answer11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                text3.setText("Истинный алкаш!");

                creature2.setEnabled(true);
                textIvan.setText("");

                creature2.setVisibility(View.GONE);
                text2.setVisibility(View.GONE);
                spirt.setVisibility(View.GONE);
                answer11.setVisibility(View.GONE);
                answer22.setVisibility(View.GONE);
                answer33.setVisibility(View.GONE);
                answer44.setVisibility(View.GONE);
                creature3.setVisibility(View.VISIBLE);
                clickCreature3();

            }
        });


        answer22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setText("БЛЯЯЯЯЯ -1 ЖИЗНЬ!");
                creature2.setEnabled(false);
            }
        });

        answer33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setText("ТЫ ЧТО НЕ ИГРАЛ?!!");
                creature2.setEnabled(false);
            }
        });

        answer44.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                text2.setText("ПИЗДА -1 ЖИЗНЬ!!!");
                creature2.setEnabled(false);
            }
        });



    }

    void clickCreature2() {
        creature2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter2++;
                int index = counter2 % textArray2.length;
                text2.setText(textArray2[index]);
                if (counter2 >= 4) {

                    text2.setText("");
                    boom.start();
                    textIvan.setText("ПОПРОБУЙ ОТГАДАТЬ ЭТО!");
                    if(counter2>=5){
                        text2.setText("Будь внимательным!");
                        if(counter2>=6) {
                            boom.start();

                            spirt.setVisibility(View.VISIBLE);
                            answer11.setVisibility(View.VISIBLE);
                            answer22.setVisibility(View.VISIBLE);
                            answer33.setVisibility(View.VISIBLE);
                            answer44.setVisibility(View.VISIBLE);
                            creature2.setEnabled(false);

                            answer11.setEnabled(true);
                            answer22.setEnabled(true);
                            answer33.setEnabled(true);
                            answer44.setEnabled(true);
                            clickAnswers2();


                        }

                    }
                }
            }
        });
    }

    void clickAnswers3() {
        answer111.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                creature3.setVisibility(View.GONE);
                creature3.setEnabled(true);
                text4.setText("ТАК И ЗНАЛ");
                love.setVisibility(View.GONE);
                textlove.setVisibility(View.GONE);
                answer111.setVisibility(View.GONE);
                answer222.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                answer333.setVisibility(View.GONE);
                answer444.setVisibility(View.GONE);
                lastClick();

            }
        });


        answer222.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                creature3.setVisibility(View.GONE);
                creature3.setEnabled(true);
                text4.setText("ТАК И ЗНАЛ!");
                love.setVisibility(View.GONE);
                textlove.setVisibility(View.GONE);
                answer111.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);;
                answer222.setVisibility(View.GONE);
                answer333.setVisibility(View.GONE);
                answer444.setVisibility(View.GONE);
                lastClick();
            }
        });

        answer333.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                creature3.setVisibility(View.GONE);
                creature3.setEnabled(true);
                text4.setText("ТАК И ЗНАЛ!");
                love.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                textlove.setVisibility(View.GONE);
                answer111.setVisibility(View.GONE);
                answer222.setVisibility(View.GONE);
                answer333.setVisibility(View.GONE);
                answer444.setVisibility(View.GONE);
                lastClick();

            }
        });

        answer444.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boom.start();
                creature3.setVisibility(View.GONE);
                creature3.setEnabled(true);

                text4.setText("ТАК И ЗНАЛ!");
                love.setVisibility(View.GONE);
                text3.setVisibility(View.GONE);
                textlove.setVisibility(View.GONE);
                answer111.setVisibility(View.GONE);
                answer222.setVisibility(View.GONE);
                answer333.setVisibility(View.GONE);
                answer444.setVisibility(View.GONE);
                lastClick();

            }
        });



    }

    void clickCreature3() {
        creature3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter3++;
                int index = counter3 % textArray3.length;
                text3.setText(textArray3[index]);
                if (counter3 >= 4) {

                    text3.setText("");

                    textIvan.setText("ЭТО САМЫЙ СЛОЖНЫЙ ВОПРОС ОТ МЕНЯ");
                    if(counter3>=5){
                        text3.setText("Надо быть НА ЧЕКУ!");
                        if(counter3>=6) {
                            boom.start();
                            love.setVisibility(View.VISIBLE);
                            textlove.setVisibility(View.VISIBLE);
                            answer111.setVisibility(View.VISIBLE);
                            answer222.setVisibility(View.VISIBLE);
                            answer333.setVisibility(View.VISIBLE);
                            answer444.setVisibility(View.VISIBLE);
                            creature3.setEnabled(false);

                            answer111.setEnabled(true);
                            answer222.setEnabled(true);
                            answer333.setEnabled(true);
                            answer444.setEnabled(true);
                            clickAnswers3();

                        }

                    }
                }
            }
        });
    }


    void lastClick(){

      creature4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              textIvan.setText("<--- ТИПА ПОМЕР");
              boom.start();
              counter4++;
              int index = counter4 % textArray4.length;
              text4.setText(textArray4[index]);
              if(counter4>=4){
                  bury.stop();
                  Intent intent = new Intent(FifthActivity.this, SixthLastActivity.class);
                  startActivity(intent);


              }
          }

      });

    }

}
