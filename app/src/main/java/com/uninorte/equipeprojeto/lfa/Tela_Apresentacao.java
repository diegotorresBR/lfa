package com.uninorte.equipeprojeto.lfa;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by diego on 11/1/16.
 */

public class Tela_Apresentacao extends Fragment {

    TextView t1_c1, t2_c1, t1_c2, t2_c2, t1_c3, t2_c3, t1_c4, t2_c4, t1_c5, t2_c5;
    List<String> assuntos_recentes = new ArrayList<String>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.tela_apresentacao, container, false);

        t1_c1 = (TextView) root.findViewById(R.id.texto1_card1);
        t2_c1 = (TextView) root.findViewById(R.id.texto2_card1);
        t1_c2 = (TextView) root.findViewById(R.id.texto1_card2);
        t2_c2 = (TextView) root.findViewById(R.id.texto2_card2);
        t1_c3 = (TextView) root.findViewById(R.id.texto1_card3);
        t2_c3 = (TextView) root.findViewById(R.id.texto2_card3);
        t1_c4 = (TextView) root.findViewById(R.id.texto1_card4);
        t2_c4 = (TextView) root.findViewById(R.id.texto2_card4);
        t1_c5 = (TextView) root.findViewById(R.id.texto1_card5);
        t2_c5 = (TextView) root.findViewById(R.id.texto2_card5);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) root.findViewById(R.id.collapsing_toolbar);
        ultimo_card();

        return root;
    }

    public void obter_texto(String html){


        Log.d("No Frag Inico", html);

        InputStream is = null;
        String textodocorpo = null;
        String textodoTitulo = null;
        String textodoTituloTratado = null;

            for(int i = 5;i>=1;i--){

                Log.d("Laço", "Entrou no laço "+i);
                String local = assuntos_recentes.get(assuntos_recentes.size()-i);

                try {

                    is = getActivity().getAssets().open(local);
                    Document texto = Jsoup.parse(is, "UTF-8", "");
                    Elements elemento_corpo = texto.getElementsByTag("h5").tagName("p");
                    Elements elemento_titulo = texto.getElementsByTag("h2");
                    textodocorpo = elemento_corpo.text();
                    textodoTitulo = elemento_titulo.text();
                    textodoTituloTratado = textodoTitulo.substring(0, textodoTitulo.length()-7);

                }catch (Exception e){
                    Log.e("Erro na obtencao", e.getMessage());
                }




                if(i == 0){
                    t1_c1.setText(textodoTituloTratado);
                    t2_c1.setText(textodocorpo);
                }else if(i == 1){
                    t1_c2.setText(textodoTituloTratado);
                    t2_c2.setText(textodocorpo);
                }else if(i == 2){
                    t1_c3.setText(textodoTituloTratado);
                    t2_c3.setText(textodocorpo);
                }else if(i == 3){
                    t1_c4.setText(textodoTituloTratado);
                    t2_c4.setText(textodocorpo);
                }else if(i == 4){
                    t1_c5.setText(textodoTituloTratado);
                    t2_c5.setText(textodocorpo);
                }
            }

    }


    public void ultimo_card(){

        final SharedPreferences opcoes = getActivity().getSharedPreferences("0", Context.MODE_PRIVATE);
        String card_1 = opcoes.getString("card1", "");
        String card_2 = opcoes.getString("card2", "");
        String card_3 = opcoes.getString("card3", "");
        String card_4 = opcoes.getString("card4", "");
        String card_5 = opcoes.getString("card5", "");
        Log.d("Pagina para Shared", card_2);
        assuntos_recentes.add(card_5);
        assuntos_recentes.add(card_4);
        assuntos_recentes.add(card_3);
        assuntos_recentes.add(card_2);
        assuntos_recentes.add(card_1);
        obter_texto("nada");
    }


}
