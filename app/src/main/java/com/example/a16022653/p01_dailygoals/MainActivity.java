package com.example.a16022653.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnDone = (Button) findViewById(R.id.button);
        btnDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                RadioGroup rg = (RadioGroup)findViewById(R.id.rg1);
                int selectedButtonId = rg.getCheckedRadioButtonId();
                RadioButton rb = (RadioButton)findViewById(selectedButtonId);
                RadioGroup rg1 = (RadioGroup)findViewById(R.id.rg2);
                int selectedButtonId1 = rg1.getCheckedRadioButtonId();
                RadioButton rb1 = (RadioButton)findViewById(selectedButtonId1);
                RadioGroup rg2 = (RadioGroup)findViewById(R.id.rg3);
                int selectedButtonId2 = rg2.getCheckedRadioButtonId();
                RadioButton rb2 = (RadioButton)findViewById(selectedButtonId2);
                EditText etName = (EditText) findViewById(R.id.editText);
                String[] info = {rb.getText().toString(), rb1.getText().toString(),rb2.getText().toString(), etName.getText().toString()};
                Intent i = new Intent(MainActivity.this, Main2Activity.class);
                i.putExtra("info", info);
                startActivity(i);
            }
        });
    }
    @Override
    protected void onPause(){
        super.onPause();
        EditText etName = (EditText) findViewById(R.id.editText);
        String strName = etName.getText().toString();

        RadioGroup rg = (RadioGroup)findViewById(R.id.rg1);
        int selectedButtonId = rg.getCheckedRadioButtonId();
        RadioButton rb = (RadioButton)findViewById(selectedButtonId);
        String strint = rb.getText().toString();

        RadioGroup rg1 = (RadioGroup)findViewById(R.id.rg2);
        int selectedButtonId1 = rg1.getCheckedRadioButtonId();
        RadioButton rb1 = (RadioButton)findViewById(selectedButtonId1);
        String strint1 = rb1.getText().toString();

        RadioGroup rg2 = (RadioGroup)findViewById(R.id.rg3);
        int selectedButtonId2 = rg2.getCheckedRadioButtonId();
        RadioButton rb2 = (RadioButton)findViewById(selectedButtonId2);
        String strint2 = rb2.getText().toString();

        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor prefEdit = pref.edit();
        SharedPreferences.Editor prefEdit1 = pref.edit();
        SharedPreferences.Editor prefEdit2 = pref.edit();
        SharedPreferences.Editor prefEdit3 = pref.edit();
        prefEdit.putString("name",strName);
        prefEdit1.putString("rg1",strint);
        prefEdit2.putString("rg2",strint1);
        prefEdit3.putString("rg3",strint2);
        prefEdit.commit();
        prefEdit1.commit();
        prefEdit2.commit();
        prefEdit3.commit();
    }
    @Override
    protected void onResume(){
        super.onResume();
        EditText etName = (EditText) findViewById(R.id.editText);
        SharedPreferences pref = PreferenceManager.getDefaultSharedPreferences(this) ;
        String strName = pref.getString("name","");
        etName.setText(strName);
    }
}
