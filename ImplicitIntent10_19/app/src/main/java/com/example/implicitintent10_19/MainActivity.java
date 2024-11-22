package com.example.implicitintent10_19;

// 패키지 선언. 이 클래스가 속한 패키지 이름을 지정합니다.

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

// 필요한 Android API와 라이브러리를 임포트합니다. 예를 들어, 인텐트와 뷰 요소를 조작하는 데 사용됩니다.

public class MainActivity extends AppCompatActivity {
    // MainActivity 클래스 선언. AppCompatActivity를 상속받아 Android 액티비티의 기능을 구현합니다.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // onCreate() 메서드는 액티비티 생성 시 호출되며 초기화 작업을 수행합니다.

        super.onCreate(savedInstanceState);
        // 부모 클래스의 onCreate()를 호출하여 액티비티 초기화를 처리합니다.

        setContentView(R.layout.activity_main);
        // 레이아웃 XML 파일(activity_main.xml)을 이 액티비티의 UI로 설정합니다.

        setTitle("암시적 인텐트 예제");
        // 액티비티의 제목을 설정합니다.

        // 레이아웃에 정의된 버튼들을 ID로 찾아서 Button 객체로 매핑합니다.
        Button btnDial = (Button) findViewById(R.id.btnDial);
        Button btnWeb = (Button) findViewById(R.id.btnWeb);
        Button btnGoogle = (Button) findViewById(R.id.btnGoogle);
        Button btnSearch = (Button) findViewById(R.id.btnSearch);
        Button btnSms = (Button) findViewById(R.id.btnSms);
        Button btnPhoto = (Button) findViewById(R.id.btnPhoto);

        // 각 버튼에 클릭 이벤트 리스너를 설정합니다.
        btnDial.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // "전화 걸기" 버튼 클릭 시 실행되는 코드
                Uri uri = Uri.parse("tel:010-1234-5678");
                // 전화번호 URI 생성. tel: 스키마를 사용해 전화번호를 지정합니다.
                Intent intent = new Intent(Intent.ACTION_DIAL, uri);
                // ACTION_DIAL 인텐트를 생성하여 다이얼 화면을 엽니다.
                startActivity(intent);
                // 생성한 인텐트를 실행합니다.
            }
        });

        btnWeb.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // "웹 열기" 버튼 클릭 시 실행되는 코드
                Uri uri = Uri.parse("http://m.hanbit.co.kr");
                // 웹 URL을 URI로 생성
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                // ACTION_VIEW 인텐트를 사용하여 해당 웹사이트를 엽니다.
                startActivity(intent);
                // 생성한 인텐트를 실행합니다.
            }
        });

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // "구글 지도" 버튼 클릭 시 실행되는 코드
                Uri uri = Uri.parse("https://maps.google.co.kr/maps?q=" + 37.559133 + "," + 126.927824);
                // 지도 좌표를 포함한 URI 생성
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                // ACTION_VIEW 인텐트를 사용하여 구글 지도에서 해당 위치를 표시합니다.
                startActivity(intent);
                // 생성한 인텐트를 실행합니다.
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // "웹 검색" 버튼 클릭 시 실행되는 코드
                Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
                // ACTION_WEB_SEARCH 인텐트를 생성합니다.
                intent.putExtra(SearchManager.QUERY, "안드로이드");
                // 검색어("안드로이드")를 추가로 전달합니다.
                startActivity(intent);
                // 생성한 인텐트를 실행합니다.
            }
        });

        btnSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // "SMS 보내기" 버튼 클릭 시 실행되는 코드
                Intent intent = new Intent(Intent.ACTION_SENDTO);
                // ACTION_SENDTO 인텐트를 생성하여 메시지 전송 UI를 엽니다.
                intent.putExtra("sms_body", "안녕하세요?");
                // 메시지 내용("안녕하세요?")을 추가합니다.
                intent.setData(Uri.parse("smsto:" + Uri.encode("010-1234-4567")));
                // 메시지를 보낼 전화번호를 설정합니다.
                startActivity(intent);
                // 생성한 인텐트를 실행합니다.
            }
        });

        btnPhoto.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // "사진 찍기" 버튼 클릭 시 실행되는 코드
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                // ACTION_IMAGE_CAPTURE 인텐트를 생성하여 카메라 앱을 엽니다.
                startActivity(intent);
                // 생성한 인텐트를 실행합니다.
            }
        });
    }
}
