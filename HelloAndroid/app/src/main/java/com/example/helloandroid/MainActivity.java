package com.example.helloandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity { //extends 뒤에 오는게 부모 클래스

    @Override
    protected void onCreate(Bundle savedInstanceState) { //on~ : ~했을때 (ex)onCreate: 생성 했을때
        super.onCreate(savedInstanceState); //super: 부모 클래스
        setContentView(R.layout.activity_main);
    }
}