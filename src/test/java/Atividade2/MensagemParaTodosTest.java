package Atividade2;

import static org.junit.jupiter.api.Assertions.*;

import br.ufpb.Projetos.Atividades2.*;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.ArrayList;
import java.util.EmptyStackException;

public class MensagemParaTodosTest {
    @Test
    public void testandoMensagem(){
        MensagemParaTodos mensagem = new MensagemParaTodos("Olá", "emanuelxssi@gmail.com", true);
        assertEquals("Para todos: Olá", mensagem.getTextoCompletoAExibir());
        MensagemParaTodos mensagem2 = new MensagemParaTodos("Olá", "emanuelxssi@gmail.com", false);
        assertEquals("De:emanuelxssi@gmail.com para todos: Olá", mensagem2.getTextoCompletoAExibir());
    }//OK
}
