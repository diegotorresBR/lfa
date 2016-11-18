package com.uninorte.equipeprojeto.lfa;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import com.uninorte.equipeprojeto.adapter.PerguntaAdapter;
import com.uninorte.equipeprojeto.adapter.RespostaAdapter;
import com.uninorte.equipeprojeto.dao.PerguntaDAO;
import com.uninorte.equipeprojeto.dao.RespostaDAO;
import com.uninorte.equipeprojeto.model.Pergunta;
import com.uninorte.equipeprojeto.model.Resposta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Pergunta_quiz extends Fragment {
    // Instancias e Variaveis
    private RadioGroup radioGroup;
    private RadioButton radioButtonletraA
                        , radioButtonletraB
                        , radioButtonletraC
                        , radioButtonletraD
                        , radioButtonletraE;
    private boolean respostaCertaA
                        , respostaCertaB
                        , respostaCertaC
                        , respostaCertaD
                        , respostaCertaE = false;
//    private Button buttonProximo, buttonCancelar;
    private ImageButton imageButtonIdProximo, imageButtonIdCancelar;
    private TextView textViewPergunta;
    private ScrollView scrollViewPergunta;
    //
    private ListView lista;
    private List<Pergunta> perguntaList;
    private List<Resposta> respostaList;
    private PerguntaAdapter perguntaAdapter;
    private PerguntaDAO perguntaDAO;
    private RespostaAdapter respostaAdapter;
    private RespostaDAO respostaDAO;
    //Contador de perguntas. Serve para contar qual é a vez em que a pergunta está sendo realizada.
    //É setado o valor 0 para identificar que é a primeira vez em que é realizada a pergunta.
    int contadorPergunta             = 0;
    int contadorDeQuestoesCertas     = 0;//indica a quantidade de perguntas acertadas pelo usuário
    public static final int total_de_questoes_padrao = 10; //indica a quantidade de questões serão utilizadas no quiz
    //
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle args;
    Fragmento_Resultado_Quiz fragmento_resultado_quiz;
    private CharSequence mDrawerTitle;
    private CharSequence mTitle;
    int unidadeParametro;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla o layout para este fragment
        final View view = inflater.inflate(R.layout.fragment_pergunta_quiz, container, false);
        //
        args = new Bundle();
        final Bundle bundle = getArguments();
        unidadeParametro = bundle.getInt("unidade");
        //
        fragmentManager = getFragmentManager();
        mDrawerTitle = getActivity().getTitle();
        //Binding's
        textViewPergunta  = (TextView)    view.findViewById(R.id.textViewPergunta);
        radioButtonletraA = (RadioButton) view.findViewById(R.id.letraA);
        radioButtonletraB = (RadioButton) view.findViewById(R.id.letraB);
        radioButtonletraC = (RadioButton) view.findViewById(R.id.letraC);
        radioButtonletraD = (RadioButton) view.findViewById(R.id.letraD);
        radioButtonletraE = (RadioButton) view.findViewById(R.id.letraE);
        radioGroup        = (RadioGroup)  view.findViewById(R.id.radioGroup);
//        buttonProximo     = (Button) view.findViewById(R.id.buttonProximo);
//        buttonCancelar    = (Button) view.findViewById(R.id.buttonCancelar);
        imageButtonIdCancelar = (ImageButton) view.findViewById(R.id.imageButtonIdCancelar);
        imageButtonIdProximo = (ImageButton) view.findViewById(R.id.imageButtonIdProximo);
        scrollViewPergunta = (ScrollView)view.findViewById(R.id.idScrollViewPergunta);
        //carrega as perguntas de acordo com o parametro
        carregarPerguntasAleatorias(unidadeParametro);
        //
//        buttonProximo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                contarQuestoesCertas();
//                carregarPerguntasAleatorias(unidadeParametro);
//            }
//        });
//        buttonCancelar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent intent = new Intent(getActivity(), MainActivity.class);
////                startActivity(intent);
//            }
//        });
        imageButtonIdProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contarQuestoesCertas();
                carregarPerguntasAleatorias(unidadeParametro);
            }
        });
        //
        imageButtonIdCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irParaInicio();
            }
        });

        return view;
    }

    public void irParaInicio()
    {
        Tela_Apresentacao tela = new Tela_Apresentacao();
        args.putBoolean("atividadePrincipal", true);
        tela.setArguments(args);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_container2, tela).commit();
    }

    public void contarQuestoesCertas()
    {
        //neste bloco é validado qual opção foi selecionada pelo usuário
        int idSelecionado = radioGroup.getCheckedRadioButtonId();
        switch (idSelecionado) {
            case R.id.letraA:
                if (respostaCertaA) {
                    contadorDeQuestoesCertas++;
                }
                break;
            case R.id.letraB:
                if (respostaCertaB) {
                    contadorDeQuestoesCertas++;
                }
                break;
            case R.id.letraC:
                if (respostaCertaC) {
                    contadorDeQuestoesCertas++;
                }
                break;
            case R.id.letraD:
                if (respostaCertaD) {
                    contadorDeQuestoesCertas++;
                }
                break;
            case R.id.letraE:
                if (respostaCertaE) {
                    contadorDeQuestoesCertas++;
                }
                break;
        }
    }

    private void marcarRespostaCerta(boolean a, boolean b, boolean c, boolean d, boolean e)
    {
        respostaCertaA = a;
        respostaCertaB = b;
        respostaCertaC = c;
        respostaCertaD = d;
        respostaCertaE = e;
    }

    private void carregarPerguntasAleatorias(int idUnidade)
    {
        /*            12 está definindo diretamente o numero de questões que irão aparecer no quiz             */
        if (contadorPergunta > total_de_questoes_padrao)
        {//TODO: Ao entrar nesta condição, o usuário é redirecionado para a tela de Resultado do Quiz.
            args.putInt("quantidade_questoes_certas", contadorDeQuestoesCertas);
            args.putInt("total_de_questoes_padrao", total_de_questoes_padrao);
            args.putInt("unidade", idUnidade);
            fragmento_resultado_quiz = new Fragmento_Resultado_Quiz();//é necesário instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
            fragmento_resultado_quiz.setArguments(args);
            fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.frame_container2, fragmento_resultado_quiz).commit();
            return;
        }
        //inicializa a variavel perguntaDAO com toda a instancia do banco de dados da tabela Pergunta.
        perguntaDAO = new PerguntaDAO(getActivity());
        if (idUnidade == 0) {//se idUnidade for igual a 0, traz todos as perguntas da base de dados
            perguntaList = perguntaDAO.ListarPergunta();
        } else {//carrega a variavel perguntaList com todas as perguntas.a
            perguntaList = perguntaDAO.ListarPerguntaPorUnidade(idUnidade);
        }
        //
        Collections.shuffle(perguntaList);//a funcao Collections.shuffle embaralha a lista de pergunta
        //
        radioButtonletraA.setChecked(true);// setar sempre a letra A
        textViewPergunta.setText(perguntaList.get(0).getTxt_pergunta());//define a pergunta
        carregarRespostasAleatorias(perguntaList.get(0).get_id());//carrega as respostas para a pergunta de forma aleatoria
        contadorPergunta++;
        scrollViewPergunta.scrollTo(0, 0);//leva o scrollViewPergunta para o topo
    }

    private void carregarRespostasAleatorias(int idPergunta)
    {
        respostaDAO  = new RespostaDAO(getActivity());
        respostaList = respostaDAO.ListarRespostaPorIDPergunta(idPergunta);
        int contador = 0;//variavel responsavel por setar os radios button
        Collections.shuffle(respostaList);//a funcao Collections.shuffle embaralha a lista de resposta
        //
        for (Resposta resp : respostaList) {
            switch (contador) {
                case 0:
                    radioButtonletraA.setText(resp.getTxt_resposta());
                    contador++;
                    if (resp.getFlag_verdadeiro().toString().equals("true")) {
                        marcarRespostaCerta(true, false, false, false, false);
                    }
                    break;
                case 1:
                    radioButtonletraB.setText(resp.getTxt_resposta());
                    contador++;
                    if (resp.getFlag_verdadeiro().toString().equals("true")) {
                        marcarRespostaCerta(false, true, false, false, false);
                    }
                    break;
                case 2:
                    radioButtonletraC.setText(resp.getTxt_resposta());
                    contador++;
                    if (resp.getFlag_verdadeiro().toString().equals("true")) {
                        marcarRespostaCerta(false, false, true, false, false);
                    }
                    break;
                case 3:
                    radioButtonletraD.setText(resp.getTxt_resposta());
                    contador++;
                    if (resp.getFlag_verdadeiro().toString().equals("true")) {
                        marcarRespostaCerta(false, false, false, true, false);
                    }
                    break;
                case 4:
                    radioButtonletraE.setText(resp.getTxt_resposta());
                    contador++;
                    if (resp.getFlag_verdadeiro().toString().equals("true")) {
                        marcarRespostaCerta(false, false, false, false, true);
                    }
                    break;
            }
        }

    }
}