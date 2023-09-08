package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import com.example.myapplication.R;


public class MainActivity extends AppCompatActivity {
    private EditText textnome, nota1, nota2, nota3;
    private Context context;
    private SharedPreferences sharedPrefs;

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
        nota2 = findViewById(R.id.note2);
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

        // Salva os dados em SharedPreferences
        SharedPreferences.Editor editor = sharedPrefs.edit();
        editor.putString(nome, note1 + "," + note2 + "," + note3);
        editor.apply();

        // Se desejar, você pode adicionar uma ação após salvar os dados.
        // Exemplo: exibir uma mensagem de sucesso.
        Toast.makeText(context, "Dados salvos com sucesso", Toast.LENGTH_SHORT).show();
    }
}
