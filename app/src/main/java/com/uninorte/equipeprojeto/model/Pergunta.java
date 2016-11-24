package com.uninorte.equipeprojeto.model;

public class Pergunta {
    //
    private Integer _id;
    private String txt_pergunta;
    private String id_unidade;
    //

    public Pergunta() {
    }

    public Pergunta(Integer _id, String txt_pergunta, String id_unidade) {
        this._id = _id;
        this.txt_pergunta = txt_pergunta;
        this.id_unidade = id_unidade;
    }

    //
    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getTxt_pergunta() {
        return txt_pergunta;
    }

    public void setTxt_pergunta(String txt_pergunta) {
        this.txt_pergunta = txt_pergunta;
    }

    public String getId_unidade() {
        return id_unidade;
    }

    public void setId_unidade(String id_unidade) {
        this.id_unidade = id_unidade;
    }

}