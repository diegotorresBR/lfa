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
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.uninorte.equipeprojeto.adapter.PerguntaAdapter;
import com.uninorte.equipeprojeto.adapter.RespostaAdapter;
import com.uninorte.equipeprojeto.dao.PerguntaDAO;
import com.uninorte.equipeprojeto.dao.RespostaDAO;
import com.uninorte.equipeprojeto.model.Pergunta;
import com.uninorte.equipeprojeto.model.Resposta;
import com.uninorte.equipeprojeto.util.Mensagem;
import java.util.List;

public class Pergunta_quiz extends Fragment {
    //
    private RadioGroup radioGroup;
    private RadioButton radioButtonletraA
                        , radioButtonletraB
                        , radioButtonletraC
                        , radioButtonletraD;
    private boolean respostaCertaA,respostaCertaB,respostaCertaC,respostaCertaD=false;
    private Button buttonProximo, buttonCancelar;
    private TextView textViewPergunta;
    //
    private ListView lista;
    private List<Pergunta> perguntaList;
    private List<Resposta> respostaList;
    //
    private PerguntaAdapter perguntaAdapter;
    private PerguntaDAO perguntaDAO;
    //
    private RespostaAdapter respostaAdapter;
    private RespostaDAO respostaDAO;
    //
    //Contador de perguntas. Serve para contar qual é a vez em que a pergunta está sendo realizada.
    //É setado o valor 0 para identificar que é a primeira vez em que é realizada a pergunta.
    int contadorPergunta             = 0;
    int contadorDeQuestoesCertas     = 0;//indica a quantidade de perguntas acertadas pelo usuário
    int total_de_questoes_padrao     = 12;
    //
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle args;
    Fragmento_Resultado_Quiz fragmento_resultado_quiz;
    private CharSequence mDrawerTitle;//Preciso falar?
    private CharSequence mTitle;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Infla o layout para este fragment
        final View view = inflater.inflate(R.layout.fragment_pergunta_quiz, container, false);
        //
        args = new Bundle();
        fragmentManager = getFragmentManager();
        mDrawerTitle = getActivity().getTitle();
        //
        textViewPergunta  = (TextView)    view.findViewById(R.id.textViewPergunta);
        radioButtonletraA = (RadioButton) view.findViewById(R.id.letraA);
        radioButtonletraB = (RadioButton) view.findViewById(R.id.letraB);
        radioButtonletraC = (RadioButton) view.findViewById(R.id.letraC);
        radioButtonletraD = (RadioButton) view.findViewById(R.id.letraD);
        radioGroup        = (RadioGroup)  view.findViewById(R.id.radioGroup);
        //
        buttonProximo = (Button) view.findViewById(R.id.buttonProximo);
        buttonCancelar =(Button) view.findViewById(R.id.buttonCancelar);
        //inicializa a variavel perguntaDAO com toda a instancia do banco de dados da tabela Pergunta.
        perguntaDAO  = new PerguntaDAO(getActivity());
        //carrega a variavel perguntaList com todas as perguntas.a
        perguntaList = perguntaDAO.ListarPergunta();
        // perguntaAdapter =  new PerguntaAdapter(getActivity(), perguntaList);
        //

        for (Pergunta perg : perguntaList) {

            //aqui é realizado o teste
            if (contadorPergunta == 0) {
                textViewPergunta.setText(perg.getTxt_pergunta());
                respostaDAO = new RespostaDAO(getActivity());
                respostaList = respostaDAO.ListarRespostaPorId(perg.get_id());
                int contador = 0;

                for (Resposta resp : respostaList) {
                    switch (contador) {
                        case 0:
                            radioButtonletraA.setText(resp.getTxt_resposta());
                            contador++;
                            contadorPergunta++;
                            if (resp.getFlag_verdadeiro().toString().equals("true")) {
                                marcarRespostaCerta(true, false, false, false);
                            }
                            continue;
                        case 1:
                            radioButtonletraB.setText(resp.getTxt_resposta());
                            contador++;
                            if (resp.getFlag_verdadeiro().toString().equals("true")) {
                                marcarRespostaCerta(false, true, false, false);
                            }
                            continue;
                        case 2:
                            radioButtonletraC.setText(resp.getTxt_resposta());
                            contador++;
                            if (resp.getFlag_verdadeiro().toString().equals("true")) {
                                marcarRespostaCerta(false, false, true, false);
                            }
                            continue;
                        case 3:
                            radioButtonletraD.setText(resp.getTxt_resposta());
                            contador++;
                            if (resp.getFlag_verdadeiro().toString().equals("true")) {
                                marcarRespostaCerta(false, false, false, true);
                            }
                            continue;
                    }
                }
            }
        }

