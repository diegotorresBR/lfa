package com.uninorte.equipeprojeto.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uninorte.equipeprojeto.dao.DatabaseHelper;
import com.uninorte.equipeprojeto.lfa.R;
import com.uninorte.equipeprojeto.model.Unidade;

import java.util.List;

public class UnidadeAdapter extends BaseAdapter {
    private Context context;
    private List<Unidade> lista;

    public UnidadeAdapter(Context context, List<Unidade> unidades){
        this.context = context;
        this.lista = unidades;
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
        Unidade unidade = lista.get(position);

        if (view==null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
//            view = inflater.inflate(R.layout.usuarios, null);
        }

//        TextView txtNome = (TextView) view.findViewById(R.id.usuario_lista_nome);
//        txtNome.setText(usuario.getNome());
        return view;
    }
}
