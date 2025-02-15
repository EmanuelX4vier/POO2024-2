package br.ufpb.Projetos.Atividade1;

public class Capitulo extends Arquivo {

    private int quantPaginas;

    public void ler() {
        System.out.println("Lendo: "+super.getTitulo());
    }

    public Capitulo(String titulo, Data anoDeEscritura, int quantCapitulos, int quantPaginas) throws NumberFormatException{
        super(titulo, anoDeEscritura, 1);
        if(quantPaginas == 0){
            throw new NumberFormatException("Capítulo sem páginas.");
        }else{
            this.quantPaginas = quantPaginas;
        }

    }

    public Capitulo() throws NumberFormatException{
        this("Sem titulo", new Data(), 0, 0);
        throw new NumberFormatException("Capítulo sem páginas.");
    }

    //get's

    public String getNomeDoCapitulo(){
        return super.getTitulo();
    }

    public int getQuantPaginas(){
        return quantPaginas;
    }

    @Override
    public String toString() {
        return "Capítulo de nome"+super.getTitulo();
    }
}
