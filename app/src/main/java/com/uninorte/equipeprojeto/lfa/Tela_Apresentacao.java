package com.uninorte.equipeprojeto.lfa;

import android.app.Fragment;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by diego on 11/1/16.
 */

public class Tela_Apresentacao extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.tela_apresentacao, container, false);

        CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) root.findViewById(R.id.collapsing_toolbar);

        //ImageView imageView = (ImageView) root.findViewById(R.id.backdrop);
        //Glide.with(this).load("https://unsplash.it/600/300/?random").centerCrop().into(imageView);

        return root;
    }




}
