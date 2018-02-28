package br.com.box1993.aluracursolayout.ui.ui.activity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import br.com.box1993.aluracursolayout.R;
import br.com.box1993.aluracursolayout.ui.model.Pacote;
import br.com.box1993.aluracursolayout.ui.util.DataUtil;
import br.com.box1993.aluracursolayout.ui.util.MoedaUtil;
import br.com.box1993.aluracursolayout.ui.util.ResourcesUtil;

import static br.com.box1993.aluracursolayout.ui.ui.activity.PacoteActivity.CHAVE_PACOTE;

public class ResumoCompraActivity extends AppCompatActivity {

    public static final String RESUMO_DA_COMPRA = "Resumo da Compra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resumo_compra);
        setTitle(RESUMO_DA_COMPRA);
        carregaPacoteRecebido();
    }

    private void carregaPacoteRecebido() {
        Intent intent = getIntent();
        if (intent.hasExtra(CHAVE_PACOTE)) {
            Pacote pacote = (Pacote) intent.getSerializableExtra(CHAVE_PACOTE);
            mostraLocal(pacote);
            mostraImagem(pacote);
            mostraData(pacote);
            MostraPreco(pacote);
        }
    }

    private void MostraPreco(Pacote pacote) {
        TextView preco = findViewById(R.id.resumo_compra_preco_pacote);
        String moedaBrasileira = MoedaUtil.formataParaBrasil(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }

    private void mostraData(Pacote pacote) {
        TextView data = findViewById(R.id.resumo_compra_data_viagem);
        String peridoTexto = DataUtil.periodoEmTexto(pacote.getDias());
        data.setText(peridoTexto);
    }

    private void mostraImagem(Pacote pacote) {
        ImageView imagem = findViewById(R.id.resumo_compra_imagem_pacote);
        Drawable drawable = ResourcesUtil.devolverDrawable(this, pacote.getImagem());
        imagem.setImageDrawable(drawable);
    }

    private void mostraLocal(Pacote pacote) {
        TextView local = findViewById(R.id.resumo_compra_local_pacote);
        local.setText(pacote.getLocal());
    }
}
