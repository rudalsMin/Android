package com.example.activ10_2;

import androidx.appcompat.app.AppCompatActivity;
// AppCompatActivity를 가져옴. 액티비티를 생성하고 관리하기 위한 기본 클래스.

import android.content.Intent;
// 다른 액티비티를 호출하기 위한 Intent 클래스 가져오기.

import android.os.Bundle;
// 액티비티의 상태 저장 및 복원을 위한 Bundle 클래스 가져오기.

import android.view.View;
// 뷰와 관련된 동작을 처리하기 위한 View 클래스 가져오기.

import android.widget.Button;
// 버튼 UI 컴포넌트를 사용하기 위한 Button 클래스 가져오기.

import android.widget.ImageView;
// 이미지뷰 UI 컴포넌트를 사용하기 위한 ImageView 클래스 가져오기.

import android.widget.Toast;
// 간단한 메시지를 화면에 보여주는 Toast 클래스 가져오기.

public class MainActivity extends AppCompatActivity {
// MainActivity 클래스 선언. AppCompatActivity를 상속받음.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // 액티비티 생성 시 호출되는 메서드. 앱의 초기화 작업 수행.

        super.onCreate(savedInstanceState);
        // 부모 클래스의 onCreate 메서드 호출.

        setContentView(R.layout.activity_main);
        // 액티비티 레이아웃을 지정. activity_main 레이아웃 파일 사용.

        setTitle("명화 선호도 투표");
        // 액티비티의 제목 설정.

        final int voteCount[] = new int[9];
        // 9개의 명화에 대한 투표 수를 저장하는 정수 배열 선언.

        for (int i = 0; i < 9; i++)
            voteCount[i] = 0;
        // 투표 수 배열의 모든 값을 0으로 초기화.

        ImageView image[] = new ImageView[9];
        // 9개의 ImageView를 저장할 배열 선언.

        Integer imageId[] = { R.id.iv1, R.id.iv2, R.id.iv3, R.id.iv4, R.id.iv5,
                R.id.iv6, R.id.iv7, R.id.iv8, R.id.iv9 };
        // 레이아웃 파일에서 정의된 9개의 이미지뷰 ID를 저장하는 배열.

        final String imgName[] = { "독서하는 소녀", "꽃장식 모자 소녀", "부채를 든 소녀",
                "이레느깡 단 베르양", "잠자는 소녀", "테라스의 두 자매", "피아노 레슨", "피아노 앞의 소녀들",
                "해변에서" };
        // 각 명화의 이름을 저장하는 문자열 배열.

        for (int i = 0; i < imageId.length; i++){
            // 9개의 이미지뷰 각각에 대해 반복.

            final int index;
            // 익명 클래스에서 사용하기 위해 상수형 변수로 선언.

            index = i;
            // 현재 반복의 인덱스를 index에 할당.

            image[index] = (ImageView) findViewById(imageId[index]);
            // 현재 반복의 이미지뷰 ID를 통해 ImageView 객체를 가져와 배열에 저장.

            image[index].setOnClickListener(new View.OnClickListener() {
                // 현재 이미지뷰에 클릭 이벤트 리스너 설정.

                @Override
                public void onClick(View view) {
                    // 이미지뷰가 클릭되었을 때 호출되는 메서드.

                    voteCount[index]++;
                    // 클릭된 이미지의 투표 수를 1 증가.

                    Toast.makeText(getApplicationContext(),
                            imgName[index] + ": 총 " + voteCount[index] +  " 표",
                            Toast.LENGTH_SHORT).show();
                    // 현재 이미지의 투표 수를 Toast 메시지로 출력.
                }
            });
        }

        Button btnFinish = (Button) findViewById(R.id.btnResult);
        // 결과를 확인할 버튼 객체를 레이아웃 ID를 통해 가져옴.

        btnFinish.setOnClickListener(new View.OnClickListener() {
            // 버튼에 클릭 이벤트 리스너 설정.

            public void onClick(View v) {
                // 버튼이 클릭되었을 때 호출되는 메서드.

                Intent intent = new Intent(getApplicationContext(),
                        ResultActivity.class);
                // ResultActivity를 호출하기 위한 Intent 객체 생성.

                intent.putExtra("VoteCount", voteCount);
                // 투표 수 배열을 Intent에 추가하여 전달.

                intent.putExtra("ImageName", imgName);
                // 명화 이름 배열을 Intent에 추가하여 전달.

                startActivity(intent);
                // Intent를 통해 ResultActivity를 실행.
            }
        });

    }
}