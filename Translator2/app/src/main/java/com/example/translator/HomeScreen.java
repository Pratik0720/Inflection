package com.example.translator;

import static android.icu.lang.UCharacter.toLowerCase;
import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class HomeScreen extends AppCompatActivity {

    private TextToSpeech convert;
    private ImageButton btn;
    private EditText msg;
    private ImageView emo;
    String lang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);


        msg = (EditText) findViewById(R.id.message);
        btn = (ImageButton) findViewById(R.id.send_Msg);
        emo = (ImageView) findViewById(R.id.lang_emoji);
        Intent in = getIntent();
        lang = in.getStringExtra("selectedLanguage");
        lang = toLowerCase(lang);
        convert = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {


                if(lang.equals("japanese")) {
                    emo.setImageResource(R.drawable.japanese_emoji_removebg_preview);
                    convert.setLanguage(Locale.JAPAN);
                }
                if(lang.equals("chinese")) {
                    emo.setImageResource(R.drawable.chinese_emoji_removebg_preview);
                    convert.setLanguage(Locale.CHINESE);
                }
                if(lang.equals("italian")) {
                    emo.setImageResource(R.drawable.italian_emoji_removebg_preview);
                    convert.setLanguage(Locale.ITALIAN);
                }
                if(lang.equals("german")) {
                    emo.setImageResource(R.drawable.german_emoji_removebg_preview);
                    convert.setLanguage(Locale.GERMAN);
                }
                if(lang.equals("french")) {
                    emo.setImageResource(R.drawable.canadian_emoji_removebg_preview);
                    convert.setLanguage(Locale.FRENCH);
                }

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String toSpeak = msg.getText().toString();
                convert.speak(toSpeak, TextToSpeech.QUEUE_FLUSH, null);
            }
        });

    }
}