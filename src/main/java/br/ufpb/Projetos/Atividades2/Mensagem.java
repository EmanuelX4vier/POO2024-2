package br.ufpb.Projetos.Atividades2;

public abstract class Mensagem {

   private String texto;
   private String emailRemetente;
   private boolean anonimo;

    public Mensagem (String texto, String emailRemetente, boolean anonima){
        this.texto = texto;
        this.emailRemetente = emailRemetente;
        this.anonimo = anonima;
    }
    public abstract String getTextoCompletoAExibir(); //A classe é abstrata pois pode ser tratada de várias formas em diferentes classes.



    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) {
        this.emailRemetente = emailRemetente;
    }
    public boolean ehAnonimo(){
        return this.anonimo;
    }

}
