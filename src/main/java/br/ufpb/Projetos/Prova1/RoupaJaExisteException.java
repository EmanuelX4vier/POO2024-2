package br.ufpb.Projetos.Prova1;

public class RoupaJaExisteException extends Exception{
    public RoupaJaExisteException(String msg){
        super(msg);
    }
    public RoupaJaExisteException(){
        super();
    }
}
