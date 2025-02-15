package Atividade2;

import static org.junit.jupiter.api.Assertions.*;

import br.ufpb.Projetos.Atividades2.Amigo;
import org.junit.jupiter.api.Test;

public class AmigoTest {

    @Test
    public void testaConstrutor(){
        Amigo amigo1 = new Amigo("Emanuel", "emanuelxssi@gmail.com");
        assertTrue(amigo1.getNome().equals("Emanuel"));
        assertEquals("emanuelxssi@gmail.com", amigo1.getEmail());
    }//OK
}
