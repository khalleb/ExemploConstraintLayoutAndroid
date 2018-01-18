package br.com.box1993.aluracursolayout.ui.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.List;

import br.com.box1993.aluracursolayout.R;
import br.com.box1993.aluracursolayout.ui.dao.PacoteDAO;
import br.com.box1993.aluracursolayout.ui.ui.adapter.ListaPacotesAdpter;
import br.com.box1993.aluracursolayout.ui.model.Pacote;

public class MainActivity extends AppCompatActivity {


    public static final String TITULO_APPBAR = "Pacotes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle(TITULO_APPBAR);

        configuraLista();
    }

    private void configuraLista() {
        ListView listViewPacotes = findViewById(R.id.activity_main_lista);
        List<Pacote> pacotes = new PacoteDAO().lista();
        listViewPacotes.setAdapter(new ListaPacotesAdpter(pacotes, this));
    }
}
