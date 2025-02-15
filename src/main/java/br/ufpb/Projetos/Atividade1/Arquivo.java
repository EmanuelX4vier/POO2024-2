package br.ufpb.Projetos.Atividade1;

import java.util.Objects;

public abstract  class Arquivo implements ArquivoDeTexto{

    private String titulo;
    private Data anoDeEscritura;
    private int quantCapitulos;

    public Arquivo(String titulo, Data anoDeEscritura, int quantCapitulos){
        this.titulo = titulo;
        this.anoDeEscritura = anoDeEscritura;
        this.quantCapitulos = quantCapitulos;
    }

    //perguntar o pq disso = public abstract int getNumPaginas();

   //get's
    public String getTitulo(){
        return this.titulo;
    }

    public Data getAnoDeEscritura(){
        return this.anoDeEscritura;
    }

    public int getQuantCapitulos(){
        return quantCapitulos;
    }

    //set's
    public void setTitulo(String novoTitulo){
        this.titulo = novoTitulo;
    }

    public void setAnoDeEscritura(Data novoAnoDeEscritura){
        this.anoDeEscritura = novoAnoDeEscritura;
    }

    public void setQuantCapitulos(int novaQuantCapitulos){
        this.quantCapitulos = novaQuantCapitulos;
    }

    //equals e hashcode


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Arquivo arquivo = (Arquivo) o;
        return anoDeEscritura == arquivo.anoDeEscritura && Objects.equals(titulo, arquivo.titulo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, anoDeEscritura);
    }
}
