package br.ufpb.Projetos.Atividades2;

public class AmigoInexistenteException extends RuntimeException {
    public AmigoInexistenteException(String message) {
        super(message);
    }
    public AmigoInexistenteException(){
        super();
    }
}
