package com.uninorte.equipeprojeto.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.uninorte.equipeprojeto.model.Pergunta;

import java.util.ArrayList;
import java.util.List;

public class PerguntaDAO {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public PerguntaDAO(Context context) {
        databaseHelper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDatabase() {
        if (database == null) {
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    private Pergunta criarPergunta(Cursor cursor) {

        Pergunta model = new Pergunta(
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Perguntas._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Perguntas.TXT_PERGUNTA)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Perguntas.ID_UNIDADE))
        );
        return model;
    }

    public List<Pergunta> ListarPergunta() {
        Cursor cursor = getDatabase().query(DatabaseHelper.Perguntas.TABELA
                                            , DatabaseHelper.Perguntas.COLUNAS
                                            , null, null, null, null, null);
        List<Pergunta> perguntas = new ArrayList<Pergunta>();
        while (cursor.moveToNext()) {
            Pergunta model = criarPergunta(cursor);
            perguntas.add(model);
        }
        cursor.close();
        return perguntas;
    }
    public List<Pergunta> ListarPerguntaPorUnidade(int idUnidade) {
        Cursor cursor = getDatabase().query(DatabaseHelper.Respostas.TABELA
                                            , DatabaseHelper.Respostas.COLUNAS
                                            , "id_unidade = ?"
                                            , new String[]{Integer.toString(idUnidade)}
                                            , null, null, null);
        List<Pergunta> perguntas = new ArrayList<Pergunta>();
        while (cursor.moveToNext()){
            Pergunta model = criarPergunta(cursor);
            perguntas.add(model);
        }
        cursor.close();
        return perguntas;
    }
    public long salvarPergunta(Pergunta pergunta) {
        ContentValues valores = new ContentValues();
        valores.put(DatabaseHelper.Perguntas.ID_UNIDADE, pergunta.getId_unidade());//voltar aqui
        valores.put(DatabaseHelper.Perguntas.TXT_PERGUNTA, pergunta.getTxt_pergunta());

        if (pergunta.get_id() != null) {//se o id ja existe, então deve atualizar o registro
            return getDatabase().update(DatabaseHelper.Perguntas.TABELA
                    , valores
                    , "_id = ?"
                    , new String[]{pergunta.get_id().toString()});
        }
        ////caso o registro não exista, então faça o insert do registro
        return getDatabase().insert(DatabaseHelper.Perguntas.TABELA, null, valores);
    }

    public boolean removerPergunta(int id) {
        return getDatabase().delete(DatabaseHelper.Perguntas.TABELA
                , "_id = ?"
                , new String[]{Integer.toString(id)}) > 0;
    }

    public Pergunta buscarPerguntaPorId(int id) {
        Cursor cursor = getDatabase().query(DatabaseHelper.Perguntas.TABELA
                , DatabaseHelper.Perguntas.COLUNAS
                , "_id = ?"
                , new String[]{Integer.toString(id)}
                , null, null, null);
        if (cursor.moveToNext()) {
            Pergunta model = criarPergunta(cursor);
            cursor.close();
            return model;
        }

        return null;
    }

    public void fechar() {
        databaseHelper.close();
        database = null;
    }

//    public boolean logar(String usuario, String senha) {
//        Cursor cursor = getDatabase().query(DatabaseHelper.Usuarios.TABELA
//                , null, "LOGIN = ? AND SENHA = ?"
//                , new String[]{usuario, senha}
//                , null, null, null);
//
//        if (cursor.moveToFirst()) {
//            return true;
//        }
//
//        return false;
//    }

}
