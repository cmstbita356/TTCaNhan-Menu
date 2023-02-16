package com.example.ttcanhan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;

import com.google.android.material.switchmaterial.SwitchMaterial;

public class MainActivity extends AppCompatActivity {
    Bundle bundle = new Bundle();
    Spinner spinner_trinhdo;
    TextView seekBar_currentValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner_trinhdo = findViewById(R.id.spinner_trinhdo);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.list_trinhdo, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_trinhdo.setAdapter(adapter);

        SeekBar seekBar_tuoi = findViewById(R.id.seekBar_Tuoi);
        seekBar_currentValue = findViewById(R.id.seekBar_currentValue);
        seekBar_tuoi.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBar_currentValue.setText(String.valueOf(progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        Button button_submit = findViewById(R.id.button_submit);
        button_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText editText_name = findViewById(R.id.editText_Name);
                bundle.putString("hoten", editText_name.getText().toString());

                EditText editText_phone = findViewById(R.id.editText_PhoneNumber);
                bundle.putString("phone", editText_phone.getText().toString());

                SwitchMaterial switch_sex = findViewById(R.id.switch_Sex);
                if(switch_sex.isChecked()) bundle.putString("gioitinh", "Nam");
                else bundle.putString("gioitinh", "Nữ");

                bundle.putString("trinhdo", spinner_trinhdo.getSelectedItem().toString());

                bundle.putString("tuoi", seekBar_currentValue.getText().toString());

                CheckBox checkBox_thethao = findViewById(R.id.checkbox_thethao);
                if(checkBox_thethao.isChecked()) bundle.putString("thethao", "Có");
                else bundle.putString("thethao", "Không");

                RadioGroup radioGroup_amnhac = findViewById(R.id.radioGroup_amnhac);
                int checkedId = radioGroup_amnhac.getCheckedRadioButtonId();
                if(checkedId == -1){
                    bundle.putString("amnhac", "Không");
                }
                else
                {
                    RadioButton rdb = findViewById(checkedId);
                    bundle.putString("amnhac", rdb.getText().toString());
                }

                Intent intent = new Intent(getApplicationContext(), DisplayActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }
}