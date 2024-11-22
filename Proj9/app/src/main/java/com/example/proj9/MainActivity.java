package com.example.proj9;
// 프로젝트의 패키지 이름을 정의합니다.

import androidx.appcompat.app.AppCompatActivity;
// AppCompatActivity를 가져와서 액티비티를 확장합니다.

import android.content.Context;
// 컨텍스트를 가져오기 위한 클래스입니다.

import android.graphics.Bitmap;
// 비트맵 이미지를 사용하기 위한 클래스입니다.

import android.graphics.BitmapFactory;
// 비트맵 이미지를 디코딩하기 위한 유틸리티 클래스입니다.

import android.graphics.Canvas;
// 2D 그래픽을 그리기 위한 캔버스 클래스입니다.

import android.graphics.ColorMatrix;
// 색상 필터를 설정하기 위한 클래스입니다.

import android.graphics.ColorMatrixColorFilter;
// 색상 행렬 필터를 적용하기 위한 클래스입니다.

import android.graphics.Paint;
// 캔버스에 그리기 위한 페인트 속성을 설정하기 위한 클래스입니다.

import android.os.Bundle;
// 액티비티에서 상태 정보를 저장하거나 복원하기 위한 클래스입니다.

import android.view.View;
// UI 컴포넌트의 뷰 클래스를 가져옵니다.

import android.widget.ImageButton;
// 이미지 버튼을 사용하기 위한 클래스입니다.

import android.widget.LinearLayout;
// 레이아웃을 설정하기 위한 LinearLayout 클래스입니다.

public class MainActivity extends AppCompatActivity {
// MainActivity 클래스는 AppCompatActivity를 확장합니다.

    ImageButton ibZoomin, ibZoomout, ibRotate, ibBright, ibDark, ibGray;
    // 각각 확대, 축소, 회전, 밝기 조절, 어둡기 조절, 회색조 변환 버튼입니다.

    MyGraphicView graphicView;
    // 사용자 정의 뷰 클래스의 인스턴스를 선언합니다.

    static float scaleX = 1, scaleY = 1;
    // x축과 y축의 확대/축소 비율을 초기값으로 1로 설정합니다.

    static float angle = 0;
    // 이미지를 회전시킬 각도를 초기값 0으로 설정합니다.

    static float color = 1;
    // 밝기 조절을 위한 색상 비율을 초기값 1로 설정합니다.

    static float satur = 1;
    // 색조 조절을 위한 포화도 비율을 초기값 1로 설정합니다.

    @Override
    public void onCreate(Bundle savedInstanceState) {
        // 액티비티가 처음 생성될 때 호출되는 메서드입니다.

        super.onCreate(savedInstanceState);
        // 상위 클래스의 onCreate 메서드를 호출합니다.

        setContentView(R.layout.activity_main);
        // activity_main 레이아웃을 현재 액티비티의 뷰로 설정합니다.

        setTitle("미니 포토샵");
        // 액티비티의 제목을 "미니 포토샵"으로 설정합니다.

        LinearLayout pictureLayout = (LinearLayout) findViewById(R.id.pictureLayout);
        // activity_main 레이아웃의 pictureLayout을 가져옵니다.

        graphicView = (MyGraphicView) new MyGraphicView(this);
        // MyGraphicView의 인스턴스를 생성합니다.

        pictureLayout.addView(graphicView);
        // pictureLayout에 graphicView를 추가합니다.

        clickIcons();
        // 버튼 클릭 리스너를 설정하기 위한 메서드를 호출합니다.
    }

