package br.ufpb.Projetos.Atividades2;

public class AmigoNaoSorteadoException extends RuntimeException {
    public AmigoNaoSorteadoException(String message) {
        super(message);
    }
    public AmigoNaoSorteadoException(){
      super();
    }
}
