package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.LinearLayout;
import android.widget.TextView;


import java.util.ArrayList;
public class Resultado extends AppCompatActivity {

    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        linearLayout = findViewById(R.id.linearLayout);
        ArrayList<String> notassalvas = getIntent().getStringArrayListExtra("estudantes");

        for (String pessoaInfor : notassalvas) {
            TextView textView = new TextView(this);
            textView.setText(pessoaInfor);
            linearLayout.addView(textView);
        }
    }
    public  void voltar (View view){
        finish();
    }
}