package br.ufpb.Projetos.Prova1;

import java.io.Serializable;
import java.util.Objects;

public class Roupa implements Serializable {

    private String codigo;
    private String descricao;
    private int quantidade;
    private Tamanho tamanho;

    public Roupa (String codigo, String descricao, int quantidade, Tamanho tamanho){
        this.codigo=codigo;
        this.descricao=descricao;
        this.quantidade=quantidade;
        this.tamanho=tamanho;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String toString(){
        return "Roupa: "+this.descricao+"; De tamanho: "+this.tamanho+"; De codigo: "+this.codigo+"; E quantidade: "+this.quantidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roupa roupa = (Roupa) o;
        return Objects.equals(codigo, roupa.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }
}
