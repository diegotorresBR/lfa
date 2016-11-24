package com.uninorte.equipeprojeto.lfa;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class Fragmento_Resultado_Quiz extends Fragment {
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    private TextView textViewResultadoQuiz;
    int quantidade_questoes_certas=0;
    int total_de_questoes_padrao=0;
    int unidadeParametro;
    int media=0;//media para avaliar como foi o desempenho do usuário
    //
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    Bundle args;
    Pergunta_quiz fragmento_pergunta_quiz;
    private CharSequence mDrawerTitle;//Preciso falar?
    private CharSequence mTitle;
    //
//    private Button buttonRefazer;
//    private Button buttonInicio;
//    private Button buttonCompartilhar;
    private ImageButton imageButtonRefazer;
    private ImageButton imageButtonInicio;
    private ImageButton imageButtonCompartilhar;

    //
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_resultado_quiz, container, false);
        textViewResultadoQuiz = (TextView)view.findViewById(R.id.textViewResultadoQuiz);
//        buttonRefazer = (Button)view.findViewById(R.id.buttonRefazer);
//        buttonInicio = (Button) view.findViewById(R.id.buttonInicio);
//        buttonCompartilhar = (Button) view.findViewById(R.id.buttonCompartilhar);
        imageButtonRefazer = (ImageButton)view.findViewById(R.id.imageButtonIdRefazer);
        imageButtonInicio = (ImageButton) view.findViewById(R.id.imageButtonIdInicio);
        imageButtonCompartilhar = (ImageButton) view.findViewById(R.id.imageButtonIdCompartilhar);
        //
        args = new Bundle();
        fragmentManager = getFragmentManager();
        mDrawerTitle = getActivity().getTitle();
        //
        final Bundle a = getArguments();
        int res = a.getInt("id");//obtem o id da imagem do assunto selecionado
        quantidade_questoes_certas = a.getInt("quantidade_questoes_certas");
        total_de_questoes_padrao   = a.getInt("total_de_questoes_padrao");
        unidadeParametro = a.getInt("unidade");
        String acertos = " Você obteve "+quantidade_questoes_certas+" Acertos.";


        if (quantidade_questoes_certas == 0) {
            textViewResultadoQuiz.setText("Você não obteve acertos. Refaça o quiz." + acertos);
        }
        else if(quantidade_questoes_certas == total_de_questoes_padrao) {
            textViewResultadoQuiz.setText("Parabéns, você gabaritou o Quiz." + acertos);
        }

        int metade_do_total_de_questoes_padrao = total_de_questoes_padrao / 2;

        if (metade_do_total_de_questoes_padrao > quantidade_questoes_certas) {
            textViewResultadoQuiz.setText("Infelizmente você não foi aprovado desta vez. Tente novamente." + acertos);
        }
        else {
            textViewResultadoQuiz.setText("Parabéns, você foi aprovado neste Quiz. " + acertos);
        }
        //
//        buttonRefazer.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                args.putBoolean("refazer", true);
//                args.putInt("unidade", unidadeParametro);
//                fragmento_pergunta_quiz = new Pergunta_quiz();//é necesário instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
//                fragmento_pergunta_quiz.setArguments(args);
//                fragmentTransaction = fragmentManager.beginTransaction();
//                fragmentTransaction.replace(R.id.frame_container2, fragmento_pergunta_quiz).commit();
//            }
//        });
//        //
//        buttonInicio.setOnClickListener(new View.OnClickListener() {
//            @Override// este método direciona o usuário para o início da aplicação
//            public void onClick(View v) {
//                Intent intent = new Intent(getActivity(), MainActivity.class);
//                startActivity(intent);
//            }
//        });
//        //
//        buttonCompartilhar.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
//                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.quiz_geral));
//                sharingIntent.putExtra(Intent.EXTRA_TEXT, textViewResultadoQuiz.getText() );
//                sharingIntent.setType("text/plain");
//                startActivity(Intent.createChooser(sharingIntent, getString(R.string.compartilhar)));
//            }
//        });
        //
        imageButtonRefazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                args.putBoolean("refazer", true);
                args.putInt("unidade", unidadeParametro);
                fragmento_pergunta_quiz = new Pergunta_quiz();//é necesário instanciar um novo objeto pois ao usar o set abaixo, so eh possivel em um novo frag
                fragmento_pergunta_quiz.setArguments(args);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container2, fragmento_pergunta_quiz).commit();
            }
        });
        //
        imageButtonInicio.setOnClickListener(new View.OnClickListener() {
            @Override// este método direciona o usuário para o início da aplicação
            public void onClick(View v) {
                Tela_Apresentacao tela = new Tela_Apresentacao();
                args.putBoolean("atividadePrincipal", true);
                tela.setArguments(args);
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.frame_container2, tela).commit();

            }
        });
        //
        imageButtonCompartilhar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.quiz_geral));
                sharingIntent.putExtra(Intent.EXTRA_TEXT, textViewResultadoQuiz.getText() );
                sharingIntent.setType("text/plain");
                startActivity(Intent.createChooser(sharingIntent, getString(R.string.compartilhar)));
            }
        });
        return view;
    }
//    public void iniciar() {
//       // atividadePrincipal = true;
//       Tela_Apresentacao tela = new Tela_Apresentacao();
//        fragmentTransaction = fragmentManager.beginTransaction();
//        fragmentTransaction.replace(R.id.frame_container2, tela).commit();
//    }
    public Fragmento_Resultado_Quiz() {
        // Required empty public constructor
    }

    public static Fragmento_Resultado_Quiz newInstance(String param1, String param2) {
        Fragmento_Resultado_Quiz fragment = new Fragmento_Resultado_Quiz();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
