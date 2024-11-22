package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;

import android.widget.Button;

import android.widget.EditText;

import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edit1;
    Button btnAdd;
    TextView textView;

    int taskNumber = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit1 = findViewById(R.id.Edit1);
        btnAdd = findViewById(R.id.BtnAdd);
        textView = findViewById(R.id.TextResult);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputText = edit1.getText().toString();

                if (!inputText.isEmpty()){
                    textView.append(taskNumber + ". " + inputText + "\n");

                    taskNumber++;

                    edit1.setText("");
                }
            }
        });

    }
}