    private void clickIcons() {
        // 버튼 클릭 이벤트를 설정하기 위한 메서드입니다.

        ibZoomin = (ImageButton) findViewById(R.id.ibZoomin);
        // 확대 버튼의 아이디를 가져옵니다.

        ibZoomin.setOnClickListener(new View.OnClickListener() {
            // 확대 버튼에 클릭 리스너를 설정합니다.

            public void onClick(View v) {
                // 버튼 클릭 시 호출되는 메서드입니다.

                scaleX = scaleX + 0.2f;
                // x축 확대 비율을 0.2 증가시킵니다.

                scaleY = scaleY + 0.2f;
                // y축 확대 비율을 0.2 증가시킵니다.

                graphicView.invalidate();
                // 뷰를 다시 그려 변경된 상태를 반영합니다.
            }
        });

        ibZoomout = (ImageButton) findViewById(R.id.ibZoomout);
        // 축소 버튼의 아이디를 가져옵니다.

        ibZoomout.setOnClickListener(new View.OnClickListener() {
            // 축소 버튼에 클릭 리스너를 설정합니다.

            public void onClick(View v) {
                // 버튼 클릭 시 호출되는 메서드입니다.

                scaleX = scaleX - 0.2f;
                // x축 축소 비율을 0.2 감소시킵니다.

                scaleY = scaleY - 0.2f;
                // y축 축소 비율을 0.2 감소시킵니다.

                graphicView.invalidate();
                // 뷰를 다시 그려 변경된 상태를 반영합니다.
            }
        });

        ibRotate = (ImageButton) findViewById(R.id.ibRotate);
        // 회전 버튼의 아이디를 가져옵니다.

        ibRotate.setOnClickListener(new View.OnClickListener() {
            // 회전 버튼에 클릭 리스너를 설정합니다.

            public void onClick(View v) {
                // 버튼 클릭 시 호출되는 메서드입니다.

                angle = angle + 20;
                // 이미지를 20도씩 회전시킵니다.

                graphicView.invalidate();
                // 뷰를 다시 그려 변경된 상태를 반영합니다.
            }
        });

        ibBright = (ImageButton) findViewById(R.id.ibBright);
        // 밝기 증가 버튼의 아이디를 가져옵니다.

        ibBright.setOnClickListener(new View.OnClickListener() {
            // 밝기 증가 버튼에 클릭 리스너를 설정합니다.

            public void onClick(View v) {
                // 버튼 클릭 시 호출되는 메서드입니다.

                color = color + 0.2f;
                // 밝기를 0.2 증가시킵니다.

                graphicView.invalidate();
                // 뷰를 다시 그려 변경된 상태를 반영합니다.
            }
        });

        ibDark = (ImageButton) findViewById(R.id.ibDark);
        // 밝기 감소 버튼의 아이디를 가져옵니다.

        ibDark.setOnClickListener(new View.OnClickListener() {
            // 밝기 감소 버튼에 클릭 리스너를 설정합니다.

            public void onClick(View v) {
                // 버튼 클릭 시 호출되는 메서드입니다.

                color = color - 0.2f;
                // 밝기를 0.2 감소시킵니다.

                graphicView.invalidate();
                // 뷰를 다시 그려 변경된 상태를 반영합니다.
            }
        });

        ibGray = (ImageButton) findViewById(R.id.ibGray);
        // 회색조 변환 버튼의 아이디를 가져옵니다.

        ibGray.setOnClickListener(new View.OnClickListener() {
            // 회색조 변환 버튼에 클릭 리스너를 설정합니다.

            public void onClick(View v) {
                // 버튼 클릭 시 호출되는 메서드입니다.

                if (satur == 0)
                    // 현재 색조가 회색조라면,

                    satur = 1;
                    // 색조를 원래 상태로 돌립니다.

                else
                    satur = 0;
                // 색조를 회색조로 만듭니다.

                graphicView.invalidate();
                // 뷰를 다시 그려 변경된 상태를 반영합니다.
            }
        });
    }

    private static class MyGraphicView extends View {
        // 사용자 정의 뷰 클래스입니다.

        public MyGraphicView(Context context) {
            // MyGraphicView 생성자입니다.

            super(context);
            // 부모 클래스 생성자를 호출합니다.
        }

        @Override
        protected void onDraw(Canvas canvas) {
            // 뷰를 그릴 때 호출되는 메서드입니다.

            super.onDraw(canvas);
            // 상위 클래스의 onDraw 메서드를 호출합니다.

            int cenX = this.getWidth() / 2;
            // 뷰의 중심 x좌표를 계산합니다.

            int cenY = this.getHeight() / 2;
            // 뷰의 중심 y좌표를 계산합니다.

            canvas.scale(scaleX, scaleY, cenX, cenY);
            // 뷰의 중심을 기준으로 확대/축소를 적용합니다.

            canvas.rotate(angle, cenX, cenY);
            // 뷰의 중심을 기준으로 회전을 적용합니다.

            Paint paint = new Paint();
            // 페인트 객체를 생성합니다.

            float[] array = { color, 0, 0, 0, 0, 0, color, 0, 0, 0, 0, 0,
                    color, 0, 0, 0, 0, 0, 1, 0 };
            // 색상을 변경하기 위한 행렬 배열을 정의합니다.

            ColorMatrix cm = new ColorMatrix(array);
            // ColorMatrix 객체를 생성합니다.

            if (satur == 0)
                // 색조가 회색조 상태라면,

                cm.setSaturation(satur);
            // 색조를 회색조로 설정합니다.

            paint.setColorFilter(new ColorMatrixColorFilter(cm));
            // 페인트 객체에 색상 필터를 적용합니다.

            Bitmap picture = BitmapFactory.decodeResource(getResources(),
                    R.drawable.lena256);
            int picX = (this.getWidth() - picture.getWidth()) / 2;
            int picY = (this.getHeight() - picture.getHeight()) / 2;
            canvas.drawBitmap(picture, picX, picY, paint);

            picture.recycle();
        }
    }
}
