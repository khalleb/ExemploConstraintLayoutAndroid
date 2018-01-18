package br.com.box1993.aluracursolayout.ui.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import br.com.box1993.aluracursolayout.R;
import br.com.box1993.aluracursolayout.ui.util.DiasUtil;
import br.com.box1993.aluracursolayout.ui.util.MoedaUtil;
import br.com.box1993.aluracursolayout.ui.util.ResourcesUtil;
import br.com.box1993.aluracursolayout.ui.model.Pacote;

/**
 * Created by khalleb on 17/01/18.
 */

public class ListaPacotesAdpter extends BaseAdapter {

    private final List<Pacote> pacotes;
    private final Context context;

    public ListaPacotesAdpter(List<Pacote> pacotes, Context context) {
        this.pacotes = pacotes;
        this.context = context;
    }


    @Override
    public int getCount() {
        return pacotes.size();
    }

    @Override
    public Pacote getItem(int position) {
        return pacotes.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View viewCriada = LayoutInflater.from(context).inflate(R.layout.item_pacote, parent, false);

        Pacote pacote = pacotes.get(position);

        mostraLocal(viewCriada, pacote);
        mostraImagem(viewCriada, pacote);
        mostraDias(viewCriada, pacote);
        mostraPreco(viewCriada, pacote);

        return viewCriada;
    }

    private void mostraPreco(View viewCriada, Pacote pacote) {
        TextView preco = viewCriada.findViewById(R.id.item_pacote_preco);
        String moedaBrasileira = MoedaUtil.formataParaBrasil(pacote.getPreco());
        preco.setText(moedaBrasileira);
    }


    private void mostraDias(View viewCriada, Pacote pacote) {
        TextView dias = viewCriada.findViewById(R.id.item_pacote_dias);
        String diasEmTexto = DiasUtil.formataEmTexto(pacote.getDias());
        dias.setText(diasEmTexto);
    }


    private void mostraImagem(View viewCriada, Pacote pacote) {
        ImageView imageView = viewCriada.findViewById(R.id.item_pacote_imagem);
        Drawable drawableImagemPacote = ResourcesUtil.devolverDrawable(context, pacote.getImagem());
        imageView.setImageDrawable(drawableImagemPacote);
    }



    private void mostraLocal(View viewCriada, Pacote pacote) {
        TextView local = viewCriada.findViewById(R.id.item_pacote_local);
        local.setText(pacote.getLocal());
    }
}
