package com.uninorte.equipeprojeto.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.uninorte.equipeprojeto.model.Pergunta;

import java.util.List;

public class PerguntaAdapter extends BaseAdapter {
    private Context context;
    private List<Pergunta> lista;

    public PerguntaAdapter(Context context, List<Pergunta> perguntas){
        this.context = context;
        this.lista = perguntas;
    }

    @Override
    public int getCount() {
        return lista.size();
    }

    @Override
    public Object getItem(int position) {
        return lista.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        Pergunta pergunta = lista.get(position);

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.usuarios, null);
        }

//        TextView txtNome = (TextView) view.findViewById(R.id.usuario_lista_nome);
//        txtNome.setText(usuario.getNome());
        return view;
    }
}
