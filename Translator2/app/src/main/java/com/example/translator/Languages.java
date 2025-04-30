package com.example.translator;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

public class Languages extends AppCompatActivity {

    private ListView list;
    private ArrayAdapter<String> aAdapter;
    String[] language = {"Japanese", "Chinese", "Italian", "German", "French"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_languages);


        list = findViewById(R.id.languages);
        if (list == null) {
            Log.e("Languages", "ListView is null!");
        }

        aAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, language);
        list.setAdapter(aAdapter); // << This is MUST

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String clickedItem = (String) list.getItemAtPosition(position);
                Intent in = new Intent(Languages.this, HomeScreen.class);
                in.putExtra("selectedLanguage", clickedItem);
                startActivity(in);
            }
        });
    }
}
