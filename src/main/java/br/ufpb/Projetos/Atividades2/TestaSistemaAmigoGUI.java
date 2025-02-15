package br.ufpb.Projetos.Atividades2;

import org.w3c.dom.ls.LSOutput;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class TestaSistemaAmigoGUI {

    public static void main(String[] args) {
        //a
        SistemaAmigo sistema = new SistemaAmigo();
        //b
        int quantAmigos = Integer.parseInt(JOptionPane.showInputDialog(null, "Quantos amigos vão participar?"));
        JOptionPane.showMessageDialog(null, quantAmigos + " amigos.");
        //c
        for (int k = 0; k < quantAmigos; k++) {

            String nome = JOptionPane.showInputDialog(null, "Qual o nome do amigo?");
            String email = JOptionPane.showInputDialog(null, "Qual o email do amigo?");

            try {
                sistema.cadastrarAmigo(nome, email);
                JOptionPane.showMessageDialog(null, "Amigo cadastrado com sucesso.");
            } catch (AmigoJaExisteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        //d
        List<Amigo> todos = new ArrayList<>();
        for (Amigo a : sistema.getAmigos()) {
            JOptionPane.showMessageDialog(null, "Sua vez de cadastrar seu amigo secreto: " + a.getNome());
            try {
                String emailDoSorteado = JOptionPane.showInputDialog(null, "Digite o email do amigo sorteado");
                sistema.configuraAmigoSecretoDe(a.getEmail(), emailDoSorteado);
                System.out.println(emailDoSorteado);
            } catch (AmigoInexistenteException e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        }

        //e (teste para ver se vai enviar para todos)
        for (Amigo a : sistema.getAmigos()) {
            int conf = JOptionPane.showConfirmDialog(null, "Deseja enviar uma mensagem? " + a);
            if (conf == 0) {
                String mensagem = JOptionPane.showInputDialog(null, "Digite sua mensagem:");
                int anonimo = JOptionPane.showConfirmDialog(null, "É anonima?");
                if (anonimo == 0) {
                    sistema.enviarMensagemParaTodos(mensagem, a.getEmail(), true);
                } else if (anonimo == 1) {
                    sistema.enviarMensagemParaTodos(mensagem, a.getEmail(), false);
                }
            }
        }
        List<Mensagem> mensagens = sistema.pesquisaTodasAsMensagens();
        for(Mensagem m: mensagens){
            JOptionPane.showMessageDialog(null, m.getTextoCompletoAExibir());
        }
    }
}