        //
//        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(RadioGroup group, int checkedId) {
//                switch (checkedId) {
//                    case R.id.letraA:
//                        Mensagem.Msg(getActivity(), "letra A");
//                        break;
//                    case R.id.letraB:
//                        Mensagem.Msg(getActivity(), "letra B");
//                        break;
//                    case R.id.letraC:
//                        Mensagem.Msg(getActivity(), "letra C");
//                        break;
//                    case R.id.letraD:
//                        Mensagem.Msg(getActivity(), "letra D");
//                        break;
//                }
//            }
//        });
        //
        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //neste bloco é validado qual opção foi selecionada pelo usuário
                int idSelecionado = radioGroup.getCheckedRadioButtonId();
                switch (idSelecionado) {
                    case R.id.letraA:
                        if (respostaCertaA) {
                            contadorDeQuestoesCertas++;
//                            Mensagem.MsgCurta(getActivity(), getString(R.string.resposta_correta));
//                        } else {
//                            Mensagem.MsgCurta(getActivity(), getString(R.string.resposta_errada));
                        }
                        break;
                    case R.id.letraB:
                        if (respostaCertaB) {
                            contadorDeQuestoesCertas++;
//                            Mensagem.MsgCurta(getActivity(), getString(R.string.resposta_correta));
//                        } else {
//                            Mensagem.MsgCurta(getActivity(), getString(R.string.resposta_errada));
                        }
                        break;
                    case R.id.letraC:
                        if (respostaCertaC) {
                            contadorDeQuestoesCertas++;
//                            Mensagem.MsgCurta(getActivity(), getString(R.string.resposta_correta));
//                        } else {
//                            Mensagem.MsgCurta(getActivity(), getString(R.string.resposta_errada));
                        }
                        break;
                    case R.id.letraD:
                        if (respostaCertaD) {
                            contadorDeQuestoesCertas++;
//                            Mensagem.MsgCurta(getActivity(), getString(R.string.resposta_correta));
//                        } else {
//                            Mensagem.MsgCurta(getActivity(), getString(R.string.resposta_errada));
                        }
                        break;
                }

                carregarPergunta(perguntaList);

            }
        });


        buttonCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MainActivity.class);
                startActivity(intent);
            }
        });

        return view;
    }

    private void marcarRespostaCerta(boolean a, boolean b, boolean c, boolean d) {
        respostaCertaA = a;
        respostaCertaB = b;
        respostaCertaC = c;
        respostaCertaD = d;
    }

    private void carregarPergunta(List<Pergunta> listaPergunta) {

        int contadorPosicaoAtual  = 0;//posicao atual da pergunta
        int contadorResposta      = 0;//posicao da resposta

        for (Pergunta perg : listaPergunta)
        {
            contadorPosicaoAtual++;//incrementa a posicao atual da pergunta.
            /*
            12 está definindo diretamente o numero de questões que irão aparecer no quiz
             */

            if (contadorPosicaoAtual > total_de_questoes_padrao)
            {//TODO: Ao entrar nesta condição, o usuário é redirecionado para a tela de Resultado do Quiz.
                args.putInt("id", R.drawable.u2_1);//passa para o fragment o id do assunto
                args.putInt("quantidade_questoes_certas", contadorDeQuestoesCertas);
                args.putInt("total_de_questoes_padrao", total_de_questoes_padrao);
                fragmento_resultado_quiz = new Fragmento_Resultado_Quiz();//é necesário instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                fragmento_resultado_quiz.setArguments(args);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container, fragmento_resultado_quiz).commit();
                mDrawerTitle = getString(R.string.quiz);
               // mTitle = getString(R.string.resultado_quiz);
                return;
            }
            //
            if (contadorPosicaoAtual > contadorPergunta)
            {
                radioButtonletraA.setChecked(true);// setar sempre a letra A
                textViewPergunta.setText(perg.getTxt_pergunta());
                respostaDAO  = new RespostaDAO(getActivity());
                respostaList = respostaDAO.ListarRespostaPorId(perg.get_id());
                for (Resposta resp : respostaList)
                {
                    switch (contadorResposta)
                    {
                        case 0:
                            radioButtonletraA.setText(resp.getTxt_resposta());
                            contadorResposta++;
                            contadorPergunta++;
                            if (resp.getFlag_verdadeiro().toString().equals("true")) {
                                marcarRespostaCerta(true, false, false, false);
                            }
                            continue;
                        case 1:
                            radioButtonletraB.setText(resp.getTxt_resposta());
                            contadorResposta++;
                            if (resp.getFlag_verdadeiro().toString().equals("true")) {
                                marcarRespostaCerta(false, true, false, false);
                            }
                            continue;
                        case 2:
                            radioButtonletraC.setText(resp.getTxt_resposta());
                            contadorResposta++;
                            if (resp.getFlag_verdadeiro().toString().equals("true")) {
                                marcarRespostaCerta(false, false, true, false);
                            }
                            continue;
                        case 3:
                            radioButtonletraD.setText(resp.getTxt_resposta());
                            contadorResposta++;
                            if (resp.getFlag_verdadeiro().toString().equals("true")) {
                                marcarRespostaCerta(false, false, false, true);
                            }
                            return;
                    }
                }
                contadorPosicaoAtual++;//incrementa a posicao atual da pergunta.
            }
        }
    }
}