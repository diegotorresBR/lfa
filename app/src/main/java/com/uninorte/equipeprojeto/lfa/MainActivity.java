package com.uninorte.equipeprojeto.lfa;

import android.accounts.Account;
import android.app.AlertDialog;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
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
public class MainActivity extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private Toolbar toolbar;
    private DrawerLayout mDrawerLayout;//Menu Lateral
    private ExpandableListView mDrawerExpandableList;//Lista dos Subtopicos
    private ActionBarDrawerToggle mDrawerToggle;//Botao de Retorno do Drawer
    private CharSequence mDrawerTitle;//Preciso falar?
    private CharSequence mTitle;

    private List<String> grupos;//Conteudos
    private HashMap<String, List<String>> dadosGrupos;
    private int ultimaPosicionExpList = -1;
    private MyAdapter adapter;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle args;
    Assunto assunto_frag;
    AccountHeader header;
    ExpandableDrawerItem unidade1, unidade2, unidade3, unidade4, unidade5;
    SecondaryDrawerItem unidade_filho;
    Drawer drawer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo_main);

        //mDrawerTitle = getTitle();
        args = new Bundle();
        fragmentManager = getFragmentManager();


//
        toolbar = (Toolbar) findViewById(R.id.toolbar2);
        header = new AccountHeaderBuilder().withActivity(this).withTranslucentStatusBar(true).withHeaderBackground(R.drawable.side_nav_bar).build();
        carregarDados();
        criar_drawer();
//        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout2);
//        mDrawerExpandableList = (ExpandableListView) findViewById(R.id.explist_slidermenu3);
//        //mDrawerExpandableList.setGroupIndicator(null);
//
//        //
//       // View header = getLayoutInflater().inflate(R.layout.cabecera_general, null);
//       // mDrawerExpandableList.addHeaderView(header, null, false);
//        //...Fim da Pagina
//
//        carregarDados();
//
//        if (toolbar != null) {
//            toolbar.setTitle(mDrawerTitle);
//            toolbar.setSubtitle(mTitle);
//            toolbar.setLogo(R.mipmap.ic_lfa1);
            setSupportActionBar(toolbar);
