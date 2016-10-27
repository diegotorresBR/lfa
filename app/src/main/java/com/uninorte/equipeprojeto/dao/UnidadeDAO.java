package com.uninorte.equipeprojeto.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.uninorte.equipeprojeto.model.Unidade;

import java.util.ArrayList;
import java.util.List;

public class UnidadeDAO {

    private DatabaseHelper databaseHelper;
    private SQLiteDatabase database;

    public UnidadeDAO(Context context){
        databaseHelper = new DatabaseHelper(context);
    }

    private SQLiteDatabase getDatabase(){
        if (database==null){
            database = databaseHelper.getWritableDatabase();
        }
        return database;
    }

    private Unidade criarUnidade(Cursor cursor){
        Unidade model = new Unidade(
          cursor.getInt(cursor.getColumnIndex(DatabaseHelper.Unidade._ID)),
          cursor.getString(cursor.getColumnIndex(DatabaseHelper.Unidade.DESCRICAO)),
          cursor.getString(cursor.getColumnIndex(DatabaseHelper.Unidade.TITULO))
        );
        return model;
    }

    public List<Unidade> ListarUnidade(){
        Cursor cursor = getDatabase().query(DatabaseHelper.Unidade.TABELA
                                            , DatabaseHelper.Unidade.COLUNAS
                                            , null,null,null,null,null);
        List<Unidade> unidades = new ArrayList<Unidade>();
        while (cursor.moveToNext()){
            Unidade model = criarUnidade(cursor);
            unidades.add(model);
        }
        cursor.close();
        return unidades;
    }

    public long salvarUnidade(Unidade unidade){
        ContentValues valores  = new ContentValues();
        valores.put(DatabaseHelper.Unidade.DESCRICAO, unidade.getTxt_descricao());
        valores.put(DatabaseHelper.Unidade.TITULO, unidade.getTxt_titulo());

        if (unidade.get_id() != null) {//se o id ja existe, então deve atualizar o registro
            return getDatabase().update(DatabaseHelper.Unidade.TABELA
                    , valores
                    , "_id = ?"
                    , new String[]{unidade.get_id().toString()});
        }
        ////caso o registro não exista, então faça o insert do registro
        return getDatabase().insert(DatabaseHelper.Unidade.TABELA, null, valores);
    }

    public boolean removerUnidade(int id) {
        return getDatabase().delete(DatabaseHelper.Unidade.TABELA
                                    , "_id = ?"
                                    , new String[]{Integer.toString(id)}) > 0;
    }

    public Unidade buscarUnidadePorId(int id) {
        Cursor cursor = getDatabase().query(DatabaseHelper.Unidade.TABELA
                                            , DatabaseHelper.Unidade.COLUNAS
                                            , "_id = ?"
                                            , new String[]{Integer.toString(id)}
                                            , null, null, null);
        if (cursor.moveToNext()) {
            Unidade model = criarUnidade(cursor);
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
