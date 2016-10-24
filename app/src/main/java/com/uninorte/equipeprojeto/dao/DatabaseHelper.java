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
//        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (1, '1', 'Quem roeu a rede do rei de roma?')");
//        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (2, '1', 'E o pintinho?')");
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (3, '1', 'O que significa LFA?')");

//        inserts da tabela resposta
//        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Rato'    , 'true' , '1')");
//        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Gato'    , 'false', '1')");
//        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Cachorro', 'false', '1')");
//        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Leão'    , 'false', '1')");
//
//        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Piu'  , 'true' , '2')");
//        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Au Au', 'false', '2')");
//        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Beeh' , 'false', '2')");
//        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Miau' , 'false', '2')");

        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Linguagens Formais e Autômatos', 'true' , '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Inteligência Artificial'       , 'false', '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Matemática'                    , 'false', '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Português'                     , 'false', '3')");
//-----------------------------------------------------------------------------------------------------------------------------------
        // insert de pergunta reais enviadas pelo grupo
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (4, '2', 'O que significa dizer que dois estados de um autômato finito são equivalentes?')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS em cada um desses estados são idênticos.'                  , 'true' , '4')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS em cada um desses estados são parecidos.'                  , 'false' , '4')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS separados estados.'                                        , 'false' , '4')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias REJEITADAS em cada um desses estados são idênticos.'               , 'false' , '4')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS e REJEITADAS em cada um desses estados são idênticos.'     , 'false' , '4')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (5, '2', 'Formalmente, gramáticas são dispositivos para geração de sentenças de uma dada linguagem. Então definida como Quartupla:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, P, S).' , 'true'  , '5')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, S, P, S).' , 'false' , '5')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, S, P).' , 'false' , '5')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, T, S).' , 'false' , '5')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (P, T, V, S).' , 'false' , '5')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (6, '2', 'Como determinar se uma cadeia é aceita por autômato finito:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado final.' , 'true'  , '6')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado inicial.' , 'false' , '6')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado final e inicial.' , 'false' , '6')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele começa num estado final.' , 'false' , '6')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele não tem um estado final.' , 'false' , '6')");
        ////
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (7, '2', 'Descreva qual a linguagem gerada por G, G = (V, T, P, S), onde: V = {S, L, C}; T = {l, n}; P = { 1) S→ LC, 2) L→ l, 3) C→ lC, 4) C→ nC, 5) C→ n, 6) C→ l, 7) C→ λ')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {lw | w ϵ {l, n}*}', 'true'  , '7')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | w ϵ {l, n}}'  , 'false' , '7')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | w ϵ {l, n}*}' , 'false' , '7')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | n ϵ {l, w}*}' , 'false' , '7')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | w ≠ {l, n}*}' , 'false' , '7')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (8, '2', 'Dados as seguintes gramáticas, G = (V, T, P, S), onde: V = {S}, T = {a, b}, P = {\tS→ aSa, S→ b}.')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≥0}' , 'true'  , '8')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n=0}' , 'false' , '8')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≤0}' , 'false' , '8')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbⁿ | n≥0}'  , 'false' , '8')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≠0}' , 'false' , '8')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (9, '2', 'Dados as seguintes gramáticas, G = (V, T, P, S), onde: V = {S}, T = {a, b}, P = {\tS→ aSa, S→ b}.')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≥0}' , 'true'  , '9')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n=0}' , 'false' , '9')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≤0}' , 'false' , '9')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbⁿ | n≥0}'  , 'false' , '9')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≠0}' , 'false' , '9')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (10, '2', 'Sobre Autômato com Pilha uma definição pode ser:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto sintático de linguagens computacionais.' , 'true'  , '10')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um grafo que pode ser aplicado no projeto sintático de linguagens computacionais.' , 'false' , '10')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto semântico de linguagens computacionais.' , 'false' , '10')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto sintático e semântico de linguagens computacionais.'  , 'false' , '10')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um poderoso AFD.' , 'false' , '10')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (11, '2', 'Formalmente o Autômato com Pilha é uma Sextupla que é:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,Σ,Γ,∆,Z,s,F)' , 'true'  , '11')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,Σ,Γ,∆,Z,s,A)' , 'false' , '11')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,F,Γ,∆,Z,s,Σ)' , 'false' , '11')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,∆,F,Γ ,Z,s,Σ)'  , 'false' , '11')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,∆,F, Z, Γ ,s,Σ)' , 'false' , '11')");
        //
//
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (12, '2', 'Considerando a definição de Autômato com Pilha, o que deve acontecer para que uma cadeia seja reconhecida:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser ACEITA, ela deve ser processada por inteiro, portanto, a pilha do autômato deve estar vazia.' , 'true'  , '12')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser REJEITA, ela de ser processada pelo começo dela, portanto, a pilha do autômato deve estar vazia.' , 'false' , '12')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser ACEITA, ela de ser processada pelo meio, portanto, a pilha do autômato deve estar vazia.' , 'false' , '12')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela poderá ACEITA, ela de ser processada pelo fim, portanto, a pilha do autômato deve estar vazia.'  , 'false' , '12')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela poderá ACEITA, ela de ser processada por inteiro, portanto, a pilha do autômato deve conter no mínimo um caractere.' , 'false' , '12')");
        //
//
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (13, '2', 'O que é a Máquina de Turing:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo abstrato de uma computador restringe-se apenas em aspectos lógicos dos seu funcionamento (memória, estados e transições) e não à sua implementação física.' , 'true'  , '13')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo refere-se a um computador restringe-se apenas em aspectos implementados.' , 'false' , '13')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo abstrato de uma computador restringe-se apenas em aspectos Linguagem em Alto Nível.' , 'false' , '13')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, cujo o modelo não é mais usado hoje.'  , 'false' , '13')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo abstrato de uma computador restringe-se apenas em AFD’s.' , 'false' , '13')");
        //

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
