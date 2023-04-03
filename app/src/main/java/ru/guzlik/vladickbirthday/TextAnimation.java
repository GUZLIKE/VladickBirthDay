package ru.guzlik.vladickbirthday;

import android.os.Handler;
import android.widget.TextView;


public class TextAnimation {


   static public boolean isAnimating = false;
   static private int index;


   public static void animateText(TextView textView, String text, int delay) {
        isAnimating = true; // set the flag to indicate that the animation is running
        index = 0;
        Handler handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                textView.setText(text.substring(0, index++));
                if (index <= text.length()) {
                    handler.postDelayed(this, delay); // delay in milliseconds between characters
                } else {
                    isAnimating = false; // reset the flag when the animation is done
                }
            }
        };
        handler.postDelayed(runnable, delay); // delay before starting the animation
    }

}

