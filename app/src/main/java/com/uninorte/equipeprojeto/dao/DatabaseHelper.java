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
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '1') ");
//-----------------------------------------------------------------------------------------------------------------------------------
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta)              values (2, '2', 'O que significa dizer que dois estados de um autômato finito são equivalentes?')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS em cada um desses estados são idênticos.'                  , 'true'  , '2')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS em cada um desses estados são parecidos.'                  , 'false' , '2')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias ACEITAS separados estados.'                                        , 'false' , '2')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Significa que os conjuntos de cadeias REJEITADAS em cada um desses estados são idênticos.'               , 'false' , '2')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '2') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (3, '2', 'Formalmente, gramáticas são dispositivos para geração de sentenças de uma dada linguagem. Então definida como Quartupla:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, P, S).' , 'true'  , '3')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, S, P, S).' , 'false' , '3')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, S, P).' , 'false' , '3')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('G = (V, T, T, S).' , 'false' , '3')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '3') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (4, '2', 'Como determinar se uma cadeia é aceita por autômato finito:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado final.' , 'true'  , '4')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado inicial.' , 'false' , '4')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele para num estado final e inicial.' , 'false' , '4')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Verificar se ele começa num estado final.' , 'false' , '4')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '4') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (5, '2', 'Descreva qual a linguagem gerada por G, G = (V, T, P, S), onde: \nV = {S, L, C}; \nT = {l, n}; \nP = { \n1) S→ LC, \n2) L → l, \n3) C→ lC, \n4) C→ nC, \n5) C→ n, \n6) C→ l, \n7) C→ λ')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {lw | w ϵ {l, n}*}', 'true'  , '5')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | w ϵ {l, n}}'  , 'false' , '5')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | w ϵ {l, n}*}' , 'false' , '5')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {w | n ϵ {l, w}*}' , 'false' , '5')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '5') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (6, '2', 'Dados as seguintes gramáticas, G = (V, T, P, S), onde: \nV = {S}, 	\nT = {a, b}, \nP = {\tS→ aSa, S→ b}.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≥0}' , 'true'  , '6')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n=0}' , 'false' , '6')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≤0}' , 'false' , '6')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbⁿ | n≥0}'  , 'false' , '6')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '6') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (7, '2', 'Dados as seguintes gramáticas, G = (V, T, P, S), onde: \nV = {S}, \nT = {a, b}, \nP = {\tS→ aSa, S→ b}.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≥0}' , 'true'  , '7')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n=0}' , 'false' , '7')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbaⁿ | n≤0}' , 'false' , '7')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('L(G) = {aⁿbⁿ | n≥0}'  , 'false' , '7')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '7') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (8, '2', 'Sobre Autômato com Pilha uma definição pode ser:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto sintático de linguagens computacionais.' , 'true'  , '8')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um grafo que pode ser aplicado no projeto sintático de linguagens computacionais.' , 'false' , '8')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto semântico de linguagens computacionais.' , 'false' , '8')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Autômato com pilha é um formalismo que pode ser aplicado no projeto sintático e semântico de linguagens computacionais.'  , 'false' , '8')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '8') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (9, '2', 'Formalmente o Autômato com Pilha é uma Sextupla que é:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,Σ,Γ,∆,Z,s,F)' , 'true'  , '9')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,Σ,Γ,∆,Z,s,A)' , 'false' , '9')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,F,Γ,∆,Z,s,Σ)' , 'false' , '9')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('M = (Q,∆,F,Γ ,Z,s,Σ)'  , 'false' , '9')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '9') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (10, '2', 'Considerando a definição de Autômato com Pilha, o que deve acontecer para que uma cadeia seja reconhecida:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser ACEITA, ela deve ser processada por inteiro, portanto, a pilha do autômato deve estar vazia.' , 'true'  , '10')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser REJEITA, ela de ser processada pelo começo dela, portanto, a pilha do autômato deve estar vazia.' , 'false' , '10')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela deve ser ACEITA, ela de ser processada pelo meio, portanto, a pilha do autômato deve estar vazia.' , 'false' , '10')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia de símbolos seja reconhecida pelo autômato, ou seja ela poderá ACEITA, ela de ser processada pelo fim, portanto, a pilha do autômato deve estar vazia.'  , 'false' , '10')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '10') ");
		//
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (11, '2', 'O que é a Máquina de Turing:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo abstrato de uma computador restringe-se apenas em aspectos lógicos dos seu funcionamento (memória, estados e transições) e não à sua implementação física.' , 'true'  , '11')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo refere-se a um computador restringe-se apenas em aspectos implementados.' , 'false' , '11')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, que num modelo abstrato de uma computador restringe-se apenas em aspectos Linguagem em Alto Nível.' , 'false' , '11')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um dispositivo teórico conhecido como máquina universal, cujo o modelo não é mais usado hoje.'  , 'false' , '11')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '11') ");
//        //1
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (12, '2', 'Sabe-se que, por definição formal, um Autômato Finito é uma quíntupla de elementos ordenados. De acordo com esses elementos, assinale a afirmativa correta.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de ∑.'                              , 'false', '12')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de Q.'                              , 'true' , '12')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('F é um conjunto de ∑*.'                              , 'false', '12')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A função de transição é uma função parcial de F e ∑.', 'false', '12')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento específico de F.'                   , 'false', '12')");
//		//2
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (13, '2', 'Ainda sobre a definição formal de um Autômato Finito, julgue os itens abaixo:\nI. O subconjunto de estados finais de um autômato pode ser vazio.\nII. A função de transição é uma função parcial aplicada sobre os símbolos do alfabeto e sobre o conjunto de estados finais do autômato.\nIII. A função de transição comanda os estados finais do autômato.\nIV. A função de transição é uma função parcial aplicada sobre todos os possíveis estados e sobre o conjunto de estados finais do autômato. \nV. F é um subconjunto unitário de Q, para todo e qualquer autômato.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Todas as afirmativas são verdadeiras.', 'false', '13')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas I, III e V são verdadeiras.'   , 'false', '13')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas II e IV são falsas.'           , 'false', '13')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Apenas a afirmativa I é verdadeira.'  , 'false', '13')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Todas as afirmativas são falsas.'     , 'true' , '13')");
//		//3
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (14, '2', 'Uma palavra ou sentença sobre um alfabeto é uma sequência finita de símbolos (do alfabeto) justapostos. Em uma palavra nós temos os prefixos, sufixos e subpalavras. Suponha a palavra CASA, os conjuntos dos prefixos e dos sufixos estão mostrados abaixo: \nPrefixos = {ε, C, CA, CAS, CASA}\nSufixos = {ε, A, SA, ASA, CASA}\nSabendo-se disso, assinale a alternativa que contém a equação a qual denota o número de prefixos ou sufixos de uma determinada palavra de tamanho N.')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('2N + 1', 'false', '14')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('2N + 2', 'false', '14')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('N + 1' , 'true' , '14')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('N + 2' , 'false', '14')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('N'     , 'false', '14')");
//		//4
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (16, '2', 'Um Autômato Finito Determinístico (AFD) é um modelo matemático de sistema com entradas e saídas discretas. Ele pode assumir um número finito e predefinido de estados, tornando-se útil no processamento de símbolos. Sobre os AFD, assinale a alternativa incorreta:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato possui uma fita de entrada, na qual os símbolos de entrada estão presentes e prontos para serem processados.' , 'false' , '16')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É possível um autômato finito determinístico gravar símbolos de entrada na fita.'                                         , 'true'  , '16')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato constitui um modelo computacional do tipo sequencial.'                                                        , 'false' , '16')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A unidade de controle de um autômato finito determinístico possui um número definido de estados.'                         , 'false' , '16')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Só é permitido ler um símbolo de cada vez da fita de um AFD.'                                                             , 'false' , '16')");
//		//5
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (17, '2', 'Os Autômatos Finitos Não-determinísticos, assim como os AFD são modelos matemáticos úteis no reconhecimento (processamento) de símbolos. Porém, os AFN possuem algumas especialidades que os diferenciam dos AFD. Sobre os AFN é correto afirmar:') ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A facilidade do não-determinismo aumenta consideravelmente o poder computacional do autômato.'          , 'false', '17')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Para cada AFN não é possível construir um AFD equivalente.'                                             , 'false', '17')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Assim como os AFD, os AFN possuem memória auxiliar.'                                                    , 'false', '17')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui somente um estado inicial e pode ter N ≥ 1 estados finais.'                                      , 'true' , '17')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A partir de um símbolo x do alfabeto de entrada a transição pode ocorrer apenas para um estado N de Q.' , 'false', '17')");
//		//6
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
//		//
//
////-----------------------------------PROFESSORA SANSHA
//		//03
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
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (29, '2', 'Uma Gramática é um formalismo gerador de linguagem. Dada a gramática G = ({P,S}, {a,b}, R, P), onde R é dado por: \n A  aB | B \n B  bB | baB | ϵ \n Marque a alternativa que descreve a Linguagem Gerada pela gramática G (L(G)).')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de strings onde cada ocorrência de a é imediatamente seguido por um b.' , 'true' ,'29')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de strings com prefixo a.' , 'false', '29')                                            ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de strings com sufixo ba.' , 'false', '29')                                            ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de strings com prefixo e sufixo a.' , 'false', '29')                                   ");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false', '29')                                          ");
		//10
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (30, '2', 'Linguagens regulares podem ser definidas por autômatos finitos, expressões regulares e gramáticas regulares. Dada a expressão regular: a(a* | b*), marque a alternativa que indica as regras da gramática que gera a mesma linguagem:')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('S -> aC' , 'true'  , '30')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('C -> A | B \nA -> aA | ε \nB -> bB | ε \nS -> aC \nC -> A \n\nA -> aA | bA' , 'false' , '30')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('S -> a | b | C \nC -> a | b'  , 'false', '30')");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('S -> C \nC -> AB \nA -> aA \nB -> bB | ε' , 'false' , '30')																															");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Nenhuma das Alternativas Anteriores.' , 'false' , '30')				");
		//11
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (31, '2', 'No contexto de linguagens formais e autômatos, julgue os itens a seguir: \nI – Um autômato finito com transições vazias (AFNε) não pode ser convertido em um autômato finito determinístico (AFD). \nII – Um autômato não pode ser considerado uma máquina de estados finito, pois representa linguagens. \nIII – Um autômato é um mecanismo reconhecedor de linguagens e gramáticas são geradores.\nMarque a alternativa correta:')																															");
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

