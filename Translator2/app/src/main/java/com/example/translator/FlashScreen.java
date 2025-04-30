package com.example.translator;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

public class FlashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen);

        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(FlashScreen.this,Languages.class);
                startActivity(in);
                finish();
            }
        },1000);

        WindowInsetsControllerCompat con = new WindowInsetsControllerCompat(getWindow(), getWindow().getDecorView());
        con.hide(WindowInsetsCompat.Type.statusBars());
    }
}