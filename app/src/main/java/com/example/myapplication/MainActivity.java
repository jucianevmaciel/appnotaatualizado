package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.R;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private EditText textnome, nota1, nota2, nota3;
    private Context context;
    private SharedPreferences sharedPrefs;
    private int contadorPessoas = 0; // Contador para gerar chaves únicas


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = getApplicationContext();
        setContentView(R.layout.activity_main);
        sharedPrefs = getSharedPreferences("myPrefs", Context.MODE_PRIVATE);




    }

    public void salvar(View view) {
        textnome = findViewById(R.id.textnome);
        nota1 = findViewById(R.id.nota1);
        nota2 = findViewById(R.id.nota2);
        nota3 = findViewById(R.id.nota3);

        String nome = textnome.getText().toString();
        String note1 = nota1.getText().toString();
        String note2 = nota2.getText().toString();
        String note3 = nota3.getText().toString();

        if (nome.isEmpty()) {
            Toast.makeText(context, "Digite um nome", Toast.LENGTH_SHORT).show();
            return;
        }

        if (note1.isEmpty() || note2.isEmpty() || note3.isEmpty()) {
            Toast.makeText(context, "Digite todas as notas", Toast.LENGTH_SHORT).show();
            return;
        }

        String chavePessoa = "pessoa_" + contadorPessoas;
        contadorPessoas++;

        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(chavePessoa + "_nome", nome);
        editor.putString(chavePessoa + "_nota1", note1);
        editor.putString(chavePessoa + "_nota2", note2);
        editor.putString(chavePessoa + "_nota3", note3);
        editor.apply();


        // Se desejar, você pode adicionar uma ação após salvar os dados.
        // Exemplo: exibir uma mensagem de sucesso.
        Toast.makeText(context, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();
    }
    public void carregar(View view) {
        if (contadorPessoas < 1) {
            Toast.makeText(context, "Nenhum dado para carregar", Toast.LENGTH_SHORT).show();
            return;
        }

        // Recupere os dados da primeira pessoa (chave 1)
        String chavePessoa = "pessoa_" + contadorPessoas;
        String nome = sharedPrefs.getString(chavePessoa + "_nome", "");
        String nota1 = sharedPrefs.getString(chavePessoa + "_nota1", "");
        String nota2 = sharedPrefs.getString(chavePessoa + "_nota2", "");
        String nota3 = sharedPrefs.getString(chavePessoa + "_nota3", "");


        Intent telaResultado = new Intent(getApplicationContext(), Resultado.class);
        telaResultado.putExtra("Nome", nome);
        telaResultado.putExtra("Nota 1", nota1);
        telaResultado.putExtra("Nota 2", nota2);
        telaResultado.putExtra("Nota 3", nota3);
        startActivity(telaResultado);


        // Incrementar o contador para carregar a próxima pessoa na próxima vez
        contadorPessoas++;


        // Exibe uma mensagem de sucesso
        Toast.makeText(this, "Dados carregados com sucesso", Toast.LENGTH_SHORT).show();
    }
}
