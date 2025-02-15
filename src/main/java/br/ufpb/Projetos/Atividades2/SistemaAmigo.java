package br.ufpb.Projetos.Atividades2;

import java.util.ArrayList;
import java.util.List;

public class SistemaAmigo {

    private List<Mensagem> mensagens;
    private List<Amigo> amigos;

    public SistemaAmigo (){
        this.mensagens = new ArrayList<>();
        this.amigos = new ArrayList<>();
    }


    public boolean testaSeAmigoJaFoiCadastrado (String nome, String email){
        for(Amigo a: this.amigos){
            if(a.getNome().equalsIgnoreCase(nome) && a.getEmail().equalsIgnoreCase(email)){
                return true;
            }
        }
        return false;
    }

    public void cadastrarAmigo(String nome, String email) throws AmigoJaExisteException{
        Amigo amigo = new Amigo(nome, email);
        if (testaSeAmigoJaFoiCadastrado(nome, email)) {
            throw new AmigoJaExisteException("Amigo já cadastrado.");
        }
        this.amigos.add(amigo);
    }

    public Amigo pesquisaAmigo (String emailAmigo) throws AmigoInexistenteException{
        for (Amigo a: this.amigos){
            if(a.getEmail().equalsIgnoreCase(emailAmigo)){
                return a;
            }
        }
        throw new AmigoInexistenteException("Este amigo não foi cadastrado");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonimo){
        Mensagem mensagem = new MensagemParaTodos(texto, emailRemetente, anonimo);
        this.mensagens.add(mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonimo){
        Mensagem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonimo);
        this.mensagens.add(mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas (){
        List<Mensagem>mensagens = new ArrayList<>();
        for(Mensagem m: this.mensagens){
            if(m.ehAnonimo()){
                mensagens.add(m);
            }
        }
        return mensagens;
    }

    public List<Mensagem> pesquisaTodasAsMensagens(){
        return this.mensagens;
    }

    public void configuraAmigoSecretoDe(String email, String emailDoSorteado) throws AmigoInexistenteException{
        for(Amigo a: this.amigos){
            try{
                if(a.getEmail().equalsIgnoreCase(email)){
                    a.setEmailAmigoSorteado(emailDoSorteado);
                }
            }catch (AmigoInexistenteException e){
                throw new AmigoInexistenteException("Amigo não cadastrado");
            }
        }
    }

    public String pesquisaAmigoSecretoDe(String email){
        for(Amigo a: this.amigos){
            if(a.getEmail().equalsIgnoreCase(email)){
                return a.getEmailAmigoSorteado();
            }
        }
        throw new AmigoInexistenteException("Amigo não cadastrado");
    }

    public List<Amigo> getAmigos(){
        return this.amigos;
    }
}
