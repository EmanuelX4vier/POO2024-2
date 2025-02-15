package AtividadePosto;
import static org.junit.jupiter.api.Assertions.*;

import br.ufpb.Projetos.AtividadePosto.AtendimentoMedico;
import br.ufpb.Projetos.AtividadePosto.CategoriaAtendimento;
import br.ufpb.Projetos.AtividadePosto.Data;
import br.ufpb.Projetos.AtividadePosto.SistemaGerenciadorAtendimentosPosto;
import org.junit.jupiter.api.Test;

import java.util.Collection;

public class SistemaGerenciadorAtendimentosPostoTest {

    @Test
    public void testaCadastroMedico(){
        SistemaGerenciadorAtendimentosPosto sistema = new SistemaGerenciadorAtendimentosPosto();
        try {
            sistema.cadastrarMedico("11111", "Ana Julia Lopes");
            sistema.cadastrarAtendimento("123", CategoriaAtendimento.CARDIOLOGICO, "222.222.222-22", "11111", new Data(8,8, 2024));
            Collection<AtendimentoMedico> atendimentosData = sistema.pesquisaAtendimentosDoDia(new Data(8,8,2024));
            assertEquals(1, atendimentosData.size());
            assertTrue(atendimentosData.size()==1);
            sistema.cadastrarMedico("22222", "Dr João");
            sistema.cadastrarAtendimento("124", CategoriaAtendimento.ORTOPEDICO, "222.222.222-22", "22222", new Data(8,8,2024));
            int quantOrtopedicos = sistema.contaAtendimentosDaCategoria(CategoriaAtendimento.ORTOPEDICO);
            assertEquals(1, quantOrtopedicos);

            Collection<AtendimentoMedico> atendimentosDia8 = sistema.pesquisaAtendimentosDoDia(new Data(8,8, 2024));
            assertEquals(2, atendimentosDia8.size());
            int quantAtendimentosDrJoao = sistema.contaAtendimentosDeMedicoNoMes("22222", 8, 2024);
            assertTrue(quantAtendimentosDrJoao==1);
            int quantAtendimentosDrJoaoJan25 = sistema.contaAtendimentosDeMedicoNoMes("22222", 1, 2025);
            assertTrue(quantAtendimentosDrJoaoJan25==0);


        } catch (Exception e){
            e.printStackTrace();
            fail("Não deveria lançar a exceção");

        }
    }

}
