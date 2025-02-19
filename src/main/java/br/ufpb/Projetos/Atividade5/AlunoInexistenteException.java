package br.ufpb.Projetos.Atividade5;

public class AlunoInexistenteException extends Exception {
    public AlunoInexistenteException (String msg){
        super(msg);
    }

    public AlunoInexistenteException(){
        super();
    }
}
