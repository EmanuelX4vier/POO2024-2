package br.ufpb.Projetos.Atividade5;

import java.io.IOException;

public class ProgramaCadastraAluno {

    public static void main (String [] args) {
        SistemaCadastraAluno sistema = new SistemaCadastraAluno();
        try{
            sistema.recuperarDados();
        } catch (IOException e) {
            e.getStackTrace();
        }
        try{
            sistema.cadastraAluno("Emanuel", "20240102573");
            sistema.cadastraAluno("Leticia", "1234567890");
            sistema.cadastraAluno("Anderson", "0123456789");
        } catch (AlunoJaCadastradoException e) {
            e.getMessage();
        }
            System.out.println(sistema.todosOsAlunos());
        try{
            sistema.removeAluno("0123456789");
        } catch (AlunoInexistenteException e) {
            e.getMessage();
        }
        System.out.println(sistema.todosOsAlunos());
        try{
            System.out.println(sistema.pesquisaAluno("20240102573"));
        } catch (AlunoInexistenteException e) {
            e.getMessage();
        }
        try{
            sistema.salvarDados();
        } catch (IOException e) {
            e.getStackTrace();
        }
    }
}
