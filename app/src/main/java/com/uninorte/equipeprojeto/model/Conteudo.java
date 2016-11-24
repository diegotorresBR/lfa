package com.uninorte.equipeprojeto.model;

/**
 * Created by diego on 10/28/16.
 * Classe model do conteudo associado a sua pagina html respectivamente
 */

public class Conteudo {

    String conteudo, pagina;

    public String getPagina() {
        return pagina;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setPagina(String pagina) {
        this.pagina = pagina;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }
}
