package com.example.practice01;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends SecondActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        Button btnReturn2 = (Button) findViewById(R.id.btnReturn2);
        btnReturn2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                finish();
            }
        });
    }
}
