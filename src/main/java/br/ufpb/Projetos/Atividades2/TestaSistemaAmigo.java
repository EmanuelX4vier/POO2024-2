package br.ufpb.Projetos.Atividades2;

import java.util.EmptyStackException;

public class TestaSistemaAmigo {
    public static void main(String [] args) {
        //a
        SistemaAmigo sistema = new SistemaAmigo();
        try {
            sistema.cadastrarAmigo("José", "jose@gmail.com");
            sistema.cadastrarAmigo("Maria", "maria@gmail.com");

        } catch (AmigoJaExisteException e) {
            System.out.println(e.getMessage());
        }
        //b
        try {
            sistema.configuraAmigoSecretoDe("jose@gmail.com", "maria@gmail.com");
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }
        //c
        try {
            sistema.enviarMensagemParaAlguem("Olá", "maria@gmail.com", "jose@gmail.com", true);
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }
        //d
        try {
            sistema.enviarMensagemParaTodos("Olá a todos", "maria@gmail.com", true);
        } catch (AmigoInexistenteException e) {
            System.out.println(e.getMessage());
        }
        //e
        try {
            for (Mensagem m : sistema.pesquisaMensagensAnonimas()) {
                System.out.println(m.getTextoCompletoAExibir());
            }
        } catch (EmptyStackException e) {
            System.out.println(e.getMessage());
        }
        //f
        try{
            System.out.println(sistema.pesquisaAmigoSecretoDe("jose@gmail.com"));
            System.out.println("OK");
        }catch (AmigoInexistenteException e){
            System.out.println(e.getMessage());
        }
    }
}
