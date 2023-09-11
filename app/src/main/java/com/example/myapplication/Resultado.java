package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;


import java.util.ArrayList;
public class Resultado extends AppCompatActivity {

    private TextView textNome, textnota1, textnota2, textnota3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);
        ArrayList<String> pessoasCarregadas = getIntent().getStringArrayListExtra("Pessoas");


        // Recupere os dados da Intent
        String nome = getIntent().getStringExtra("Nome");
        String note1 = getIntent().getStringExtra("Nota 1");
        String note2 = getIntent().getStringExtra("Nota 2");
        String note3 = getIntent().getStringExtra("Nota 3");

        // Exiba os dados nos campos de texto ou faça o que desejar com eles
         textNome = findViewById(R.id.textNome);
         textnota1 = findViewById(R.id.textnota1);
         textnota2 = findViewById(R.id.textnota2);
         textnota3 = findViewById(R.id.textnota3);

         textNome.setText("Nome: " + nome);
         textnota1.setText("Nota 1: " + note1);
         textnota2.setText("Nota 2: " + note2);
         textnota3.setText("Nota 3: " + note3);
    }
    public  void voltar (View view){
        finish();
    }
}