package com.uninorte.equipeprojeto.model;

public class Unidade {
    private Integer _id;
    private String txt_titulo;
    private String txt_descricao;

    public Unidade(Integer _id, String txt_titulo, String txt_descricao) {
        this._id = _id;
        this.txt_titulo = txt_titulo;
        this.txt_descricao = txt_descricao;
    }

    public Unidade(){

    }

    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getTxt_titulo() {
        return txt_titulo;
    }

    public void setTxt_titulo(String txt_titulo) {
        this.txt_titulo = txt_titulo;
    }

    public String getTxt_descricao() {
        return txt_descricao;
    }

    public void setTxt_descricao(String txt_descricao) {
        this.txt_descricao = txt_descricao;
    }


}
