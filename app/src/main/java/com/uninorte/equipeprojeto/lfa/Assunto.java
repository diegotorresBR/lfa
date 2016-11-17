package com.uninorte.equipeprojeto.lfa;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.util.Log;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.webkit.WebViewClient;


/**
 * Created by Leandro on 24/09/2016.
 * Esse fragment e utilizado apenas para a exibicao do assunto a ser escolhido. a pagina html sera
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
        webView = (WebView) rootView.findViewById(R.id.mybrowser);
        WebSettings webSetting = webView.getSettings();
        webView.getSettings().setBuiltInZoomControls(true);//FUNCAO ZOOM ATIVADO
        webView.getSettings().setDisplayZoomControls(false); //FUNCAO PARA DESATIVAR CONTROLE DE ZOOM
        webView.loadUrl("file:///android_asset/" + res);
        return rootView;







    }

}



