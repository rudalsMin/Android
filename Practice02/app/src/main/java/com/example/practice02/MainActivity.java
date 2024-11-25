package com.example.practice02;

import androidx.appcompat.app.AppCompatActivity;  // AppCompatActivity를 사용하여 액티비티를 작성할 수 있도록 임포트

import android.app.Activity;  // 기본 Activity 클래스 임포트
import android.content.Intent;  // 다른 액티비티로 이동할 수 있는 Intent 클래스 임포트
import android.os.Bundle;  // 액티비티의 상태를 저장하는 Bundle 클래스 임포트
import android.view.View;  // 뷰 클릭 이벤트를 처리하기 위한 View 클래스 임포트
import android.widget.Button;  // 버튼을 사용하기 위한 Button 클래스 임포트
import android.widget.RadioButton;  // 라디오 버튼을 사용하기 위한 RadioButton 클래스 임포트
import android.widget.Toast;  // 사용자에게 메시지를 띄우기 위한 Toast 클래스 임포트

public class MainActivity extends Activity {  // MainActivity 클래스 정의, Activity를 상속받음

    @Override
    protected void onCreate(Bundle savedInstanceState) {  // 액티비티가 생성될 때 호출되는 메서드
        super.onCreate(savedInstanceState);  // 부모 클래스의 onCreate 메서드 호출
        setContentView(R.layout.activity_main);  // 액티비티의 레이아웃을 activity_main으로 설정
        setTitle("직접 풀어보기 10-1");  // 액티비티의 제목 설정

        final RadioButton rdoSecond = (RadioButton) findViewById(R.id.rdoSecond);  // rdoSecond 라디오 버튼을 찾고 참조
        final RadioButton rdoThird = (RadioButton) findViewById(R.id.rdoThird);  // rdoThird 라디오 버튼을 찾고 참조

        Button btnNew = (Button) findViewById(R.id.btnNew);  // btnNew 버튼을 찾고 참조
        btnNew.setOnClickListener(new View.OnClickListener() {  // btnNew 버튼에 클릭 리스너 설정
            @Override
            public void onClick(View view) {  // 버튼 클릭 시 호출되는 메서드
                Intent intent;  // 액티비티 전환을 위한 Intent 객체 선언

                // rdoSecond가 체크되었을 경우
                if (rdoSecond.isChecked()) {  // rdoSecond가 체크되었는지 확인
                    // Toast 메시지 출력
                    Toast.makeText(MainActivity.this, "Second Activity", Toast.LENGTH_SHORT).show();  // 사용자에게 메시지 출력
                    intent = new Intent(getApplicationContext(), SecondActivity.class);  // SecondActivity로 이동할 Intent 생성
                }
                // rdoThird가 체크되었을 경우
                else {  // rdoSecond가 체크되지 않으면
                    // Toast 메시지 출력
                    Toast.makeText(MainActivity.this, "Third Activity", Toast.LENGTH_SHORT).show();  // 사용자에게 메시지 출력
                    intent = new Intent(getApplicationContext(), ThirdActivity.class);  // ThirdActivity로 이동할 Intent 생성
                }

                startActivity(intent);  // 생성된 intent를 사용하여 새로운 액티비티 시작
            }
        });
    }
}
