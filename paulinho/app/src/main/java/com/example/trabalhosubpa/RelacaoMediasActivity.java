package com.example.trabalhosubpa;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class RelacaoMediasActivity extends AppCompatActivity {

    private Spinner spinnerDisciplinas;
    private ListView listViewAlunos;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relacaomediasactivity);

        // Inicializando os elementos do layout
        spinnerDisciplinas = findViewById(R.id.spinner_disciplinas);
        listViewAlunos = findViewById(R.id.lv_alunos);

        // Configurando o Spinner com as disciplinas
        ArrayList<String> disciplinas = new ArrayList<>();
        disciplinas.add("Selecione");
        disciplinas.add("Matemática");
        disciplinas.add("História");
        disciplinas.add("Ciências");

        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                disciplinas
        );
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerDisciplinas.setAdapter(spinnerAdapter);

        // Configurando o ListView com os alunos e médias
        ArrayList<String> alunos = new ArrayList<>();
        alunos.add("R.A.: 123456 | Média: 6,0 | Aprovado");
        alunos.add("R.A.: 654321 | Média: 5,5 | Reprovado");
        alunos.add("R.A.: 789123 | Média: 8,0 | Aprovado");

        ArrayAdapter<String> listAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                alunos
        );
        listViewAlunos.setAdapter(listAdapter);
    }
}
