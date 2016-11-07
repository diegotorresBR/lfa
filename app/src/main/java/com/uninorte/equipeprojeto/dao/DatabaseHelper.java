package com.uninorte.equipeprojeto.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
//-----------------------------------------------------------------------------------------------------------------------------------
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta)              values (1, '1', 'O que significa LFA?')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Linguagens Formais e Autômatos', 'true' , '1')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Inteligência Artificial'       , 'false', '1')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Matemática'                    , 'false', '1')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Português'                     , 'false', '1')");
//-----------------------------------------------------------------------------------------------------------------------------------
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta)              values (2, '2', 'O que significa dizer que dois estados de um autômato finito são equivalentes?')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS em cada um desses estados são idênticos.'                  , 'true'  , '2')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS em cada um desses estados são parecidos.'                  , 'false' , '2')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS separados estados.'                                        , 'false' , '2')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias REJEITADAS em cada um desses estados são idênticos.'               , 'false' , '2')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (3, '2', 'Formalmente, gramáticas são dispositivos para geração de sentenças de uma dada linguagem. Então definida como Quartupla:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, P, S).' , 'true'  , '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, S, P, S).' , 'false' , '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, S, P).' , 'false' , '3')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, T, S).' , 'false' , '3')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (4, '2', 'Como determinar se uma cadeia é aceita por autômato finito:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado final.' , 'true'  , '4')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado inicial.' , 'false' , '4')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado final e inicial.' , 'false' , '4')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele começa num estado final.' , 'false' , '4')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (5, '2', 'Descreva qual a linguagem gerada por G, G = (V, T, P, S), onde: V = {S, L, C}; T = {l, n}; P = { 1) S→ LC, 2) L→ l, 3) C→ lC, 4) C→ nC, 5) C→ n, 6) C→ l, 7) C→ λ')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {lw | w ϵ {l, n}*}', 'true'  , '5')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | w ϵ {l, n}}'  , 'false' , '5')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | w ϵ {l, n}*}' , 'false' , '5')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | n ϵ {l, w}*}' , 'false' , '5')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (6, '2', 'Dados as seguintes gramáticas, G = (V, T, P, S), onde: V = {S}, T = {a, b}, P = {\tS→ aSa, S→ b}.')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≥0}' , 'true'  , '6')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n=0}' , 'false' , '6')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≤0}' , 'false' , '6')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbⁿ | n≥0}'  , 'false' , '6')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (7, '2', 'Dados as seguintes gramáticas, G = (V, T, P, S), onde: V = {S}, T = {a, b}, P = {\tS→ aSa, S→ b}.')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≥0}' , 'true'  , '7')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n=0}' , 'false' , '7')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≤0}' , 'false' , '7')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbⁿ | n≥0}'  , 'false' , '7')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (8, '2', 'Sobre Autômato com Pilha uma definição pode ser:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto sintático de linguagens computacionais.' , 'true'  , '8')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um grafo que pode ser aplicado no projeto sintático de linguagens computacionais.' , 'false' , '8')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto semântico de linguagens computacionais.' , 'false' , '8')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto sintático e semântico de linguagens computacionais.'  , 'false' , '8')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (9, '2', 'Formalmente o Autômato com Pilha é uma Sextupla que é:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,Σ,Γ,∆,Z,s,F)' , 'true'  , '9')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,Σ,Γ,∆,Z,s,A)' , 'false' , '9')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,F,Γ,∆,Z,s,Σ)' , 'false' , '9')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,∆,F,Γ ,Z,s,Σ)'  , 'false' , '9')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (10, '2', 'Considerando a definição de Autômato com Pilha, o que deve acontecer para que uma cadeia seja reconhecida:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser ACEITA, ela deve ser processada por inteiro, portanto, a pilha do autômato deve estar vazia.' , 'true'  , '10')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser REJEITA, ela de ser processada pelo começo dela, portanto, a pilha do autômato deve estar vazia.' , 'false' , '10')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser ACEITA, ela de ser processada pelo meio, portanto, a pilha do autômato deve estar vazia.' , 'false' , '10')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela poderá ACEITA, ela de ser processada pelo fim, portanto, a pilha do autômato deve estar vazia.'  , 'false' , '10')");
        //
        db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (11, '2', 'O que é a Máquina de Turing:')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo abstrato de uma computador restringe-se apenas em aspectos lógicos dos seu funcionamento (memória, estados e transições) e não à sua implementação física.' , 'true'  , '11')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo refere-se a um computador restringe-se apenas em aspectos implementados.' , 'false' , '11')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo abstrato de uma computador restringe-se apenas em aspectos Linguagem em Alto Nível.' , 'false' , '11')");
        db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, cujo o modelo não é mais usado hoje.'  , 'false' , '11')");
        //1
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (12, '2', 'Sabe-se que, por definição formal, um Autômato Finito é uma quíntupla de elementos ordenados. De acordo com esses elementos, assinale a afirmativa correta.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de ∑.'                              , 'false', '12')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de Q.'                              , 'true' , '12')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('F é um conjunto de ∑*.'                              , 'false', '12')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A função de transição é uma função parcial de F e ∑.', 'false', '12')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento específico de F.'                   , 'false', '12')");
		//2
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (13, '2', 'Ainda sobre a definição formal de um Autômato Finito, julgue os itens abaixo:" 
		+"I. O subconjunto de estados finais de um autômato pode ser vazio."
		+"II. A função de transição é uma função parcial aplicada sobre os símbolos do alfabeto e sobre o conjunto de estados finais do autômato."
		+"III. A função de transição comanda os estados finais do autômato."
		+"IV. A função de transição é uma função parcial aplicada sobre todos os possíveis estados e sobre o conjunto de estados finais do autômato."
		+"V. F é um subconjunto unitário de Q, para todo e qualquer autômato.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Todas as afirmativas são verdadeiras.', 'false', '13')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas I, III e V são verdadeiras.'   , 'false', '13')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas II e IV são falsas.'           , 'false', '13')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas a afirmativa I é verdadeira.'  , 'false', '13')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Todas as afirmativas são falsas.'     , 'true' , '13')");
		//3
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (14, '2', 'Uma palavra ou sentença sobre um alfabeto é uma sequência finita de símbolos (do alfabeto) justapostos. Em uma palavra nós temos os prefixos, sufixos e subpalavras. Suponha a palavra CASA, os conjuntos dos prefixos e dos sufixos estão mostrados abaixo: "
		+"Prefixos = {ε, C, CA, CAS, CASA} " 
		+"Sufixos = {ε, A, SA, ASA, CASA}  "
		+"Sabendo-se disso, assinale a alternativa que contém a equação a qual denota o número de prefixos ou sufixos de uma determinada palavra de tamanho N.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('2N + 1', 'false', '14')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('2N + 2', 'false', '14')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('N + 1' , 'true' , '14')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('N + 2' , 'false', '14')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('N'     , 'false', '14')");
		//4
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (16, '2', 'Um Autômato Finito Determinístico (AFD) é um modelo matemático de sistema com entradas e saídas discretas. Ele pode assumir um número finito e predefinido de estados, tornando-se útil no processamento de símbolos. Sobre os AFD, assinale a alternativa incorreta:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato possui uma fita de entrada, na qual os símbolos de entrada estão presentes e prontos para serem processados.' , 'false' , '16')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É possível um autômato finito determinístico gravar símbolos de entrada na fita.'                                         , 'true'  , '16')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato constitui um modelo computacional do tipo sequencial.'                                                        , 'false' , '16')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A unidade de controle de um autômato finito determinístico possui um número definido de estados.'                         , 'false' , '16')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Só é permitido ler um símbolo de cada vez da fita de um AFD.'                                                             , 'false' , '16')");
		//5
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (17, '2', 'Os Autômatos Finitos Não-determinísticos, assim como os AFD são modelos matemáticos úteis no reconhecimento (processamento) de símbolos. Porém, os AFN possuem algumas especialidades que os diferenciam dos AFD. Sobre os AFN é correto afirmar: ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A facilidade do não-determinismo aumenta consideravelmente o poder computacional do autômato.'          , 'false', '17')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Para cada AFN não é possível construir um AFD equivalente.'                                             , 'false', '17')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Assim como os AFD, os AFN possuem memória auxiliar.'                                                    , 'false', '17')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui somente um estado inicial e pode ter N ≥ 1 estados finais.'                                      , 'true' , '17')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A partir de um símbolo x do alfabeto de entrada a transição pode ocorrer apenas para um estado N de Q.' , 'false', '17')");
		//6
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (18, '2', 'Uma gramática é, basicamente, um conjunto finito de regras as quais, quando aplicadas sucessivamente, geram palavras. O conjunto de todas as palavras geradas pela gramática define a linguagem. Sobre gramática é correto afirmar:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Duas gramáticas são ditas equivalentes se, e somente se, elas são iguais.'       , 'false', '18')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Somente as regras de produção definem uma gramática formal.'                     , 'false', '18')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma gramática é um formalismo axiomático.'                                       , 'true' , '18')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nas gramáticas, os símbolos terminais só podem gerar apenas um símbolo variável.', 'false', '18')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nas gramáticas, os símbolos variáveis só podem gerar apenas um símbolo terminal.', 'false', '18')");
		//7
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (19, '2', 'Com relação aos conceitos das gramáticas e autômatos, assinale a alternativa incorreta.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A regra de produção A → wB denota uma gramática linear à direita.'                                                , 'false', '19')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A regra de produção A → Bw denota uma gramática linear à esquerda.'                                               , 'false', '19')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A máquina de Mealy gera saída para cada transição da máquina e a de Moore gera saída para cada estado da máquina.', 'false', '19')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('As saídas de um autômato finito com saída podem ser lidas e serem utilizadas como memória auxiliar.'              , 'true' , '19')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O autômato com pilha é um exemplo de um autômato de saída.'                                                       , 'false', '19')");
		//8
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (20, '2', 'Com relação aos autômatos com pilha, assinale a alternativa correta:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O critério de parada do autômato com pilha é idêntico ao do AFD, possuindo apenas este critério.'             , 'false', '20')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O alfabeto da pilha tem que ser, obrigatoriamente, diferente do alfabeto de entrada.'                         , 'false', '20')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A estrutura da pilha sempre deve ter o mesmo tamanho da fita de entrada.'                                     , 'false', '20')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui este nome, pois contém uma estrutura (pilha) que funciona como auxílio à fita de entrada do autômato.' , 'false', '20')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A estrutura da pilha é suficiente como única memória, isto é, uma Linguagem Livre do Contexto pode ser reconhecida por um autômato com pilha com somente um estado.' , 'true' , '20')");
		//9
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (21, '2', 'Com relação aos conceitos de alfabeto, palavra, linguagem, sintaxe e semântica, assinale a afirmativa correta:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A sintaxe manipula símbolos sem considerar os seus correspondentes significados.'        , 'true' , '21')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia sem símbolos não denota uma palavra válida.'                                  , 'false', '21')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um programa sintaticamente correto não possui erros de semântica.'                       , 'false', '21')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto de símbolos que formam um alfabeto de uma linguagem possui tamanho ilimitado.', 'false', '21')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto vazio não pode ser considerado um alfabeto.'                                  , 'false', '21')");
		//10
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (22, '2', 'Os formalismos são utilizados para facilitar o estudo das linguagens típicas da Computação. Podemos destacar três tipos de formalismos: axiomático, operacional e denotacional. Sobre eles, assinale a alternativa incorreta:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional também é conhecido como funcional.'                       , 'false', '22')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('No formalismo axiomático associam-se regras aos componentes da linguagem.'          , 'false', '22')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo operacional denota uma máquina abstrata.'                              , 'false', '22')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional também é conhecido como reconhecedor.'                    , 'true' , '22')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional define um conjunto de palavras admissíveis na linguagem.' , 'false', '22')");
		//
		
