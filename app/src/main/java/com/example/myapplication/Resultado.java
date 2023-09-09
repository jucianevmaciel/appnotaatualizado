package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.widget.EditText;
import android.widget.TextView;

import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Resultado extends AppCompatActivity {



        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_resultado);

            ListView listView = findViewById(R.id.listView);

            // Obtenha os dados das intenções extras
            ArrayList<String> nomes = getIntent().getStringArrayListExtra("Nomes");
            ArrayList<String> notas1 = getIntent().getStringArrayListExtra("Notas1");
            ArrayList<String> notas2 = getIntent().getStringArrayListExtra("Notas2");
            ArrayList<String> notas3 = getIntent().getStringArrayListExtra("Notas3");

            // Crie uma lista de strings para exibir os dados
            ArrayList<String> dados = new ArrayList<>();

            // Preencha a lista com os dados das pessoas
            for (int i = 0; i < nomes.size(); i++) {
                String nome = nomes.get(i);
                String nota1 = notas1.get(i);
                String nota2 = notas2.get(i);
                String nota3 = notas3.get(i);

                // Adicione os dados ao formato desejado na lista
                dados.add("Nome: " + nome + "\nNota 1: " + nota1 + "\nNota 2: " + nota2 + "\nNota 3: " + nota3);
            }

            // Crie um adaptador para preencher o ListView com os dados
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, dados);

            // Configure o ListView para usar o adaptador
            listView.setAdapter(adapter);
        }

    public  void voltar (View view){
        finish();
    }
}