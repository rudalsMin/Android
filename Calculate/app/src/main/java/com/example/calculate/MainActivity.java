package com.example.calculate;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edit1, edit2;
    Button btnNewActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        edit1 = findViewById(R.id.Edit1);
        edit2 = findViewById(R.id.Edit2);
        btnNewActivity = findViewById(R.id.btnCalculate);

        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String num1 = edit1.getText().toString();
                String num2 = edit2.getText().toString();

                // 입력값 확인
                if (num1.isEmpty() || num2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 데이터 전달
                Intent intent = new Intent(MainActivity.this, CalculateActivity.class);
                intent.putExtra("num1", num1);
                intent.putExtra("num2", num2);
                startActivity(intent);
            }
        });
    }
}
