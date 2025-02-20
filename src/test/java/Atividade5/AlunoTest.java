package Atividade5;

import static org.junit.jupiter.api.Assertions.*;
import br.ufpb.Projetos.Atividade5.Aluno;
import br.ufpb.Projetos.Atividade5.GravadorDeDados;
import br.ufpb.Projetos.Atividade5.SistemaCadastraAluno;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
public class AlunoTest {

    @Test
    public void testaGravador() throws IOException {
        GravadorDeDados gravador = new GravadorDeDados();
        List<Aluno> alunos = new ArrayList<>();
        Aluno aluno1 = new Aluno("Emanuel", "20230102573");
        Aluno aluno2 = new Aluno("Leticia", "1234567890");
        Aluno aluno3 = new Aluno("Anderson", "0123456789");
        alunos.add(aluno1);
        alunos.add(aluno2);
        alunos.add(aluno3);
        gravador.gravaDados(alunos);
        List<Aluno> alunosRecuperados = new ArrayList<>(gravador.recuperaDados());
        System.out.println(alunos);
        System.out.println(alunosRecuperados);
    }


    @Test
    public void testaCadastroAluno() throws IOException {

        SistemaCadastraAluno sistema = new SistemaCadastraAluno();
        try{
            sistema.recuperarDados();
        } catch (IOException e) {
            e.getStackTrace();
        }
        Aluno aluno1 = new Aluno("Emanuel", "20230102573");
        Aluno aluno2 = new Aluno("Leticia", "1234567890");
        assertEquals("Emanuel", aluno1.getNome());
        assertEquals("Leticia", aluno2.getNome());
        assertEquals("20230102573", aluno1.getMatricula());
        assertEquals("1234567890", aluno2.getMatricula());
        try{
            sistema.salvarDados();
        }catch (IOException e){
            e.getStackTrace();
        }

    }
}
