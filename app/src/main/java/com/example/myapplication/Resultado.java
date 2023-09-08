package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    private TextView textNome, textnota1, textnota2, textnota3;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

                // Recupere os extras passados da atividade anterior
                Intent intent = getIntent();
                String nome = intent.getStringExtra("Nome");
                String nota1 = intent.getStringExtra("Nota 1");
                String nota2 = intent.getStringExtra("Nota 2");
                String nota3 = intent.getStringExtra("Nota 3");

                // Exiba os valores em TextViews ou onde desejar na tela de "Resultado"
                 textNome = findViewById(R.id.textNome);
                 textnota1 = findViewById(R.id.textnota1);
                 textnota2 = findViewById(R.id.textnota2);
                 textnota3 = findViewById(R.id.textnota3);

                textNome.setText("Nome: " + nome);
                textnota1.setText("Nota 1: " + nota1);
                textnota2.setText("Nota 2: " + nota2);
                textnota3.setText("Nota 3: " + nota3);
            }

    public  void voltar (View view){
        finish();
    }
}