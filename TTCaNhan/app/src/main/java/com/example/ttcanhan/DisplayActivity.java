package com.example.ttcanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        TextView textView_name = findViewById(R.id.textView_name);
        textView_name.setText(bundle.getString("hoten"));

        TextView textView_phone = findViewById(R.id.textView_phone);
        textView_phone.setText(bundle.getString("phone"));

        TextView textView_sex = findViewById(R.id.textView_sex);
        textView_sex.setText(bundle.getString("gioitinh"));

        TextView textView_trinhdo = findViewById(R.id.textView_trinhdo);
        textView_trinhdo.setText(bundle.getString("trinhdo"));

        TextView textView_tuoi = findViewById(R.id.textView_tuoi);
        textView_tuoi.setText(bundle.getString("tuoi"));

        TextView textView_thethao = findViewById(R.id.textView_thethao);
        textView_thethao.setText(bundle.getString("thethao"));

        TextView textView_amnhac = findViewById(R.id.textView_amnhac);
        textView_amnhac.setText(bundle.getString("amnhac"));

        Button button_return = findViewById(R.id.button_return);
        button_return.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}