//		------------------------------------------------------CIN05S1_LFA_Afonso_1CHAM_Prova INICIO------------------------------------------------------

//		--01
		db.execSQL("insert into perguntas(_id, id_unidade, txt_pergunta) values (33, '2', 'Assinale a alternativa incorreta.'); 																									");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A regra de produção A -> wB denota uma gramática linear à direita.' , 'false'  , '33');												");
		db.execSQL("insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A regra de produção A -> Bw denota uma gramática linear à esquerda.' , 'false' , '33');                                               ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A máquina de Mealy gera saída para cada transição da máquina e a de Moore gera saída para cada estado da máquina.'  , 'false', '33'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O autômato com pilha é um exemplo de um autômato de saída.' , 'false' , '33');                                                        ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('As saídas de um autômato finito com saída podem ser lidas e serem utilizadas como memória auxiliar.' , 'true' , '33');");
//		--02
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (34, '2', 'Sobre os AFN é incorreto afirmar:');																				");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Assim como os AFD’s, os AFN’s não possuem memória auxiliar.' , 'false'  , '34');                                  ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A facilidade do não-determinismo aumenta consideravelmente o poder computacional do autômato.' , 'true' , '34');  ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A partir de um símbolo x do alfabeto de entrada a transição pode ocorrer para N estados de Q.'  , 'false', '34'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui somente um estado inicial e pode ter N ≥ 1 estados finais.' , 'false' , '34');                             ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Para cada AFN é possível construir um AFD equivalente.' , 'false' , '34');                    ");
//		--03
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (35, '2', 'Com relação aos formalismos é incorreto afirmar:');													");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional também é conhecido como reconhecedor.' , 'true'  , '35');                       ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo operacional denota uma máquina abstrata.' , 'false' , '35');                                 ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('No formalismo axiomático associam-se regras às componentes da linguagem.'  , 'false', '35');              ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional também é conhecido como funcional.' , 'false' , '35');                          ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('No formalismo denotacional define um conjunto de palavras admissíveis na linguagem.' , 'false' , '35');   ");
//		-04
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (36, '2', 'Sobre as expressões regulares é correto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Se x e y são expressões regulares, então a expressão (x+y) denota a concatenação entre as duas.' , 'false'  , '36'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A expressão (a+b)*(aa+bb) denota todas as palavras que terminem em bb.' , 'false' , '36');                           ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É definida a partir de autômatos básicos e de operações de concatenação e união.'  , 'false', '36');                 ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Trata-se de um formalismo operacional.' , 'false' , '36');                                                           ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Se x e y são expressões regulares, então a expressão (x+y) denota a união entre as duas.' , 'true' , '36');          ");
		//		--05
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (37, '2', '05.	Julgue os itens a seguir e assinale a alternativa que possui apenas os itens verdadeiros.\nI.	Somente as regras de produção é que definem                uma gramática formal. \nII.	O conjunto vazio é diferente do conjunto formado pela palavra vazia. \nIII.	O conjunto de palíndromos sobre o alfabeto {a, b} é um exemplo de linguagem infinita. \nIV.	Duas gramáticas são ditas equivalentes se, e somente se, elas são iguais.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I, II, III e IV.' , 'false'  , '37'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I e IV.' , 'false' , '37');           ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I e III.'  , 'false', '37');          ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('II e III.' , 'true' , '37');          ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('II e IV.' , 'false' , '37');          ");
//		--06
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (38, '2', 'Com relação aos AFD’s é correto afirmar:');							        ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A função de transição é uma função parcial de F e ∑.' , 'false'  , '38'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('F é um conjunto de ∑*.' , 'false' , '38');                                ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de ∑.'  , 'false', '38');                                ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de Q.' , 'true' , '38');                                 ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Podemos ter apenas um estado final.' , 'false' , '38');                   ");
		//		--07
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (39, '2', 'Assinale a alternativa correta.');																");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O estudo das linguagens formais é aplicado nos bancos de dados relacionais.' , 'false'  , '39');     ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um programa sintaticamente correto não possui erros de semântica.' , 'false' , '39');                ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A semântica trata das propriedades livres da linguagem.'  , 'false', '39');                          ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A sintaxe manipula símbolos sem considerar os seus correspondentes significados.' , 'true' , '39');  ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A sintaxe trata dos significados de uma linguagem.' , 'false' , '39');                               ");
//				--08
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (40, '2', 'Assinale a alternativa incorreta.');																											");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A unidade de controle de um autômato finito possui um número definido de estados.' , 'false'  , '40');                                                ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É possível um autômato finito gravar símbolos de entrada na fita.' , 'true' , '40');                                                                  ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Só é permitido ler um símbolo de cada vez da fita de um autômato finito.' , 'false', '40');                                                           ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato finito possui uma fita de entrada, na qual os símbolos de entrada estão presentes e prontos para serem processados.' , 'false' , '40');   ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato finito constitui um modelo computacional do tipo seqüencial.' , 'false' , '40');                                                          ");
//		--09
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (41, '2', 'Com relação aos autômatos com pilha, assinale a alternativa correta:');																												");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A estrutura da pilha é suficiente como única memória, isto é, uma Linguagem Livre do Contexto pode ser reconhecida por um autômato com pilha com somente um estado.' , 'true'  , '41');   ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A estrutura da pilha sempre deve ter o mesmo tamanho da fita de entrada.' , 'false' , '41');                                                                                              ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui este nome, pois contém uma estrutura (pilha) que funciona como auxílio à fita de entrada do autômato.'  , 'false', '41');                                                          ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O critério de parada do autômato com pilha é idêntico ao do AFD, possuindo apenas este critério.' , 'false' , '41');                                                                      ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O alfabeto da pilha tem que ser, obrigatoriamente, diferente do alfabeto de entrada.' , 'false' , '41');                                                                                  ");
//		--10
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (42, '2', 'Assinale a alternativa incorreta.');																	");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia sem símbolos denota uma palavra válida.' , 'false'  , '42');                                       ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um programa sintaticamente correto pode possuir erros de semântica.' , 'false' , '42');                       ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto vazio pode ser considerado um alfabeto.'  , 'false', '42');                                        ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto de símbolos que formam um alfabeto de uma linguagem possui tamanho limitado.' , 'false' , '42');   ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A sintaxe manipula símbolos considerando os seus correspondentes significados.' , 'true' , '42');             ");
//		------------------------------------------------------CIN05S1_LFA_Afonso_1CHAM_Prova INICIO------------------------------------------------------