//-----------------------------------PROFESSORA SANSHA
		//03
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (23, '2', 'Sobre Autômatos Finitos Não Determinísticos (AFNs), podemos afirmar que:')																							");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma palavra é reconhecida por um AFN se existe uma computação que consome todos os seus símbolos e termina em um estado final da máquina.' , 'true'  , '23')     ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Não permite que uma mesma palavra possua várias computações, sobre o mesmo AFN.' , 'false' , '23')                                                               ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma palavra é reconhecida por um AFN se existe uma computação que consome todos os seus símbolos e termina em algum estado.'  , 'false', '23')                   ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um AFN possui um estado inicial e todos os demais estados são do conjunto de estados finais.' , 'false' , '23')                                                  ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '23')                                                                                                          ");
		//04
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (24, '2', 'Um Autômato Finito Determinístico (AFD) consiste de um caso específico de um Autômato Finito Não Determinístico (AFN), no qual há a restrição: para cada par (estado, símbolo) existe transição para um único estado. Dado o AFD, representado pelo diagrama abaixo, assinale alternativa que contém a palavra não aceita por ele. figura24')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('aababbb' , 'true'  , '24')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('ababbaa' , 'false' , '24')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('bbaaaa'  , 'false', '24') ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('bbbbbb' , 'false' , '24') ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('aaabba' , 'false' , '24') ");
		//05
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (25, '2', 'Expressão Regular pode ser conceituada como uma expressão concisa que denota uma linguagem regular. Uma expressão regular pode ser convertida para um autômato. Considerando isso, marque a alternativa que corresponde ao autômato que representa a Expressão Regular: {0,1}*{1010}, ∑= {0,1}:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('figura25A' , 'true'  , '25')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('figura25B' , 'false' , '25')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('figura25C'  , 'false', '25')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('figura25D' , 'false' , '25')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('figura25E' , 'false' , '25')");
		//06
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (26, '2', 'Uma linguagem formal possui uma sintaxe bem definida de forma que dada uma sentença sempre é possível determinar se a mesma pertence ou não à linguagem. Sobre linguagens formais, marque a alternativa incorreta:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nem toda linguagem possui um alfabeto associado à ela, somente as finitas.' , 'true'  , '26')					");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma linguagem sobre Σ é um subconjunto de Σ* constituído de strings possíveis.' , 'false' , '26')                ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Operações sobre conjuntos podem ser utilizadas na especificação de linguagens formais.'  , 'false', '26')        ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Linguagens formais podem ser finitas ou infinitas.' , 'false' , '26')                                            ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Linguagens formais podem ser representadas por máquinas de estado finito.' , 'false' , '26')                     ");
		//07
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (27, '2', 'Considerando a representação de conjuntos e o alfabeto Σ = {0,1}, marque a alternativa que melhor representa a Linguagem cuja quantidade de 0’s seja igual a de 1’s:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L = {0 n 1 n | n >= 0}' , 'true'  , '27')				");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L = {0 m 1 n | m e n >= 0}' , 'false' , '27')           ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L = {w ϵ Σ* | |w| >= 0}' , 'false' , '27')              ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L = {w ϵ Σ* | |w| > 0}' , 'false' , '27')               ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L = {(01 n ) m | m e n >= 0}' , 'false' , '27')         ");
		//08
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (28, '2', 'Dada a expressão regular ((a)* b (a)*a(a)*), marque a alternativa que contém a sentença que não pode ser gerada.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('aabba' , 'true'  , '28')	");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('aba' , 'false' , '28')   ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('abaaa'  , 'false', '28') ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('baaa' , 'false' , '28')  ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('aabaa' , 'false' , '28') ");
		//09
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (29, '2', 'Uma Gramática é um formalismo gerador de linguagem. Dada a gramática G = ({P,S}, {a,b}, R, P), onde R é dado por: "
		+" A  aB | B "
		+" B  bB | baB | ϵ "
		+" Marque a alternativa que descreve a Linguagem Gerada pela gramática G (L(G)).')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de strings onde cada ocorrência de a é imediatamente seguido por um b.' , 'true' ,'29')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de strings com prefixo a.' , 'false', '29')                                            ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de strings com sufixo ba.' , 'false', '29')                                            ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de strings com prefixo e sufixo a.' , 'false', '29')                                   ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false', '29')                                          ");
		//10
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (30, '2', 'Linguagens regulares podem ser definidas por autômatos finitos, expressões regulares e gramáticas regulares. Dada a expressão regular: a(a* | b*), marque a alternativa que indica as regras da gramática que gera a mesma linguagem:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('S  aC' , 'true'  , '30')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('C  A | B "
		+" A  aA | ε "
		+" B  bB | ε "
		+" S  aC     "
		+" C  A      "
		+" A  aA | bA' , 'false' , '30')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('S a | b | C "
		+" C -> a | b'  , 'false', '30')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('S -> C "
		+" C -> AB "
		+" A -> aA "
		+" B -> bB | ε' , 'false' , '30')																															");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '30')				");
		//11
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (31, '2', 'No contexto de linguagens formais e autômatos, julgue os itens a seguir: "
		+" I – Um autômato finito com transições vazias (AFNε) não pode ser convertido em um autômato finito determinístico (AFD).                                  "
		+" II – Um autômato não pode ser considerado uma máquina de estados finito, pois representa linguagens.                                                     "
		+" III – Um autômato é um mecanismo reconhecedor de linguagens e gramáticas são geradores.                                                                  "
		+" Marque a alternativa correta:')																															");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas o item III está correto.' 	, 'true' , '31')				");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas o item II está correto.' 		, 'false', '31')                ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas o item I está correto.'  		, 'false', '31')                ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Os itens I, II e III estão corretos.', 'false', '31')                ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Os itens II e III estão corretos.' 	, 'false', '31')                ");
		//12                                                                                                                                                        
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (32, '2', 'Sobre a linguagem: XV = {uv | u ε X ^ v ε Y}, é correto afirmar que:')   ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É formada pela concatenação de X com Y.'    , 'true' , '32')         ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É formada pela concatenação de Y com X.'    , 'false', '32')         ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É formada sobre o fecho de Kleene de X e Y.', 'false', '32')       	");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É formada pela união de X com Y.' 		   , 'false', '32')         ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É formada pela intercessão de X com Y.' 	   , 'false', '32')         ");


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
