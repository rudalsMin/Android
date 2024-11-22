package com.example.activ10_2;
import androidx.appcompat.app.AppCompatActivity;
// AppCompatActivity를 가져옴. 액티비티를 생성하고 관리하기 위한 기본 클래스.

import android.content.Intent;
// Intent 클래스를 가져옴. 액티비티 간 데이터 전달 및 전환을 위해 사용.

import android.os.Bundle;
// 액티비티의 상태 저장 및 복원을 위한 Bundle 클래스 가져오기.

import android.view.View;
// 뷰와 관련된 동작을 처리하기 위한 View 클래스 가져오기.

import android.widget.Button;
// 버튼 UI 컴포넌트를 사용하기 위한 Button 클래스 가져오기.

import android.widget.RatingBar;
// 별점 평가 UI 컴포넌트를 사용하기 위한 RatingBar 클래스 가져오기.

import android.widget.TextView;
// 텍스트를 표시하기 위한 TextView 클래스 가져오기.

public class ResultActivity extends AppCompatActivity {
// ResultActivity 클래스 선언. AppCompatActivity를 상속받음.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 액티비티 생성 시 호출되는 메서드. 초기화 작업 수행.

        super.onCreate(savedInstanceState);
        // 부모 클래스의 onCreate 메서드 호출.

        setContentView(R.layout.result);
        // 액티비티 레이아웃을 result.xml로 설정.

        setTitle("투표 결과");
        // 액티비티의 제목을 "투표 결과"로 설정.

        Intent intent = getIntent();
        // 이전 액티비티에서 전달된 데이터를 받기 위한 Intent 객체 생성.

        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        // 투표 결과 배열 데이터를 Intent에서 가져옴.

        String[] imageName = intent.getStringArrayExtra("ImageName");
        // 명화 이름 배열 데이터를 Intent에서 가져옴.

        TextView tv[] = new TextView[imageName.length];
        // TextView 객체를 저장할 배열 선언. 명화 이름 수만큼 생성.

        RatingBar rbar[] = new RatingBar[imageName.length];
        // RatingBar 객체를 저장할 배열 선언. 명화 이름 수만큼 생성.

        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9 };
        // TextView ID를 저장한 배열. result.xml에 정의된 ID 사용.

        Integer rbarID[] = { R.id.rbar1, R.id.rbar2, R.id.rbar3, R.id.rbar4,
                R.id.rbar5, R.id.rbar6, R.id.rbar7, R.id.rbar8, R.id.rbar9 };
        // RatingBar ID를 저장한 배열. result.xml에 정의된 ID 사용.

        for (int i = 0; i < voteResult.length; i++) {
            // 투표 결과 배열 크기만큼 반복.

            tv[i] = (TextView) findViewById(tvID[i]);
            // TextView ID를 이용해 객체를 가져와 배열에 저장.

            rbar[i] = (RatingBar) findViewById(rbarID[i]);
            // RatingBar ID를 이용해 객체를 가져와 배열에 저장.
        }

        for (int i = 0; i < voteResult.length; i++) {
            // 투표 결과 배열 크기만큼 반복.

            tv[i].setText(imageName[i]);
            // 해당 TextView에 명화 이름 설정.

            rbar[i].setRating((float) voteResult[i]);
            // 해당 RatingBar에 투표 수를 설정. 정수 값을 실수(float)로 변환.
        }

        Button btnReturn = (Button) findViewById(R.id.btnReturn);
        // 반환 버튼 객체를 ID를 통해 가져옴.

        btnReturn.setOnClickListener(new View.OnClickListener() {
            // 반환 버튼에 클릭 이벤트 리스너 설정.

            public void onClick(View v) {
                // 버튼이 클릭되었을 때 호출되는 메서드.

                finish();
                // 현재 액티비티 종료. 이전 액티비티로 돌아감.
            }
        });

    }
}
