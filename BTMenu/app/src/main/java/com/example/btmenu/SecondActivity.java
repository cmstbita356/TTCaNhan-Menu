package com.example.btmenu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Intent intent = getIntent();
        if(intent.getStringExtra("optionmenu") != null)
        {
            TextView v = findViewById(R.id.optionmenu);
            String s = intent.getStringExtra("optionmenu");
            v.setText(s);
        }
        if(intent.getStringExtra("contextualmenu") != null)
        {
            TextView v = findViewById(R.id.contextualmenu);
            String s = intent.getStringExtra("contextualmenu");
            v.setText(s);
        }
        if(intent.getStringExtra("popupmenu") != null)
        {
            TextView v = findViewById(R.id.popupmenu);
            String s = intent.getStringExtra("popupmenu");
            v.setText(s);
        }
        Button button_return = findViewById(R.id.button_return);
        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}