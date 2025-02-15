package br.ufpb.Projetos.Atividades2;

public class AmigoJaExisteException extends Exception{
    public AmigoJaExisteException(String msg){
        super(msg);
    }
    public AmigoJaExisteException(){
        super();
    }
}
