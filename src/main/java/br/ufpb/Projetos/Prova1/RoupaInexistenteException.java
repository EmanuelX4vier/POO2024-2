package br.ufpb.Projetos.Prova1;

public class RoupaInexistenteException extends Exception{
    public RoupaInexistenteException(String msg){
        super(msg);
    }
    public RoupaInexistenteException(){
        super();
    }
}
