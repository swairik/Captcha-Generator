package com.example.captchagenerator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;

import java.util.*;
import java.util.Random;

public class textCaptcha {
    Bitmap image;
    String ans = "";
    int width;
    int height;

    //    wrapper constructor
    textCaptcha(int wordLength) {
        new textCaptcha(300, 300, wordLength);
    }

    textCaptcha(int height, int width, int wordLength) {
        image = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(image);

//        Paint paint = new Paint();
//        paint.setColor(Color.BLACK);
//        paint.setTextSize(60);
//        float text_x = 50;
//        float text_y = 50;
//        canvas.drawText("Hello11111111111111111111111111111111111111111111111111111111111111", text_x, text_y, paint);

        StringBuilder temp = new StringBuilder();
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz";
        for(int i = 0; i < wordLength; i++) {
            int index = (int)(AlphaNumericString.length() * Math.random());
            temp.append(AlphaNumericString.charAt(index));
        }
        ans = String.valueOf(temp);
//        canvas.drawColor(Color.YELLOW);
//        canvas.drawText(String.valueOf(ans), text_x, text_y, paint);

        Random r = new Random(System.currentTimeMillis());

        Paint p = new Paint();
        LinearGradient gradient = new LinearGradient(0, 0, width / wordLength, height / 2, color(), color(), Shader.TileMode.MIRROR);
        p.setShader(gradient);

        canvas.drawRect(0, 0, width, height, p);

        Paint paint = new Paint();
        paint.setTextSize(60);
//        paint.setTextSize(width / height * 20);

        char[] data = ans.toCharArray();
        int x = 0, y = 0;
        for (int i = 0; i < data.length; i++) {
            x += (30 - (3 * wordLength)) + (Math.abs(r.nextInt()) % (65 - (1.2 * wordLength)));
            y = 50 + Math.abs(r.nextInt()) % 50;
            Canvas cc = new Canvas(image);
            paint.setTextSkewX(r.nextFloat() - r.nextFloat());
            paint.setColor(color());
            cc.drawText(data, i, 1, x, y, paint);
            paint.setTextSkewX(0);
        }

    }

//    static List usedColors;

    public static int color(){
        Random r = new Random();
        int number;
//        do{
//            number = r.nextInt(9);
//        }while(usedColors.contains(number));
//        usedColors.add(number);
        number = r.nextInt(9);
        switch(number){
            case 0: return Color.BLACK;
            case 1: return Color.BLUE;
            case 2: return Color.CYAN;
            case 3: return Color.DKGRAY;
            case 4: return Color.GRAY;
            case 5: return Color.GREEN;
            case 6: return Color.MAGENTA;
            case 7: return Color.RED;
            case 8: return Color.YELLOW;
            case 9: return Color.WHITE;
            default: return Color.WHITE;
        }
    }

}
