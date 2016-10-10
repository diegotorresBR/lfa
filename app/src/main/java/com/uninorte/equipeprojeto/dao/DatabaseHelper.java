package com.uninorte.equipeprojeto.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.uninorte.equipeprojeto.model.Unidade;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String BANCO_DADOS = "lfa";
    private static final int VERSAO = 1;

    public DatabaseHelper(Context context) {
        super(context, BANCO_DADOS, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //tabelas unidade
        db.execSQL("create table unidade (" +
                "    _id integer integer not null" +
                "    , txt_titulo text not null" +
                "    , txt_descricao text not null" +
                ")");
        //tabela perguntas
        db.execSQL("create table perguntas (" +
                "    _id integer not null " +
                "    , txt_pergunta text not null" +
                "    , id_unidade text not null" +
                ")");
        //tabela respostas
        db.execSQL("create table respostas (" +
                "    _id integer primary key autoincrement" +
                "    , txt_resposta text not null" +
                "    , flag_verdadeiro boolean not null" +
                "    , id_pergunta integer not null" +
                ")");
        // inserts da tabela unidades
        db.execSQL("insert into unidade(_id, txt_titulo, txt_descricao) values (1, 'Unidade 1', 'Unidade 1 é referente a Conceitos Básicos')");
        db.execSQL("insert into unidade(_id, txt_titulo, txt_descricao) values (2, 'Unidade 2', 'Unidade 2 é referente a Linguagens Regulares')");
        db.execSQL("insert into unidade(_id, txt_titulo, txt_descricao) values (3, 'Unidade 3', 'Unidade 3 é referente a Gramática')");
        db.execSQL("insert into unidade(_id, txt_titulo, txt_descricao) values (4, 'Unidade 4', 'Unidade 4 é referente a Gramática Livre do Contexto')");
        db.execSQL("insert into unidade(_id, txt_titulo, txt_descricao) values (5, 'Unidade 5', 'Unidade 5 é referente a Máquina de Turing')");
//        insert da tabela perguntas
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (1, '1', 'Quem roeu a rede do rei de roma?')");
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (2, '1', 'E o pintinho?')");
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (3, '1', 'O que significa LFA?')");
//        inserts da tabela resposta
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Rato'    , 'true' , '1')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Gato'    , 'false', '1')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Cachorro', 'false', '1')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Leão'    , 'false', '1')");

        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Piu'  , 'true' , '2')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Au Au', 'false', '2')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Beeh' , 'false', '2')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Miau' , 'false', '2')");

        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Linguagens Formais e Autômatos', 'true' , '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Inteligência Artificial'       , 'false', '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Matemática'                    , 'false', '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Português'                     , 'false', '3')");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { }

    public static class Unidade {
        public static final String TABELA = "unidade";
        public static final String _ID = "_id";
        public static final String TITULO = "txt_titulo";
        public static final String DESCRICAO = "txt_descricao";
        //
        public static final String[] COLUNAS = new String[]{
                _ID, TITULO, DESCRICAO
        };
    }

    public static class Perguntas {
        public static final String TABELA = "perguntas";
        public static final String _ID = "_id";
        public static final String TXT_PERGUNTA = "txt_pergunta";
        public static final String ID_UNIDADE = "id_unidade";
        //
        public static final String[] COLUNAS = new String[]{
                _ID, TXT_PERGUNTA, ID_UNIDADE
        };
    }

    public static class Respostas {
        public static final String TABELA = "respostas";
        public static final String _ID = "_id";
        public static final String TXT_RESPOSTA = "txt_resposta";
        public static final String FLAG_VERDADEIRO = "flag_verdadeiro";
        public static final String ID_PERGUNTA = "id_pergunta";
        //
        public static final String[] COLUNAS = new String[]{
                _ID, TXT_RESPOSTA, FLAG_VERDADEIRO, ID_PERGUNTA
        };
    }

}