//            getSupportActionBar().setDisplayShowHomeEnabled(true);
//            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
//        }
//
//        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {
//
//            @Override
//            public void onDrawerClosed(View view) {
//
//                getSupportActionBar().setTitle(mDrawerTitle);
//                getSupportActionBar().setSubtitle(mTitle);
//                invalidateOptionsMenu();
//            }
//
//            @Override
//            public void onDrawerOpened(View drawerView) {
//
//                getSupportActionBar().setTitle("Menu");
//                getSupportActionBar().setSubtitle("Selecione uma opção");
//                invalidateOptionsMenu();
//
//            }
//        };
//
//        mDrawerToggle.setDrawerIndicatorEnabled(true);//Mostrar icono menu animado
//        mDrawerLayout.setDrawerListener(mDrawerToggle);
//        mDrawerExpandableList.setTextFilterEnabled(true);
//        mDrawerExpandableList.setOnGroupClickListener(new ExpandableListView.OnGroupClickListener() {
//            @Override
//            public boolean onGroupClick(ExpandableListView parent, View v, int groupPosition, long id) {
//                return false;
//            }
//        });
//        mDrawerExpandableList.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {
//            @Override
//            public void onGroupExpand(int groupPosition) {
//                if (ultimaPosicionExpList != -1 && groupPosition != ultimaPosicionExpList) {
//                    mDrawerExpandableList.collapseGroup(ultimaPosicionExpList);
//                }
//                ultimaPosicionExpList = groupPosition;
//            }
//        });
//        mDrawerExpandableList.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {
//            @Override
//            public void onGroupCollapse(int groupPosition) {
//
//
//            }
//        });
//        mDrawerExpandableList.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
//
//            //Ao clicar em uma opcao no menu lateral, o app mostrara o assunto correspondete no fragment
//            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
//                int grup_pos = (int)adapter.getGroupId(groupPosition);
//                int subgrupo_pos = (int)adapter.getChildId(groupPosition, childPosition);
//                String selected = (String) adapter.getChild(groupPosition, childPosition);
//
//                {//e aqui eh onde a magia acontece. Ao escolher o assunto, o app mostra a imagem relacionada ao
//                    //assunto e preenche o fragment com a imagem do assunto
//                    switch (selected) {
//                        case "1.1.Introdução":
//
//                            break;
//                    }
//                }if(grup_pos == 1) {
//                    switch (subgrupo_pos) {
//                        case 0:
//
//                            args.putInt("id", R.drawable.u2_1);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
//                            mDrawerTitle = "2.1.Introdução";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 1:
//                            args.putInt("id", R.drawable.u2_2);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
//                            mDrawerTitle = "2.2.Sistemas de Estados Finitos";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 2:
//                            args.putInt("id", R.drawable.u2_3);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container, assunto_frag).commit();
//                            mDrawerTitle = "2.3.Composição Sequencia | Corrente não Deterministica";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 3:
//                            args.putInt("id", R.drawable.u2_4);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container, assunto_frag).commit();
//                            mDrawerTitle = "2.4.Automato Finito";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 4:
//                            args.putInt("id", R.drawable.u2_5);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container, assunto_frag).commit();
//                            mDrawerTitle = "2.5.Automato Finito Deterministico";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 5:
//                            args.putInt("id", R.drawable.u2_6);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container, assunto_frag).commit();
//                            mDrawerTitle = "2.6 Definição da Função Programa Estendida";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 6:
//                            args.putInt("id", R.drawable.u2_7);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container, assunto_frag).commit();
//                            mDrawerTitle = "2.7.Linguagem aceita e linguagem rejeitada";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 7:
//                            args.putInt("id", R.drawable.u2_8);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container, assunto_frag).commit();
//                            mDrawerTitle = "2.8.Automatos finitos equivalentes";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 8:
//                            args.putInt("id", R.drawable.u2_9);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container, assunto_frag).commit();
//                            mDrawerTitle = "2.9.Automatos finitos Não-deterministico";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 9:
//                            Toast.makeText(getApplicationContext(), "2.10.Automatos com Movimentos Vazios", Toast.LENGTH_SHORT).show();
//                            mDrawerTitle = "2.10.Automatos com Movimentos Vazios";
//                            mTitle = "Unidade 2";
//                            break;
//                        case 10:
//                            Toast.makeText(getApplicationContext(), "2.11.Linguagem regular", Toast.LENGTH_SHORT).show();
//                            mDrawerTitle = "2.11.Linguagem regular";
//                            mTitle = "Unidade 2";
//                            break;
//
//                        default:
//                            break;
//                    }
//
//                }
//                if(grup_pos == 2) {
//                    switch (subgrupo_pos) {
//                        case 0:
//                            args.putInt("id", R.drawable.u3_1);//passa para o fragment o id do assunto
//                            assunto_frag = new Assunto();
//                            assunto_frag.setArguments(args);
//                            fragmentTransaction = fragmentManager.beginTransaction();
//                            fragmentTransaction.replace(R.id.frame_container, assunto_frag).commit();
//                            mDrawerTitle = "Gramatica Formal";
//                            mTitle = "Unidade 3";
//                            break;
//                        case 1:
//                            Toast.makeText(getApplicationContext(), "Rubro Negra", Toast.LENGTH_SHORT).show();
//                            mDrawerTitle = "Arvores";
//                            mTitle = "Rubro Negra";
//                            break;
//
//                        case 2:
//                            Toast.makeText(getApplicationContext(), "Arvore B", Toast.LENGTH_SHORT).show();
//                            mDrawerTitle = "Arvores";
//                            mTitle = "Arvore B";
//                            break;
//
//                        default:
//                            break;
//                    }
//
//                }
//                if(grup_pos == 3) {
//
//                    switch (subgrupo_pos) {
//                        case 0:
//                            Toast.makeText(getApplicationContext(), "Busca em Largura", Toast.LENGTH_SHORT).show();
//                            mDrawerTitle = "Grafos";
//                            mTitle = "Busca em Largura";
//                            break;
//                        case 1:
//                            Toast.makeText(getApplicationContext(), "Busca em Profundidade", Toast.LENGTH_SHORT).show();
//                            mDrawerTitle = "Grafos";
//                            mTitle = "Busca em Profundidade";
//                            break;
//
//                        case 2:
//                            Toast.makeText(getApplicationContext(), "Dijkstra", Toast.LENGTH_SHORT).show();
//                            mDrawerTitle = "Grafos";
//                            mTitle = "Dijkstra";
//                            break;
//
//                        case 3:
//                            Toast.makeText(getApplicationContext(), "Prim", Toast.LENGTH_SHORT).show();
//                            mDrawerTitle = "Grafos";
//                            mTitle = "Prim";
//                            break;
//                        default:
//                            break;
//                    }
//
//                }
////                mDrawerLayout.closeDrawer(mDrawerExpandableList);
//                return false;
//            }
//        });
//
//
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


        List<String> filhos_grupo4 = new ArrayList<String>();
        filhos_grupo4.add("4.1.Aplicações");
        filhos_grupo4.add("4.2.Automato com Pilha");
        filhos_grupo4.add("4.3.Gramática Livre do Contexto");
        filhos_grupo4.add("4.4.Algoritmos de Reconhecimento");


        List<String> filhos_grupo5 = new ArrayList<String>();
        filhos_grupo5.add("5.1.Definição");
        filhos_grupo5.add("5.2.Modelo");
        filhos_grupo5.add("5.3.Definição formal");
        filhos_grupo5.add("5.4.Processamento");
        filhos_grupo5.add("5.5.Decidibilidade");


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
                finish();
                break;
            default:
                break;
        }
        return true;
    }

