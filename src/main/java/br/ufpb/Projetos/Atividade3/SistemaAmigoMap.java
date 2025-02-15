package br.ufpb.Projetos.Atividade3;

import br.ufpb.Projetos.Atividades2.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAmigoMap {

    private Map<String, Mensagem> mensagens;
    private Map<String, Amigo> amigos;

    public SistemaAmigoMap() {
        this.mensagens = new HashMap<>();
        this.amigos = new HashMap<>();
    }

    public void cadastrarAmigo(String nome, String email) throws AmigoJaExisteException {
        Amigo amigo = new Amigo(nome, email);
        if (this.amigos.containsKey(nome)) {
            throw new AmigoJaExisteException("Amigo já cadastrado.");
        }
        this.amigos.put(email, amigo);
    }

    public Amigo pesquisaAmigo(String emailAmigo) throws AmigoInexistenteException {
        if (this.amigos.containsKey(emailAmigo)) {
            return this.amigos.get(emailAmigo);
        }
        throw new AmigoInexistenteException("Este amigo não foi cadastrado");
    }

    public void enviarMensagemParaTodos(String texto, String emailRemetente, boolean anonimo) {
        Mensagem mensagem = new MensagemParaTodos(texto, emailRemetente, anonimo);
        this.mensagens.put(emailRemetente, mensagem);
    }

    public void enviarMensagemParaAlguem(String texto, String emailRemetente, String emailDestinatario, boolean anonimo) {
        Mensagem mensagem = new MensagemParaAlguem(texto, emailRemetente, emailDestinatario, anonimo);
        this.mensagens.put(emailRemetente, mensagem);
    }

    public List<Mensagem> pesquisaMensagensAnonimas() {
        List<Mensagem> mensagens = new ArrayList<>();
        for (Mensagem m : this.mensagens.values()) {
            if (m.ehAnonimo()) {
                mensagens.add(m);
            }
        }
        return mensagens;
    }

    public List<Mensagem> pesquisaTodasAsMensagens() {
        return new ArrayList<>(this.mensagens.values());
    }

    public void configuraAmigoSecretoDe(String email, String emailDoSorteado) throws AmigoInexistenteException {
        for (Amigo a : this.amigos.values()) {
            try {
                if (a.getEmail().equalsIgnoreCase(email)) {
                    a.setEmailAmigoSorteado(emailDoSorteado);
                }
            } catch (AmigoInexistenteException e) {
                throw new AmigoInexistenteException("Amigo não cadastrado");
            }
        }
    }

    public String pesquisaAmigoSecretoDe(String email) {
        for (Amigo a : this.amigos.values()) {
            if (a.getEmail().equalsIgnoreCase(email)) {
                return a.getEmailAmigoSorteado();
            }
        }
        throw new AmigoInexistenteException("Amigo não cadastrado");

    }

    public List<Amigo> getAmigos(){
        return new ArrayList<>(this.amigos.values());
    }
}
