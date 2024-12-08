package com.example.trabalhosubpa;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class CadastroNotasActivity extends AppCompatActivity {

    private EditText etRa, etNome, etNota;
    private Spinner spnDisciplina, spnBimestre;
    private Button btnAdicionar, btnVerNotas, btnVerMedias;

    public CadastroNotasActivity(EditText etRa) {
        this.etRa = etRa;
    }

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_notass);

        // Inicializando os elementos do layout
        etRa = findViewById(R.id.etRa);
        etNome = findViewById(R.id.etNome);
        etNota = findViewById(R.id.etNota);
        spnDisciplina = findViewById(R.id.spnDisciplina);
        spnBimestre = findViewById(R.id.spnBimestre);
        btnAdicionar = findViewById(R.id.btnAdicionar);
        btnVerNotas = findViewById(R.id.btnVerNotas);
        btnVerMedias = findViewById(R.id.btnVerMedias);

        // Configurando opções do Spinner de disciplinas
        List<String> disciplinas = new ArrayList<>();
        disciplinas.add("Matemática");
        disciplinas.add("Português");
        disciplinas.add("História");
        disciplinas.add("Ciências");

        ArrayAdapter<String> adapterDisciplina = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, disciplinas);
        adapterDisciplina.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnDisciplina.setAdapter(adapterDisciplina);

        // Configurando opções do Spinner de bimestres
        List<String> bimestres = new ArrayList<>();
        bimestres.add("1º Bimestre");
        bimestres.add("2º Bimestre");
        bimestres.add("3º Bimestre");
        bimestres.add("4º Bimestre");

        ArrayAdapter<String> adapterBimestre = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, bimestres);
        adapterBimestre.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnBimestre.setAdapter(adapterBimestre);

        // Ação do botão "Adicionar"
        btnAdicionar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String ra = etRa.getText().toString();
                String nome = etNome.getText().toString();
                String disciplina = spnDisciplina.getSelectedItem().toString();
                String notaStr = etNota.getText().toString();
                String bimestre = spnBimestre.getSelectedItem().toString();

                if (!ra.isEmpty() && !nome.isEmpty() && !notaStr.isEmpty()) {
                    try {
                        double nota = Double.parseDouble(notaStr);

                        // Adicionando nota no DataStore
                        Object DataStore = null;
                        DataStore.wait();

                        Toast.makeText(CadastroNotasActivity.this, "Nota adicionada com sucesso!", Toast.LENGTH_SHORT).show();

                        // Limpando os campos
                        etRa.setText("");
                        etNome.setText("");
                        etNota.setText("");

                    } catch (NumberFormatException e) {
                        Toast.makeText(CadastroNotasActivity.this, "Digite uma nota válida.", Toast.LENGTH_SHORT).show();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                } else {
                    Toast.makeText(CadastroNotasActivity.this, "Preencha todos os campos.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Navegação para "Ver Notas"
        btnVerNotas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroNotasActivity.this, RelacaoNotasActivity.class);
                startActivity(intent);
            }
        });

        // Navegação para "Ver Médias"
        btnVerMedias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CadastroNotasActivity.this, RelacaoMediasActivity.class);
                startActivity(intent);
            }
        });
    }
}