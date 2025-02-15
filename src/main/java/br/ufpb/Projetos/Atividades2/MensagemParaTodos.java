package br.ufpb.Projetos.Atividades2;

public class MensagemParaTodos extends Mensagem{

    public MensagemParaTodos(String texto, String emailRemetente, boolean anonimo){
        super(texto, emailRemetente, anonimo);
    }

    @Override
    public String getTextoCompletoAExibir() {
        if(super.ehAnonimo()){
            return "Para todos: "+super.getTexto();
        }else{
            return "De:"+super.getEmailRemetente()+" para todos: "+super.getTexto();
        }
    }
}
