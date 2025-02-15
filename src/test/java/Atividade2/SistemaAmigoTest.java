package Atividade2;

import static org.junit.jupiter.api.Assertions.*;

import br.ufpb.Projetos.Atividades2.*;
import org.junit.jupiter.api.Test;

public class SistemaAmigoTest {

    SistemaAmigo sistema = new SistemaAmigo();
    @Test
    public void testaCadastrarAmigo(){
        try{
            //Testes referentes a amigo
            sistema.cadastrarAmigo("Emanuel", "emanuelxssi@gmail.com");
            sistema.cadastrarAmigo("Irineu", "vcnsabenemeu@gmail.com");
            assertTrue(sistema.testaSeAmigoJaFoiCadastrado("Emanuel", "emanuelxssi@gmail.com"));
            assertTrue(sistema.testaSeAmigoJaFoiCadastrado("Irineu", "vcnsabenemeu@gmail.com"));
            assertEquals("Emanuel", sistema.pesquisaAmigo("emanuelxssi@gmail.com").getNome());
            assertEquals("emanuelxssi@gmail.com", sistema.pesquisaAmigo("emanuelxssi@gmail.com").getEmail());
        } catch (AmigoJaExisteException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
