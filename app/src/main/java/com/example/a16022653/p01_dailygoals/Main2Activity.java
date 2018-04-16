package com.example.a16022653.p01_dailygoals;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent i = getIntent();
        String[] info = i.getStringArrayExtra("info");
        TextView tv1 = (TextView)findViewById(R.id.textView8);
        tv1.setText("Read up on materials before class: "+info[0]+"\n Arrive on time so as not to miss important part of the lesson: "+info[1] + "\n Attempt the problem myself:" +info[2]+"\n Reflection: "+info[3]);

        Button closeButton = (Button) findViewById(R.id.button2);
        closeButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
