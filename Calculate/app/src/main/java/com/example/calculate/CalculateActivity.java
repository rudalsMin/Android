package com.example.calculate;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class CalculateActivity extends Activity {

    String num1, num2;
    Integer result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculate);
        setTitle("계산기");

        // MainActivity로부터 값 가져오기
        num1 = getIntent().getStringExtra("num1");
        num2 = getIntent().getStringExtra("num2");

        Button btnAdd = findViewById(R.id.BtnAdd);
        Button btnSub = findViewById(R.id.BtnSub);
        Button btnMul = findViewById(R.id.BtnMul);
        Button btnDiv = findViewById(R.id.BtnDiv);
        Button btnReturn = findViewById(R.id.btnReturn); // btnReturn 버튼

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndShowResult("+");
            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndShowResult("-");
            }
        });

        btnMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndShowResult("*");
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAndShowResult("/");
            }
        });

        // btnReturn 클릭 시 MainActivity 새로 시작
        btnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CalculateActivity.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP); // 기존 액티비티 스택 제거
                startActivity(intent);
            }
        });
    }

    private void calculateAndShowResult(String operator) {
        try {
            int n1 = Integer.parseInt(num1);
            int n2 = Integer.parseInt(num2);

            switch (operator) {
                case "+":
                    result = n1 + n2;
                    break;
                case "-":
                    result = n1 - n2;
                    break;
                case "*":
                    result = n1 * n2;
                    break;
                case "/":
                    if (n2 == 0) {
                        Toast.makeText(this, "0으로 나눌 수 없습니다.", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    result = n1 / n2;
                    break;
            }

            Toast.makeText(this, "결과: " + result, Toast.LENGTH_SHORT).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "올바른 숫자를 입력하세요.", Toast.LENGTH_SHORT).show();
        }
    }
}
