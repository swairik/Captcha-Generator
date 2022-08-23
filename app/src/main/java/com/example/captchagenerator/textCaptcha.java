package com.example.captchagenerator;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;

import java.util.Random;

public class textCaptcha {
    Bitmap image1, image2, image3;
    String ans = "";
    int width;
    int height;

    //    static List usedColors;

    public static int getRandomColor(){
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

    //    wrapper constructor
    textCaptcha(int wordLength) {
        new textCaptcha(300, 300, wordLength);
    }

    textCaptcha(int height, int width, int wordLength) {
        image1 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        image2 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        image3 = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);

        Canvas canvas = new Canvas(image1);
        Canvas canvas2 = new Canvas(image2);
        Canvas canvas3 = new Canvas(image3);

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

        Random random = new Random(System.currentTimeMillis());

        Paint p = new Paint();
        p.setColor(Color.WHITE);
        canvas.drawRect(0, 0, width, height, p);

        //        p.setColor(Color.BLACK);
        int numLines = 4 + (Math.abs(random.nextInt())) % 8;
        for(int i = 0; i < numLines; i++) {
//            p.setColor(getRandomColor());
            p.setColor(Color.BLACK);
            int startX = Math.abs(random.nextInt(width));
            int startY = Math.abs(random.nextInt(height));
            int stopX = Math.abs(random.nextInt(width));
            int stopY = Math.abs(random.nextInt(height));
            canvas.drawLine(startX, startY, stopX, stopY, p);
//            canvas.drawLine(0, 0, 100, 100, p);
        }

        Paint p2 = new Paint();
        LinearGradient gradient = new LinearGradient(0, 0, width / wordLength, height / 2, getRandomColor(), getRandomColor(), Shader.TileMode.MIRROR);
        p2.setShader(gradient);
        canvas2.drawRect(0, 0, width, height, p2);

        Paint p3 = new Paint();
        LinearGradient gradient2 = new LinearGradient(0, 0, width / wordLength, height / 2, getRandomColor(), getRandomColor(), Shader.TileMode.REPEAT);
        p3.setShader(gradient2);
        canvas3.drawRect(0, 0, width, height, p3);

        Paint paint = new Paint();
        paint.setTextSize(60);

        int x = 0, y = 0;
        for(char ch : ans.toCharArray()) {
//            x += (30 - (3 * wordLength)) + (Math.abs(random.nextInt()) % (65 - (1.2 * wordLength)));
//            need to restrict the spacing
            x += (wordLength * 2) + (Math.abs(random.nextInt()) % (60 - (2 * wordLength)));
            y = 50 + Math.abs(random.nextInt()) % 100;
            Canvas cc = new Canvas(image1);
            Canvas cc2 = new Canvas(image2);
            Canvas cc3 = new Canvas(image3);
            paint.setTextSkewX(random.nextFloat() - random.nextFloat());
            paint.setColor(getRandomColor());
            cc.drawText(String.valueOf(ch), x, y, paint);
            cc2.drawText(String.valueOf(ch), x, y, paint);
            cc3.drawText(String.valueOf(ch), x, y, paint);
        }
    }

}
