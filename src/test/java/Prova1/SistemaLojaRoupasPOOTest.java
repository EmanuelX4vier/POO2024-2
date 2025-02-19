package Prova1;

import br.ufpb.Projetos.Prova1.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class SistemaLojaRoupasPOOTest {

    @Test
    public void testaCadastro() throws RoupaJaExisteException, RoupaInexistenteException {

        GravadorDeRoupas gravador = new GravadorDeRoupas();
        SistemaLojaRoupasPOO sistema = new SistemaLojaRoupasPOO();
        sistema.cadastraRoupa("123", "Calça jeans escura", 30 , Tamanho.M);
        Roupa roupa = sistema.pesquisaRoupa("123");
        assertEquals("123", roupa.getCodigo());
        assertEquals("Calça jeans escura", roupa.getDescricao());
        assertEquals(roupa.getQuantidade(), 30);


    }
}
