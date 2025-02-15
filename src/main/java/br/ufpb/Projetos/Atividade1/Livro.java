package br.ufpb.Projetos.Atividade1;
import java.util.ArrayList;
import java.util.List;

public class Livro extends Arquivo {

    private int capitulos;

    public void ler() {
        System.out.println("Lendo: " + super.getTitulo() + ".");
    }

    public Livro(String titulo, Data anoDeEscritura, int quantCap) {
        super(titulo, anoDeEscritura, quantCap);
    }

    List<Capitulo> listaDeCap = new ArrayList<>();

    //perguntar pq inicia duas vezes de forma diferentes
    public Livro(String titulo, Data anoDeEscritura) {
        this("Faltou", new Data(), 0);

    }

    //get's
    public int getQuantCapitulosDoLivro(){
        return super.getQuantCapitulos();
    }

    public int getQuantPaginasTotais(){
        int cont = 0;
        for (Capitulo c: listaDeCap){
            cont+=c.getQuantPaginas();
        }
        return cont;
    }

    //toString, equals e hashcode
    public String toString(){
        return "Livro: "+super.getTitulo()+"; lançado em: "+getAnoDeEscritura()+" Com: "+getQuantCapitulosDoLivro()+" capitulos; Com: "+getQuantPaginasTotais()+" páginas.";
    }
}


