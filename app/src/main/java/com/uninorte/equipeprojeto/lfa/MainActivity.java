package com.uninorte.equipeprojeto.lfa;

import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.support.design.widget.NavigationView;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.Toast;

import com.mikepenz.materialdrawer.AccountHeader;
import com.mikepenz.materialdrawer.AccountHeaderBuilder;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.ExpandableDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.SectionDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;
import com.uninorte.equipeprojeto.model.Conteudo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
    Essa classe principal contem os principais elementos da tela
    O Menu lateral, a lista de topicos de LFA e os subtopicos.
    Cada vez que o usuario clicar em um topico no menu lateral,
    os demais subtopicos irao aparecer e ao clicar em algum destes,
    o assunto sera mostradro no layout central. Para melhor manutencao,
    optamos por separar o conteudo exibido em fragments. Havera um fragment
    padrao para a exibiçao de conteudo e outro para a exibicao do quiz.

 */
public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener , resultado_fragment.OnFragmentInteractionListener {
    private Toolbar toolbar;
    private List<String> grupos;//Conteudos
    private HashMap<String, List<String>> dadosGrupos;
    private int ultimaPosicionExpList = -1;
    private MyAdapter adapter;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle args;
    List<Conteudo> conteudos, conteudos_resultado;
    Assunto assunto_frag;
    Pergunta_quiz quiz;
    AccountHeader header;
    ExpandableDrawerItem unidade1, unidade2, unidade3, unidade4, unidade5;
    SecondaryDrawerItem unidade_filho;
    Drawer drawer;
    //referente as chamadas das unidades para o quiz -- novo
    public static final int quiz_unidade_geral  = 0;
    public static final int quiz_unidade_1      = 1;
    public static final int quiz_unidade_2      = 2;
    public static final int quiz_unidade_3      = 3;
    public static final int quiz_unidade_4      = 4;
    public static final int quiz_unidade_5      = 5;

    private Toast toast;
    private long lastBackPressTime = 0;

    //responsavel por controlar qual é a activity atual
    boolean atividadePrincipal=true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_main);
        if (!atividadePrincipal) {
            finish();
        }
        args = new Bundle();
        fragmentManager = getFragmentManager();
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        header = new AccountHeaderBuilder().withActivity(this).withTranslucentStatusBar(true).withHeaderBackground(R.drawable.side_nav_bar).build();
        carregarDados();
        criar_drawer();
        setSupportActionBar(toolbar);
        iniciar();
    }

    private void carregarDados() {

        grupos = new ArrayList<String>();
        dadosGrupos = new HashMap<String, List<String>>();

        grupos.add("Unidade 1 - Conceitos Básicos");
        grupos.add("Unidade 2 - Linguagens Regulares");
        grupos.add("Unidade 3 - Gramática");
        grupos.add("Unidade 4 - Linguagens Livre do Contexto");
        grupos.add("Unidade 5 - Máquina de Turing");


        List<String> filhos_grupo1 = new ArrayList<String>();
        filhos_grupo1.add("1.1.Introdução");
        filhos_grupo1.add("1.2.Formalismo");
        filhos_grupo1.add("1.3.Conteitos de Alfabeto e Gramatica");
        filhos_grupo1.add("1.4.Linguaguem Formal");
        filhos_grupo1.add("1.5.Quiz Unidade 1");

        List<String> filhos_grupo2 = new ArrayList<String>();
        filhos_grupo2.add("2.1.Introdução");
        filhos_grupo2.add("2.2.Sistema de Estados Finitos");
        filhos_grupo2.add("2.3.Composicao Sequencia | Corrente e Não Deterministica");
        filhos_grupo2.add("2.4.Automato Finito");
        filhos_grupo2.add("2.5.Automato Finito Deterministico");
        filhos_grupo2.add("2.6.Definicao da função programa estendida ou computação");
        filhos_grupo2.add("2.7.Linguagem aceita e linguagem rejeitada");
        filhos_grupo2.add("2.8.Automato Finito equivalentes");
        filhos_grupo2.add("2.9.Automato Finito Não-deterministico");
        filhos_grupo2.add("2.10.Automato com Movimentos Vazios");
        filhos_grupo2.add("2.11.Linguagem regular");
        filhos_grupo2.add("2.12.Expressão regular");
        filhos_grupo2.add("2.13.Quiz Unidade 2");

        List<String> filhos_grupo3 = new ArrayList<String>();
        filhos_grupo3.add("3.1.Gramática Formal");
        filhos_grupo3.add("3.2.Gramáticas Equivalentes");
        filhos_grupo3.add("3.3.Gramática Regular");
        filhos_grupo3.add("3.4.Gramática linear á direita");
        filhos_grupo3.add("3.5.Gramática linear á esquerda");
        filhos_grupo3.add("3.6.Gramática linear unitária á direita");
        filhos_grupo3.add("3.7.Gramática linear unitária á esquerda");
        filhos_grupo3.add("3.8.Automato finito com saída");
        filhos_grupo3.add("3.9.Máquina de Mealy");
        filhos_grupo3.add("3.10.Máquina de Moore");
        filhos_grupo3.add("3.11.Quiz Unidade 3");

        List<String> filhos_grupo4 = new ArrayList<String>();
        filhos_grupo4.add("4.1.Aplicações");
        filhos_grupo4.add("4.2.Automato com Pilha");
        filhos_grupo4.add("4.3.Gramática Livre do Contexto");
        filhos_grupo4.add("4.4.Algoritmos de Reconhecimento");
        filhos_grupo4.add("4.5.Quiz Unidade 4");

        List<String> filhos_grupo5 = new ArrayList<String>();
        filhos_grupo5.add("5.1.Definição");
        filhos_grupo5.add("5.2.Modelo");
        filhos_grupo5.add("5.3.Definição formal");
        filhos_grupo5.add("5.4.Processamento");
        filhos_grupo5.add("5.5.Decidibilidade");
        filhos_grupo5.add("5.6.Quiz Unidade 5");


        dadosGrupos.put(grupos.get(0), filhos_grupo1);
        dadosGrupos.put(grupos.get(1), filhos_grupo2);
        dadosGrupos.put(grupos.get(2), filhos_grupo3);
        dadosGrupos.put(grupos.get(3), filhos_grupo4);
        dadosGrupos.put(grupos.get(4), filhos_grupo5);

        adapter = new MyAdapter(this, grupos, dadosGrupos);
        //mDrawerExpandableList.setAdapter(adapter);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        searchView.setOnQueryTextListener(this);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Log.i("drawer", "entrou no home");
                if (drawer.isDrawerOpen()) {
                    Log.i("drawer", "aberto");
                    drawer.closeDrawer();
                } else {
                    drawer.openDrawer();
                    Log.i("drawer", "fechado");
                }
                break;
            default:
                break;
        }
        return true;
    }

    public void criar_drawer() {
        unidade1 = new ExpandableDrawerItem().withName("Conceitos Basicos");
        unidade2 = new ExpandableDrawerItem().withName("Linguagens Regulares");
        unidade3 = new ExpandableDrawerItem().withName("Gramatica");
        unidade4 = new ExpandableDrawerItem().withName("Linguagens Livre do Contexto");
        unidade5 = new ExpandableDrawerItem().withName("Máquina de Turing");

        popular_menu_assuntos();

        drawer = new DrawerBuilder().withActivity(this).withToolbar(toolbar).
                withAccountHeader(header).
                withHasStableIds(true).
                addDrawerItems(
                        new PrimaryDrawerItem().withName("Inicio").withDescription("Comece Aqui").withIdentifier(1).withSelectable(true),
                        new SectionDrawerItem().withName("Aprender"),
                        unidade1, unidade2, unidade3, unidade4, unidade5,
                        new PrimaryDrawerItem().withName("Quiz").withIdentifier(2).withSelectable(true),
                        new SectionDrawerItem().withName("Sobre")
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {


            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                //////////////////////////////////////////////////UNIDADE 01 /////////////////////////////////////////////
                if (drawerItem != null) {
                    if (drawerItem.getIdentifier() == 101) {
                        args.putString("id", "unit11.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 102) {
                        args.putString("id", "unit12.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 103) {
                        args.putString("id", "unit13.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 104) {
                        args.putString("id", "unit14.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();

                    }if (drawerItem.getIdentifier() == 105) {
                        args.putInt("unidade", quiz_unidade_1);
                        quiz = new Pergunta_quiz();
                        quiz.setArguments(args);
                        atividadePrincipal = false;
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, quiz).commit();
                    }
                        //////////////////////////////////////////////////UNIDADE 02 /////////////////////////////////////////////
                    if (drawerItem.getIdentifier() == 201) {
                        args.putString("id", "unit21.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 202) {
                        args.putString("id", "unit22.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 203) {
                        args.putString("id", "unit23.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 204) {
                        args.putString("id", "unit24.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 205) {
                        args.putString("id", "unit25.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 206) {
                        args.putString("id", "unit26.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 207) {
                        args.putString("id", "unit27.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 208) {
                        args.putString("id", "unit28.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 209) {
                        args.putString("id", "unit29.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 210) {
                        args.putString("id", "unit210.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 211) {
                        args.putString("id", "unit211.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 212) {//BANCO DE DADOS
                        args.putString("id", "unit212.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();

                    }if (drawerItem.getIdentifier() == 213) {
                        args.putInt("unidade", quiz_unidade_2);
                        quiz = new Pergunta_quiz();
                        quiz.setArguments(args);
                        atividadePrincipal = false;
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, quiz).commit();
                    }

                        //////////////////////////////////////////////////UNIDADE 03 /////////////////////////////////////////////

                    if (drawerItem.getIdentifier() == 301) {
                        args.putString("id", "unit31.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 302) {
                        args.putString("id", "unit32.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 303) {
                        args.putString("id", "unit33.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 304) {
                        args.putString("id", "unit34.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 305) {
                        args.putString("id", "unit35.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 306) {
                        args.putString("id", "unit36.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 307) {
                        args.putString("id", "unit37.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 308) {
                        args.putString("id", "unit38.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 309) {
                        args.putString("id", "unit39.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 310) {
                        args.putString("id", "unit310.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if (drawerItem.getIdentifier() == 311) {
//                        args.putInt("unidade", quiz_unidade_3);
                        args.putInt("unidade", quiz_unidade_geral);
                        quiz = new Pergunta_quiz();
                        quiz.setArguments(args);
                        atividadePrincipal = false;
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, quiz).commit();
                    }


                        ///////////////////////////////////UNIDADE 04///////////////////////////////////////////////

                    if (drawerItem.getIdentifier() == 401) {
                        args.putString("id", "unit41.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 402) {
                        args.putString("id", "unit42.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 403) {
                        args.putString("id", "unit43.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 404) {
                        args.putString("id", "unit44.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                        if (drawerItem.getIdentifier() == 405) {
//                            args.putInt("unidade", quiz_unidade_4);
                            args.putInt("unidade", quiz_unidade_geral);
                            quiz = new Pergunta_quiz();
                            quiz.setArguments(args);
                            atividadePrincipal = false;
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frame_container2, quiz).commit();
                        }

                        /////////////////////////////UNIDADE 05////////////////////
                    } if (drawerItem.getIdentifier() == 501) {
                        args.putString("id", "unit51.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 502) {
                        args.putString("id", "unit52.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 503) {
                        args.putString("id", "unit53.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 504) {
                        args.putString("id", "unit54.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if (drawerItem.getIdentifier() == 505) {
                        args.putString("id", "unit55.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        atividadePrincipal = false;
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();

                    }
                    if (drawerItem.getIdentifier() == 506) {
//                        args.putInt("unidade", quiz_unidade_5);
                        args.putInt("unidade", quiz_unidade_geral);
                        quiz = new Pergunta_quiz();
                        quiz.setArguments(args);
                        atividadePrincipal = false;
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, quiz).commit();
                    }
                    if (drawerItem.getIdentifier() == 2) {
                        //args.putInt repetir "unidade" e digitar quiz_unidade e escolher a constante da unidade -- novo
                        args.putInt("unidade", quiz_unidade_geral);
                        quiz = new Pergunta_quiz();
                        //setar o argumento antes -- novo
                        quiz.setArguments(args);
                        atividadePrincipal = false;
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, quiz).commit();
                    }
                if(drawerItem.getIdentifier() == 1){

                    iniciar();

                }

                return false;
            }
        }).
                withActionBarDrawerToggleAnimated(true).build();
    }

    public void popular_menu_assuntos() {
        Integer u1, u2, u3, u4, u5;
        u1 = 100;
        u2 = 200;
        u3 = 300;
        u4 = 400;
        u5 = 500;

        conteudos = new ArrayList<Conteudo>();
        Conteudo assuntos;// = new Conteudo();
        String s1 = "unit";
        String s2, temp, sfi;
        String sfinal = ".html";


        for (Map.Entry<String, List<String>> key : dadosGrupos.entrySet()) {
            String a = key.getKey();
            Log.i("Top", a);
            for (String c : key.getValue()) {
                if (a.equals("Unidade 1 - Conceitos Básicos")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u1);
                    unidade1.withSubItems(unidade_filho);

                    assuntos = new Conteudo();
                    assuntos.setConteudo(c);
                    temp = u1.toString();
                    s2 = temp.substring(2);
                    sfi = s1.concat("1") + s2 + sfinal;
                    Log.i("saida", sfi);
                    assuntos.setPagina(sfi);
                    conteudos.add(assuntos);

                } else if (a.equals("Unidade 2 - Linguagens Regulares")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u2);
                    unidade2.withSubItems(unidade_filho);

                    assuntos = new Conteudo();
                    assuntos.setConteudo(c);
                    temp = u2.toString();
                    s2 = temp.substring(2);
                    sfi = s1.concat("2") + s2 + sfinal;
                    Log.i("saida", sfi);
                    assuntos.setPagina(sfi);
                    conteudos.add(assuntos);
                } else if (a.equals("Unidade 3 - Gramática")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u3);
                    unidade3.withSubItems(unidade_filho);

                    assuntos = new Conteudo();
                    assuntos.setConteudo(c);
                    temp = u3.toString();
                    s2 = temp.substring(2);
                    sfi = s1.concat("3") + s2 + sfinal;
                    Log.i("saida", sfi);
                    assuntos.setPagina(sfi);
                    conteudos.add(assuntos);
                } else if (a.equals("Unidade 4 - Linguagens Livre do Contexto")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u4);
                    unidade4.withSubItems(unidade_filho);

                    assuntos = new Conteudo();
                    assuntos.setConteudo(c);
                    temp = u4.toString();
                    s2 = temp.substring(2);
                    sfi = s1.concat("4") + s2 + sfinal;
                    Log.i("saida", sfi);
                    assuntos.setPagina(sfi);
                    conteudos.add(assuntos);
                } else if (a.equals("Unidade 5 - Máquina de Turing")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u5);
                    unidade5.withSubItems(unidade_filho);
                }
            }
        }
    }

    @Override
    public boolean onQueryTextSubmit(String query) {
        //drawer.getOnDrawerItemClickListener().onItemClick(this, 0, dra);
        Log.i("b", query);
        //adapter.buscar(query);
        conteudos_resultado = new ArrayList<Conteudo>();
        conteudos_resultado = adapter.popular_assuntos(conteudos, query);

        resultado_fragment resultado = new resultado_fragment();
        args.putSerializable("lista", (Serializable) conteudos_resultado);
        resultado.setArguments(args);

        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container2, resultado);
        atividadePrincipal = false;
        fragmentTransaction.commit();

        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("b2", newText);
        return false;
    }


        @Override
        public void onBackPressed() {
            if (!atividadePrincipal) {
                iniciar();
            }
            else
            {
                new AlertDialog.Builder(this)
                        .setTitle("Deseja Sair?")
                        .setMessage("Voce deseja realmente sair?")
                        .setNegativeButton(R.string.nao, null)
                        .setPositiveButton(R.string.sim, new DialogInterface.OnClickListener() {


                            public void onClick(DialogInterface arg0, int arg1) {
                                finish();
                            }
                        }).create().show();
            }
        }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    public void iniciar() {
        atividadePrincipal = true;
        Tela_Apresentacao tela = new Tela_Apresentacao();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container2, tela).commit();
    }
}

