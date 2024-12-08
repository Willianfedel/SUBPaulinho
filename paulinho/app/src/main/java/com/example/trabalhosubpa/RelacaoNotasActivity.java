package com.example.trabalhosubpa;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RelacaoNotasActivity extends AppCompatActivity {

    private Spinner spnAlunos;
    private TableLayout tblNotas;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_relacao_notas);

        // Inicializando os elementos
        spnAlunos = findViewById(R.id.spnAlunos);
        tblNotas = findViewById(R.id.tblNotas);

        // Carregar alunos no Spinner
        List<String> alunos = getAlunos();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, alunos);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnAlunos.setAdapter(adapter);

        // Listener para quando um aluno for selecionado
        spnAlunos.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String alunoSelecionado = parent.getItemAtPosition(position).toString();
                carregarNotas(alunoSelecionado);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // Nenhuma ação necessária
            }
        });
    }

    // Retorna a lista de alunos disponíveis
    private List<String> getAlunos() {
        List<String> alunos = new ArrayList<>();
        Object DataStore = null;
        for (Map<String, String> nota : DataStore())
            if (!alunos.contains(nota.get("nome"))) {
                alunos.add(nota.get("nome"));
            }
        return alunos;
    }

    // Carrega as notas do aluno selecionado e exibe na tabela
    private void carregarNotas(String aluno) {
        tblNotas.removeViews(1, tblNotas.getChildCount() - 1); // Remove linhas anteriores

        List<Map<String, String>> notasDoAluno = new ArrayList<>();
        Object DataStore = null;
        for (Map<String, String> nota : DataStore())
            if (nota.get("nome").equals(aluno)) {
                notasDoAluno.add(nota);
            }

        Class<?> mediasPorDisciplina = DataStore.getClass();

        for (Map<String, String> nota : notasDoAluno) {
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            // Coluna: Disciplina
            TextView tvDisciplina = new TextView(this);
            tvDisciplina.setText(nota.get("disciplina"));
            tvDisciplina.setPadding(8, 8, 8, 8);
            row.addView(tvDisciplina);

            // Colunas: Notas por bimestre
            for (int i = 1; i <= 4; i++) {
                TextView tvBimestre = new TextView(this);
                tvBimestre.setText(nota.get("nota"));
                tvBimestre.setPadding(8, 8, 8, 8);
                row.addView(tvBimestre);
            }

            // Coluna: Média
            TextView tvMedia = new TextView(this);
            tvMedia.setText(String.valueOf(mediasPorDisciplina.getName()));
            tvMedia.setPadding(8, 8, 8, 8);
            row.addView(tvMedia);

            tblNotas.addView(row);
        }
    }

    private Map<String, String>[] DataStore() {
        return new Map[0];
    }
}