package com.example.captchagenerator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class generator extends AppCompatActivity {
    Button btn, updateBtn;
    TextView res;
    EditText value;
    ImageView captcha, captcha2, captcha3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generator);

        btn = findViewById(R.id.checkBtn);
        updateBtn = findViewById(R.id.updateBtn);
        res = findViewById(R.id.res);
        captcha = findViewById(R.id.captcha);
        captcha2 = findViewById(R.id.captcha2);
        captcha3 = findViewById(R.id.captcha3);
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
        final textCaptcha[] captchaObj = {new textCaptcha(height, width, 6)};
        captcha.setImageBitmap(captchaObj[0].image1);
        captcha2.setImageBitmap(captchaObj[0].image2);
        captcha3.setImageBitmap(captchaObj[0].image3);

        res.setText(captchaObj[0].ans);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = value.getText().toString();
                if(text.equals(captchaObj[0].ans)) {
//                    res.setText("Correct!!!");
                    Toast.makeText(generator.this, "Correct", Toast.LENGTH_SHORT).show();
                }
                else {
//                    res.setText("Incorrect!!!");
                    Toast.makeText(generator.this, "Incorrect", Toast.LENGTH_SHORT).show();
                }

            }
        });

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captchaObj[0] = new textCaptcha(height, width, 6);
                captcha.setImageBitmap(captchaObj[0].image1);
                captcha2.setImageBitmap(captchaObj[0].image2);
                captcha3.setImageBitmap(captchaObj[0].image3);
                value.getText().clear();
                res.setText(captchaObj[0].ans);

            }
        });

    }
}