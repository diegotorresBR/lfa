package com.uninorte.equipeprojeto.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.uninorte.equipeprojeto.model.Resposta;

import java.util.ArrayList;
import java.util.List;

public class RespostaDAO {
    //
    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;
    //
    public RespostaDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDatabase(){
        if (database == null){
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    private Resposta criarResposta(Cursor cursor){
        Resposta model = new Resposta(
                cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Respostas._ID)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Respostas.TXT_RESPOSTA)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Respostas.FLAG_VERDADEIRO)),
                cursor.getString(cursor.getColumnIndex(DatabaseHelper.Respostas.ID_PERGUNTA))
        );
        return model;
    }


    public List<Resposta> ListarResposta(){
        Cursor cursor = getDatabase().query(DatabaseHelper.Respostas.TABELA
                                            , DatabaseHelper.Respostas.COLUNAS
                                            , null,null,null,null,null);
        List<Resposta> respostas = new ArrayList<Resposta>();
        while (cursor.moveToNext()){
            Resposta model = criarResposta(cursor);
            respostas.add(model);
        }
        cursor.close();
        return respostas;
    }

    public List<Resposta> ListarRespostaPorIDPergunta(int id) {
        Cursor cursor = getDatabase().query(DatabaseHelper.Respostas.TABELA
                                            , DatabaseHelper.Respostas.COLUNAS
                                            , "id_pergunta = ?"
                                            , new String[]{Integer.toString(id)}
                                            , null, null, null);
        List<Resposta> respostas = new ArrayList<Resposta>();
        while (cursor.moveToNext()){
            Resposta model = criarResposta(cursor);
            respostas.add(model);
        }
        cursor.close();
        return respostas;
    }

    public Resposta buscarRespostaPorId(int id) {
        Cursor cursor = getDatabase().query(DatabaseHelper.Respostas.TABELA
                                            , DatabaseHelper.Respostas.COLUNAS
                                            , "_id = ?"
                                            , new String[]{Integer.toString(id)}
                                            , null, null, null);
        if (cursor.moveToNext()) {
            Resposta model = criarResposta(cursor);
            cursor.close();
            return model;
        }

        return null;
    }

    public long salvarResposta(Resposta resposta){
        ContentValues valores  = new ContentValues();
        valores.put(DatabaseHelper.Respostas.FLAG_VERDADEIRO, resposta.getFlag_verdadeiro());
        valores.put(DatabaseHelper.Respostas.ID_PERGUNTA, resposta.getId_pergunta());
        valores.put(DatabaseHelper.Respostas.TXT_RESPOSTA, resposta.getTxt_resposta());


        if (resposta.get_id() != null) {//se o id ja existe, então deve atualizar o registro
            return getDatabase().update(DatabaseHelper.Respostas.TABELA
                    , valores
                    , "_id = ?"
                    , new String[]{resposta.get_id().toString()});
        }
        ////caso o registro não exista, então faça o insert do registro
        return getDatabase().insert(DatabaseHelper.Respostas.TABELA, null, valores);
    }

    public boolean removerResposta(int id) {
        return getDatabase().delete(DatabaseHelper.Respostas.TABELA
                , "_id = ?"
                , new String[]{Integer.toString(id)}) > 0;
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