//------------------------------------------------------------CIN05S1-S2_LFA_Afonso_2CHAM.doc INICIO------------------------------------------------------------
		//01
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (43, '2', 'Assinale a alternativa incorreta.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato finito possui uma fita de entrada, na qual os símbolos de entrada estão presentes e prontos para serem processados.' , 'false'  ,'43');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É possível um autômato finito gravar símbolos de entrada na fita.' , 'true' , '43');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato finito constitui um modelo computacional do tipo sequencial.' , 'false' , '43');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A unidade de controle de um autômato finito possui um número definido de estados.' , 'false' , '43');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Só é permitido ler um símbolo de cada vez da fita de um autômato finito.' , 'false' ,  '43');");
		//02
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (44, '2', 'Assinale a alternativa correta.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato finito é um formalismo denotacional, o qual é definido a partir dos conjuntos básicos de operações de concatenação e de união.' , 'false'  ,'44');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Expressão regular é um formalismo gerador que possui restrições na forma das regras de produção.' , 'false' , '44');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('As linguagens regulares não possuem forte limitação de expressividade.' , 'false' , '44');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato finito é um formalismo axiomático, sendo um sistema de estados finitos.' , 'false' , '44');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma gramática regular é um formalismo axiomático.' , 'true' ,  '44');");
		//03
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (45, '2', 'Sobre os AFN é correto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A facilidade do não-determinismo aumenta consideravelmente o poder computacional do autômato.' , 'false'  ,'45');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Para cada AFN não é possível construir um AFD equivalente.' , 'false' , '45');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Assim como os AFD, os AFN possuem memória auxiliar.' , 'false' , '45');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui somente um estado inicial e pode ter N ≥ 1 estados finais.' , 'true' , '45');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A partir de um símbolo x do alfabeto de entrada a transição pode ocorrer apenas para um estado N de Q.' , 'false' ,  '45');");
		//04
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (46, '2',     'Sobre as expressões regulares é incorreto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Trata-se de um formalismo denotacional.' , 'false'  ,'46');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A expressão (a+b)*(aa+bb) denota todas as palavras que terminem em bb.' , 'true' , '46');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Se x e y são expressões regulares, então a expressão (x+y) denota a união entre as duas.' , 'false' , '46');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Se x e y são expressões regulares, então a expressão (x+y) denota a concatenação entre as duas.' , 'false' , '46');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É definida a partir de operações de concatenação e união.' , 'false' ,  '46');");
		//05
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (47, '2',     'Com relação aos AFD é incorreto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A função de transição é uma função parcial de F e ∑.' , 'true'  ,'47');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de Q.' , 'false' , '47');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 além de representar um estado inicial também pode ser um estado final.' , 'false' , '47');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('F é um sub-conjunto de Q.' , 'false' , '47');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Podemos ter vários estados finais.' , 'false' , '47');");
		//06
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (48, '2',     'Assinale a alternativa incorreta.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O autômato com pilha é um exemplo de um autômato de saída.' , 'false'  ,'48');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('As saídas de um autômato finito com saída podem ser lidas e serem utilizadas como memória auxiliar.' , 'true' , '48');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A máquina de Mealy gera saída para cada transição da máquina e a de Moore gera saída para cada estado da máquina.' , 'false' , '48');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A regra de produção A -> Bw denota uma gramática linear à esquerda.' , 'false' , '48');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A regra de produção A -> wB denota uma gramática linear à direita.' , 'false' , '48');");
		//07
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (49, '2',     'Julgue os itens a seguir e assinale a alternativa que possui apenas os itens falsos. I.Somente as regras de produção é que definem uma gramática formal. II.O conjunto vazio é diferente do conjunto formado pela palavra vazia. III.O conjunto de palíndromos sobre o alfabeto {a, b}     é um exemplo de linguagem infinita. IV.Duas gramáticas são ditas equivalentes se, e somente se, elas são iguais.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I, II, III e IV.' , 'false'  ,'49');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I e IV.' , 'true' , '49');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I e III.' , 'false' , '49');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('II e IV.' , 'false' , '49');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('II e III.' , 'false' , '49');");
		//08
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (50, '2',     'Com relação aos autômatos com pilha, assinale a alternativa correta:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui este nome, pois contém uma estrutura (pilha) que funciona como auxílio à fita de entrada do autômato.' , 'false'  ,'50');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A estrutura da pilha sempre deve ter o mesmo tamanho da fita de entrada.' , 'false' , '50');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A estrutura da pilha é suficiente como única memória, isto é, uma Linguagem Livre do Contexto pode ser reconhecida por um autômato com pilha com somente um estado.' , 'true' , '50');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O critério de parada do autômato com pilha é idêntico ao do AFD, possuindo apenas este critério.' , 'false' , '50');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O alfabeto da pilha tem que ser, obrigatoriamente, diferente do alfabeto de entrada.' , 'false' , '50');");
		//09
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (51, '2',     'Com relação aos formalismos é incorreto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional também é conhecido como reconhecedor.' , 'true'  ,'51');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional também é conhecido como funcional.' , 'false' , '51');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('No formalismo denotacional define um conjunto de palavras admissíveis na linguagem.' , 'false' , '51');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo operacional denota uma máquina abstrata.' , 'false' , '51');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('No formalismo axiomático associam-se regras às componentes da linguagem.' , 'false' , '51');");
		//10
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (52, '2',     'Assinale a alternativa incorreta.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto de símbolos que formam um alfabeto de uma linguagem possui tamanho limitado.' , 'false'  ,'52');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A sintaxe manipula símbolos considerando os seus correspondentes significados.' , 'true' , '52');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto vazio pode ser considerado um alfabeto.' , 'false' , '52');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia sem símbolos denota uma palavra válida.' , 'false' , '52');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um programa sintaticamente correto pode possuir erros de semântica.' , 'false' , '52');");
//------------------------------------------------------------CIN05S1-S2_LFA_Afonso_2CHAM.doc FIM------------------------------------------------------------

