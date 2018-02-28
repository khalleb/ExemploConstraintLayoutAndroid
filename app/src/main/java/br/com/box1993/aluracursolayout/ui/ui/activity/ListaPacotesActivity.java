package br.com.box1993.aluracursolayout.ui.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.box1993.aluracursolayout.R;
import br.com.box1993.aluracursolayout.ui.dao.PacoteDAO;
import br.com.box1993.aluracursolayout.ui.model.Pacote;
import br.com.box1993.aluracursolayout.ui.ui.adapter.ListaPacotesAdpter;

import static br.com.box1993.aluracursolayout.ui.ui.activity.PacoteActivity.CHAVE_PACOTE;

public class ListaPacotesActivity extends AppCompatActivity {


    public static final String TITULO_APPBAR = "Pacotes";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_pacotes);
        setTitle(TITULO_APPBAR);
        configuraLista();
    }

    private void configuraLista() {
        ListView listViewPacotes = findViewById(R.id.activity_main_lista);
        final List<Pacote> pacotes = new PacoteDAO().lista();
        listViewPacotes.setAdapter(new ListaPacotesAdpter(pacotes, this));
        listViewPacotes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Pacote pacoteClicado = pacotes.get(position);
                vaiParaResumoPacote(pacoteClicado);
            }
        });
    }

    private void vaiParaResumoPacote(Pacote pacoteClicado) {
        Intent intent = new Intent(ListaPacotesActivity.this, ResumoPacoteActivity.class);
        intent.putExtra(CHAVE_PACOTE, pacoteClicado);
        startActivity(intent);
    }
}
