package com.uninorte.equipeprojeto.lfa;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.uninorte.equipeprojeto.model.Conteudo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego on 10/28/16.
 */

public class SerachAdapter extends BaseAdapter {

    Context context;
    ArrayList<Conteudo> conteudo;
    private LayoutInflater layoutInflater;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle args;
    Assunto assunto_frag;

    public SerachAdapter(Context c, ArrayList<Conteudo> list, FragmentManager frag){
        this.context = c;
        this.conteudo = list;
        this.fragmentManager = frag;
    }

    @Override
    public int getCount() {
        return conteudo.size();
    }

    @Override
    public Object getItem(int position) {

        return conteudo.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.search, null);
        Conteudo cont = conteudo.get(position);
        TextView textView = (TextView)  view.findViewById(R.id.titulo);
        textView.setTag(new Integer(position));
        textView.setText(cont.getConteudo());


        //Log.i("lista", conteudo.get(position).getConteudo());

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String unidade = conteudo.get((Integer) v.getTag()).getPagina();
                Log.i("lista", unidade);
                args = new Bundle();

                args.putString("id", unidade);//passa para o fragment o id do assunto
                assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                assunto_frag.setArguments(args);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
            }
        });




        return view;
    }
}