//    @Override
//    protected void onPostCreate(Bundle savedInstanceState) {
//        super.onPostCreate(savedInstanceState);
//        mDrawerToggle.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        mDrawerToggle.onConfigurationChanged(newConfig);
//    }
//
//    public boolean onKeyDown (int keycode, KeyEvent event){
//        if (keycode == KeyEvent.KEYCODE_MENU) {
//
//            if (mDrawerLayout.isDrawerOpen(Gravity.LEFT)) {
//                mDrawerLayout.closeDrawer(Gravity.LEFT);
//            } else {
//                mDrawerLayout.openDrawer(Gravity.LEFT);
//            }
//            return true;
//        }else{
//            return super.onKeyDown(keycode, event);
//        }
//    }
//
//    @Override
//    public void onBackPressed() {
//
//        if(mDrawerLayout.isDrawerOpen(Gravity.LEFT)){
//            mDrawerLayout.closeDrawer(Gravity.LEFT);
//        }else{
//            super.onBackPressed();
//        }
//    }

    public void criar_drawer(){
        unidade1 = new ExpandableDrawerItem().withName("Conceitos Basicos");
        unidade2 = new ExpandableDrawerItem().withName("Linguagens Regulares");
        unidade3 = new ExpandableDrawerItem().withName("Gramatica");
        unidade4 = new ExpandableDrawerItem().withName("Linguagens Livre do Contexto");
        unidade5 = new ExpandableDrawerItem().withName("Maquina de Turing");


//
//        SecondaryDrawerItem uni1_1 = new SecondaryDrawerItem().withName("Introducao").withLevel(2).withIdentifier(101);
//        SecondaryDrawerItem uni1_2 = new SecondaryDrawerItem().withName("Formalismo").withLevel(2).withIdentifier(102);
//        SecondaryDrawerItem uni1_3 = new SecondaryDrawerItem().withName("Conceitos de Alfabeto e Gramatica").withLevel(2).withIdentifier(103);
//        SecondaryDrawerItem uni1_4 = new SecondaryDrawerItem().withName("Liguagem Formal").withLevel(2).withIdentifier(104);

        //unidade1.withSubItems(uni1_1, uni1_2, uni1_3, uni1_4);

popular_menu_assuntos();

        drawer = new DrawerBuilder().withActivity(this).withToolbar(toolbar).
                withAccountHeader(header).
                addDrawerItems(
                        new PrimaryDrawerItem().withName("Inicio").withDescription("Comece Aqui").withIdentifier(1).withSelectable(true),
                        new SectionDrawerItem().withName("Aprender"),
                        unidade1, unidade2, unidade3, unidade4, unidade5
                ).withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener(){


            @Override
            public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {

                if(drawerItem != null){
                    if(drawerItem.getIdentifier() == 101){
                        args.putString("id", "unit11.html");//passa para o fragment o id do assunto
                            assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                            assunto_frag.setArguments(args);
                            fragmentTransaction = fragmentManager.beginTransaction();
                            fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 102){
                        args.putString("id", "unit12.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 103){
                        args.putString("id", "unit13.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 104){
                        args.putString("id", "unit14.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 201){
                        args.putString("id", "unit21.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 202){
                        args.putString("id", "unit22.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 203){
                        args.putString("id", "unit23.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 204){
                        args.putString("id", "unit24.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 205){
                        args.putString("id", "unit25.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 206){
                        args.putString("id", "unit26.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 207){
                        args.putString("id", "unit27.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                    if(drawerItem.getIdentifier() == 208){
                        args.putString("id", "unit28.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 209){
                        args.putString("id", "unit29.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 301){
                        args.putString("id", "unit30.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 302){
                        args.putString("id", "unit31.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 303){
                        args.putString("id", "unit32.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 304){
                        args.putString("id", "unit33.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 305){
                        args.putString("id", "unit34.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 306){
                        args.putString("id", "unit35.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 307){
                        args.putString("id", "unit36.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 308){
                        args.putString("id", "unit37.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 309){
                        args.putString("id", "unit38.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 310){
                        args.putString("id", "unit39.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 401){
                        args.putString("id", "unit41.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 402){
                        args.putString("id", "unit42.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 403){
                        args.putString("id", "unit43.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }if(drawerItem.getIdentifier() == 404){
                        args.putString("id", "unit44.html");//passa para o fragment o id do assunto
                        assunto_frag = new Assunto();//eh necesario instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                        assunto_frag.setArguments(args);
                        fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.frame_container2, assunto_frag).commit();
                    }
                }

                return false;
            }
        }).
                build();

    }

    public void popular_menu_assuntos(){
        int u1, u2, u3, u4, u5;
        u1 = 100;
        u2 = 200;
        u3 = 300;
        u4 = 400;
        u5 = 500;
        for(Map.Entry<String, List<String>> key : dadosGrupos.entrySet()){
            String a = key.getKey();
            Log.i("Top", a);
            for(String c : key.getValue()) {
                if (a.equals("Unidade 1 - Conceitos Básicos")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u1);
                    unidade1.withSubItems(unidade_filho);
                } else if (a.equals("Unidade 2 - Linguagens Regulares")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u2);
                    unidade2.withSubItems(unidade_filho);
                } else if (a.equals("Unidade 3 - Gramática")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u3);
                    unidade3.withSubItems(unidade_filho);
                } else if (a.equals("Unidade 4 - Linguagens Livre do Contexto")) {
                    unidade_filho = new SecondaryDrawerItem().withName(c).withLevel(2).withIdentifier(++u4);
                    unidade4.withSubItems(unidade_filho);
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
        adapter.buscar(query);
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        Log.i("b2", newText);
        return false;
    }

    @Override
    public void onBackPressed() {
        //POPUP AO SAIR DA APLICACAO
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sair?");
        builder.setMessage("Deseja realmente sair?");
        builder.setPositiveButton("SIM" , new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0 , int arg1){
                finish();
            }

        });

        builder.setNegativeButton("NÃO" , new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface arg0 , int arg1) {
            }
        });

        AlertDialog alerta = builder.create();
        alerta.show();

//
//        if(mDrawerLayout.isDrawerOpen(Gravity.LEFT)){
//            mDrawerLayout.closeDrawer(Gravity.LEFT);
//        }else{
//            super.onBackPressed();
//        }
    }
}
