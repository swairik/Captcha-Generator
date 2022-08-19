package com.example.captchagenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class generator extends AppCompatActivity {
    Button btn;
    TextView res;
    EditText value;
    ImageView captcha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        btn = findViewById(R.id.checkBtn);
        res = findViewById(R.id.res);
        captcha = findViewById(R.id.captcha);
        value = findViewById(R.id.value);

        int height = captcha.getDrawable().getIntrinsicHeight();
        int width = captcha.getDrawable().getIntrinsicWidth();

//        res.setText(height + " " + width);
//
//        Bitmap bitmap = Bitmap.createBitmap(270, 210, Bitmap.Config.ARGB_8888);
//
//        Canvas canvas = new Canvas(bitmap);
//        captcha.setImageBitmap(bitmap);
//
//        Paint paint = new Paint();
//        paint.setColor(Color.GREEN);
//        float text_x = 20;
//        float text_y = 20;
//
//        canvas.drawText("Hello", text_x, text_y, paint);

//        textCaptcha captchaObj = new textCaptcha(6);
        textCaptcha captchaObj = new textCaptcha(height, width,6);
        captcha.setImageBitmap(captchaObj.image);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String text = value.getText().toString();
                if(text.equals(captchaObj.ans)) {
                    res.setText("Correct!!!");
                    Toast.makeText(generator.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
                    res.setText("Incorrect!!!");
                    Toast.makeText(generator.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
}