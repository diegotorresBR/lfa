package com.uninorte.equipeprojeto.model;

public class Resposta {
    private Integer _id;
    private String txt_resposta;
    private String flag_verdadeiro;
    private String id_pergunta;
    //
    public Resposta(Integer _id
                    , String txt_resposta
                    , String flag_verdadeiro
                    , String id_pergunta) {
        this._id = _id;
        this.txt_resposta = txt_resposta;
        this.flag_verdadeiro = flag_verdadeiro;
        this.id_pergunta = id_pergunta;
    }
    public Resposta(){}
    //
    public Integer get_id() {
        return _id;
    }

    public void set_id(Integer _id) {
        this._id = _id;
    }

    public String getTxt_resposta() {
        return txt_resposta;
    }

    public void setTxt_resposta(String txt_resposta) {
        this.txt_resposta = txt_resposta;
    }

    public String getFlag_verdadeiro() {
        return flag_verdadeiro;
    }

    public void setFlag_verdadeiro(String flag_verdadeiro) {
        this.flag_verdadeiro = flag_verdadeiro;
    }

    public String getId_pergunta() {
        return id_pergunta;
    }

    public void setId_pergunta(String id_pergunta) {
        this.id_pergunta = id_pergunta;
    }

}
