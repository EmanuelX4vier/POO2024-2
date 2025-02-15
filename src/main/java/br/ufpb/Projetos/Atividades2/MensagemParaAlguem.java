package br.ufpb.Projetos.Atividades2;

public class MensagemParaAlguem extends Mensagem{

    private String emailDestinatario;

    public MensagemParaAlguem (String texto, String emailRemetente, String emailDestinatario, boolean anonimo){
        super(texto, emailRemetente, anonimo);
        this.emailDestinatario = emailDestinatario;
    }

    public String getEmailDestinatario() {
        return emailDestinatario;
    }

    public void setEmailDestinatario(String emailDestinatario) {
        this.emailDestinatario = emailDestinatario;
    }

    @Override
    public String getTextoCompletoAExibir() {
        if(ehAnonimo()){
            return "Texto: "+super.getTexto();
        }else{
            return "De: "+super.getEmailRemetente()+"Para: "+getEmailDestinatario()+" Texto:"+super.getTexto();
        }
    }


}
