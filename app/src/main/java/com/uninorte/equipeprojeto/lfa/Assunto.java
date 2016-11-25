package com.uninorte.equipeprojeto.lfa;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

/**
 * Created by Leandro on 24/09/2016.
 * Esse fragment e utilizado apenas para a exibicao do assunto a ser escolhido. a imagem sera
 * sobreposta conforme o assunto escolhido
 */
public class Assunto extends Fragment {
    WebView webView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.assunto_conteudo, container, false);
        Bundle a = getArguments();
        String res = a.getString("id");//obtem0 o id da imagem do assunto selecionado
        webView= (WebView)rootView.findViewById(R.id.mybrowser);
        webView.loadUrl("file:///android_asset/"+res);
        recentes(res);

        webView.getSettings().setBuiltInZoomControls(true);//FUNCAO ZOOM ATIVADO
        webView.getSettings().setDisplayZoomControls(false);

        return rootView;
//        dijon
    }

    public void recentes(String html){
        final SharedPreferences opcoes = getActivity().getSharedPreferences("0", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = opcoes.edit();
        Integer indice = opcoes.getInt("valor", 0);
        Log.d("Valor do Indice", indice.toString());
        if(indice == 1){
            editor.putString("card1", html);
            editor.putInt("valor", 2);
            editor.commit();
        }else if(indice == 2){
            editor.putString("card2", html);
            editor.putInt("valor", 3);
            editor.commit();
        }else if(indice == 3) {
            editor.putString("card3", html);
            editor.putInt("valor", 4);
            editor.commit();
        }else if(indice == 4) {
            editor.putString("card4", html);
            editor.putInt("valor", 5);
            editor.commit();
        }else if(indice == 5) {
            editor.putString("card5", html);
            editor.putInt("valor", 1);
            editor.commit();
        }else if(indice == 0) {
            //editor.putString("card4", html);
            editor.putInt("valor", 1);
            editor.commit();
            recentes(html);
        }

    }
}