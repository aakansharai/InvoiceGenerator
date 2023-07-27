package com.example.pdfgenerater;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.TextView;

public class tryPDF extends AppCompatActivity {

    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_try_pdf);

        tv = findViewById(R.id.cityFrom);

        tv.setText("MADARCHOD");

    }
}