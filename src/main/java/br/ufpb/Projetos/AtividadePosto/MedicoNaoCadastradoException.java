package br.ufpb.Projetos.AtividadePosto;

public class MedicoNaoCadastradoException extends Exception{
    public MedicoNaoCadastradoException(String msg){
        super(msg);
    }
    public MedicoNaoCadastradoException(){
        super();
    }
}
