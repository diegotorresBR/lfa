package com.uninorte.equipeprojeto.lfa;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
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

    CardView cardView_1, cardView_2, cardView_3, cardView_4, cardView_5;
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
        //
        cardView_1 = (CardView) root.findViewById(R.id.cardView1);
        cardView_2 = (CardView) root.findViewById(R.id.cardView2);
        cardView_3 = (CardView) root.findViewById(R.id.cardView3);
        cardView_4 = (CardView) root.findViewById(R.id.cardView4);
        cardView_5 = (CardView) root.findViewById(R.id.cardView5);
        //
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

        for(int i = 5;i>=1;i--) {

            Log.d("Laço", "Entrou no laço " + i);
            String local = assuntos_recentes.get(assuntos_recentes.size() - i);

            try {
                is = getActivity().getAssets().open(local);
                Document texto = Jsoup.parse(is, "UTF-8", "");
                Elements elemento_corpo = texto.getElementsByTag("h5").tagName("p");
                Elements elemento_titulo = texto.getElementsByTag("h2");
                textodocorpo = elemento_corpo.text();
                textodoTitulo = elemento_titulo.text();
                textodoTituloTratado = textodoTitulo;
                //textodoTituloTratado = textodoTitulo.substring(0, textodoTitulo.length()-7);
            } catch (Exception e) {
                Log.e("Erro na obtencao", e.getMessage());
            }

            if (i == 1) {
                t1_c1.setText(textodoTituloTratado);
                if (textodocorpo != null) {
                    cardView_1.setVisibility(View.VISIBLE);
                    t2_c1.setText(textodocorpo.substring(0, 220) + "...");
                    Log.d("setou_texto", "setou no 1");
                }
                else
                {
                    cardView_1.setVisibility(View.GONE);
                }
            } else if (i == 2) {
                t1_c2.setText(textodoTituloTratado);
                if (textodocorpo != null) {
                    cardView_2.setVisibility(View.VISIBLE);
                    t2_c2.setText(textodocorpo.substring(0, 220) + "...");
                    Log.d("setou_texto", "setou no 2");
                }
                else
                {
                    cardView_2.setVisibility(View.GONE);
                }
            } else if (i == 3) {
                t1_c3.setText(textodoTituloTratado);
                if (textodocorpo != null) {
                    cardView_3.setVisibility(View.VISIBLE);
                    t2_c3.setText(textodocorpo.substring(0, 220) + "...");
                    Log.d("setou_texto", "setou no 3");
                }
                else
                {
                    cardView_3.setVisibility(View.GONE);
                }
            } else if (i == 4) {
                t1_c4.setText(textodoTituloTratado);
                if (textodocorpo != null) {
//                    Animation animation = new TranslateAnimation(0,0,0,1000);
//                    animation.setDuration(1000);
//                    cardView_4.startAnimation(animation);
                    cardView_4.setVisibility(View.VISIBLE);
                    t2_c4.setText(textodocorpo.substring(0, 220) + "...");
                    Log.d("setou_texto", "setou no 4");
                }
                else
                {
                    cardView_4.setVisibility(View.GONE);
                }
            } else if (i == 5) {
                t1_c5.setText(textodoTituloTratado);
                if (textodocorpo != null) {
                    t2_c5.setText(textodocorpo.substring(0, 220) + "...");
                    Log.d("setou_texto", "setou no 5");
                } else {
                    t1_c5.setText(getString(R.string.objetivo_do_aplicativo));
                    t2_c5.setText(getString(R.string.ObjetivoDescricao).substring(0, 220) + "...");
                    Log.d("setou_texto", "setou no 5");
                }
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