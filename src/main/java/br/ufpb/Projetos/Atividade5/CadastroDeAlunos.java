package br.ufpb.Projetos.Atividade5;
import java.util.Collection;
import java.io.IOException;
public interface CadastroDeAlunos {

      void cadastraAluno(String nome, String matricula) throws AlunoJaCadastradoException;
      Aluno pesquisaAluno(String matricula) throws AlunoInexistenteException;
      void removeAluno(String nome) throws AlunoInexistenteException;
      void salvarDados() throws IOException;
      void recuperarDados() throws IOException;
}
