package com.example.chap10;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, //Intent가 있어야지 페이지 이동 가능 / MainActivity -> .this
                        SecondActivity.class); //SecondActivity -> .class
                startActivity(intent);
            }
        });
    }

}