//------------------------------------------------------------CIN05S2_LFA_Afonso_1CHAM_Prova.doc INICIO------------------------------------------------------------

		//01
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Assinale a alternativa incorreta.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A regra de produção A -> wB denota uma gramática linear à direita.' , 'false'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A regra de produção A -> Bw denota uma gramática linear à esquerda.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A máquina de Mealy gera saída para cada transição da máquina e a de Moore gera saída para cada estado da máquina.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O autômato com pilha é um exemplo de um autômato de saída.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('As saídas de um autômato finito com saída podem ser lidas e serem utilizadas como memória auxiliar. ' , 'true' , '53');");
		//02
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Sobre os AFN é incorreto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Assim como os AFD’s, os AFN’s não possuem memória auxiliar.' , 'false'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A facilidade do não-determinismo aumenta consideravelmente o poder computacional do autômato.' , 'true' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A partir de um símbolo x do alfabeto de entrada a transição pode ocorrer para N estados de Q.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui somente um estado inicial e pode ter N ≥ 1 estados finais.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Para cada AFN é possível construir um AFD equivalente.' , 'false' , '53');");
		////03
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Com relação aos formalismos é incorreto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional também é conhecido como reconhecedor.' , 'true'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo operacional denota uma máquina abstrata.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('No formalismo axiomático associam-se regras às componentes da linguagem.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O formalismo denotacional também é conhecido como funcional.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('No formalismo denotacional define um conjunto de palavras admissíveis na linguagem.' , 'false' , '53');");
		////04
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Sobre as expressões regulares é correto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Se x e y são expressões regulares, então a expressão (x+y) denota a concatenação entre as duas.' , 'false'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A expressão (a+b)*(aa+bb) denota todas as palavras que terminem em bb.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É definida a partir de autômatos básicos e de operações de concatenação e união.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Trata-se de um formalismo operacional.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Se x e y são expressões regulares, então a expressão (x+y) denota a união entre as duas.' , 'true' , '53');");
		////05
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Julgue os itens a seguir e assinale a alternativa que possui apenas os itens verdadeiros. \nI.Somente as regras de produção é que definem uma gramática formal. \nII.O conjunto vazio é diferente do conjunto formado pela palavra vazia. \nIII.O conjunto de palíndromos sobre o alfabeto {a, b} é um exemplo de linguagem infinita. \nIV.Duas gramáticas são ditas equivalentes se, e somente se, elas são iguais.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I, II, III e IV.' , 'false'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I e IV.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('I e III.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('II e III.' , 'true' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('II e IV.' , 'false' , '53');");
		////06
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Com relação aos AFD’s é correto afirmar:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A função de transição é uma função parcial de F e ∑.' , 'false'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('F é um conjunto de ∑*.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de ∑.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('q0 é um elemento de Q.' , 'false' , 'true');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Podemos ter apenas um estado final.' , 'false' , '53');");
		////07
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Assinale a alternativa correta.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O estudo das linguagens formais é aplicado nos bancos de dados relacionais.' , 'false'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um programa sintaticamente correto não possui erros de semântica.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A semântica trata das propriedades livres da linguagem.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A sintaxe manipula símbolos sem considerar os seus correspondentes significados.' , 'true' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A sintaxe trata dos significados de uma linguagem.' , 'false' , '53');");
		////08
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Assinale a alternativa incorreta.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A unidade de controle de um autômato finito possui um número definido de estados.' , 'false'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É possível um autômato finito gravar símbolos de entrada na fita.' , 'true' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Só é permitido ler um símbolo de cada vez da fita de um autômato finito.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato finito possui uma fita de entrada, na qual os símbolos de entrada estão presentes e prontos para serem processados.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um autômato finito constitui um modelo computacional do tipo seqüencial.' , 'false' , '53');");
		////09
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Com relação aos autômatos com pilha, assinale a alternativa correta:'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A estrutura da pilha é suficiente como única memória, isto é, uma Linguagem Livre do Contexto pode ser reconhecida por um autômato com pilha com somente um estado.' , 'true'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A estrutura da pilha sempre deve ter o mesmo tamanho da fita de entrada.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Possui este nome, pois contém uma estrutura (pilha) que funciona como auxílio à fita de entrada do autômato.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O critério de parada do autômato com pilha é idêntico ao do AFD, possuindo apenas este critério.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O alfabeto da pilha tem que ser, obrigatoriamente, diferente do alfabeto de entrada.' , 'false' , '53');");
		////10
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (53, '2',     'Assinale a alternativa incorreta.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia sem símbolos denota uma palavra válida.' , 'false'  ,'53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um programa sintaticamente correto pode possuir erros de semântica.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto vazio pode ser considerado um alfabeto.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto de símbolos que formam um alfabeto de uma linguagem possui tamanho limitado.' , 'false' , '53');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A sintaxe manipula símbolos considerando os seus correspondentes significados.' , 'true' , '53');");

//------------------------------------------------------------CIN05S2_LFA_Afonso_1CHAM_Prova.doc FIM------------------------------------------------------------

//------------------------------------------------------------perguntas acima devem ser atualizadas as unidades------------------------------------------------------------

//------------------------------------------------------unidade 1 LEANDRO INICIO ------------------------------------------------------------------------------------------------
//		UNIDADE 1
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (54, '1',     'O que é alfabeto? '); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Alfabeto é um conjunto finito e não vazio de símbolos. Geralmente, o alfabeto é denotado por ∑. ' , 'true'  ,'54');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Alfabeto é um conjunto de letras formais' , 'false' , '54');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É um conjunto de variaveis não definidas' , 'false' , '54');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Conjunto de letras viaridas com fluxo externo' , 'false' , '54');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Varios tipos de alfabeto grego-romano' , 'false' , '54');");
		//
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (55, '1',     'Defina o conceito de cadeia.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia é uma seqüência formada por símbolos pertencentes à um mesmo alfabeto. Por exemplo, a partir do alfabeto ∑ = {0, 1} seria possível formar as cadeias 0, 001 e 110101' , 'true'  ,'55');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Um conjunto finito e não vazio de símbolos' , 'false' , '55');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('um conjunto de cadeias formadas a partir de um mesmo alfabeto' , 'false' , '55');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Cadeia é formada por um conjunto de sequencia de caracteres não definidos' , 'false' , '55');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia segue um modelo padrão não formal.' , 'false' , '55');");
		//
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (56, '1',     'Defina o conceito de linguagem e mostre um exemplo.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Linguagem é um conjunto de cadeias formadas a partir de um mesmo alfabeto. Assim, L = {0, 1, 00, 01, 10, 11} seria um exemplo de linguagem formada a partir do alfabeto ∑ = {0, 1}' , 'true'  ,'56');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Linguagem é definido como um conjunto de bases aleatorias de turing.' , 'false' , '56');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A base para toda a linguaem definida como forma de cadeiras manuais.' , 'false' , '56');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O conjunto definido como base automatica refere a forma exporadica' , 'false' , '56');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A forma primordial do reconhecedor da linguaem de forma abstrada.' , 'false' , '56');");
		//
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (57, '1',     'O que é fechamento de um alfabeto? '); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Fechamento de um alfabeto é o conjunto de todas as cadeias possíveis de se formar a partir dos símbolos deste alfabeto' , 'true'  ,'73');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É uma forma abstrada de reconhecedor de linguagem.' , 'false' , '57');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É a base do alfabeto de forma simples mas modesta restituindo o exporadica.' , 'false' , '57');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Parte do princio de gramática para palvras de segundo grau.' , 'false' , '57');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('E o fechamento interno da forma de linguagem gramatical.' , 'false' , '57');");
//
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (58, '1',     'Quais são as diferentes abordagens pelas quais se pode utilizar modelos ormais para descrever linguagens?'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma linguagem formal pode ser descrita por um modelo reconhecedor ou por um modelo gerador' , 'true'  ,'58');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('As diferenças abstrada refere-se a forma fixa da gramatica.' , 'false' , '58');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A forma da abordagens segue um modelo interno não reconhecedor.' , 'false' , '58');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('As formas da diferenças são baseadas em um contexto completo da gramática.' , 'false' , '58');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Segue a gramatica formal e informal para a busca.' , 'false' , '58');");
//
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (59, '1',     'O que seria um modelo reconhecedor?'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Modelo reconhecedor é um modelo gramático capaz de pecorrer uma cadeia de simbolos aparti de um alfabeto.' , 'true'  ,'59');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Reconhecer as letras de uma palavra formal.' , 'false' , '59');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Forma um modelo de padrão moderado de palavra complexa.' , 'false' , '59');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Geralmente modelado para a gramatica e o contexo visualizador.' , 'false' , '59');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A representação da gramática quadrupla ordenada' , 'false' , '59');");
//
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (60, '1',     'Defina o conceito de subpalavra.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Uma cadeia x é uma subpalavra de uma cadeia y sse ∃w,u ∈ Σ* tal que y = wxu.' , 'true'  ,'60');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A subpalavra define  a cadeia de caracteres.' , 'false' , '60');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A forma definida da cadeira forma uma subpalavra informal.' , 'false' , '60');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('O simbolo da cadeira segue um padrão existente da gramatica.' , 'false' , '60');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('A derivaçao da arvore para o processo de subistituição da palavra.' , 'false' , '60');");
//
		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (61, '1',     'Defina linguagem formal.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É  uma coleção de cadeias de símbolos, de comprimento finito' , 'true'  ,'61');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('E a forma natural de backus para a notação da linguagem.' , 'false' , '61');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Segue a definição de caracteres começando com alguma letra.' , 'false' , '61');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Define a estrutura geral que define uma palavra.' , 'false' , '61');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('So pode ser usada para linguagens finitas.' , 'false' , '61');");

		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (62, '1',     'Como definir uma linguagem'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('É definida usando umv “formador de conjuntos” ou Formalismo Descritivo' , 'true'  ,'62');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Definidas como parte de um componente de um compilador.' , 'false' , '62');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Pode definir como um conjunto de Strings em uma cadeira.' , 'false' , '62');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Pode ser abstrada para de finir a linguaem' , 'false' , '62');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Exerce a função da linguagem moderadora. , 'false' , '62');");

		db.execSQL(" insert into perguntas(_id, id_unidade, txt_pergunta) values (63, '1',     'Uma linguagem formal pode ser representada de 3 maneiras.'); ");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Enumeração das cadeias que fazem parte dela ,gramática e Dispositivo reconhecedor (máquina).' , 'true'  ,'63');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Identificadores de linguagens que são compostos, abastratos e definidps em base..' , 'false' , '63');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Gramática, relativa e abstrata' , 'false' , '63');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Fixa , nula e corrente' , 'false' , '63');");
		db.execSQL(" insert into respostas(txt_resposta, flag_verdadeiro, id_pergunta) values ('Cética em base de letras e sufixos.' , 'false' , '63');");

//------------------------------------------------------unidade 1 LEANDRO FIM --------------------------------------------------------------------------------------------------------------------------------

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

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
