package br.ufpb.Projetos.AtividadePosto;

public class AtendimentoNaoCadastradoException extends Exception{
    public AtendimentoNaoCadastradoException(String msg){
        super(msg);
    }
    public AtendimentoNaoCadastradoException(){
        super();
    }
}
