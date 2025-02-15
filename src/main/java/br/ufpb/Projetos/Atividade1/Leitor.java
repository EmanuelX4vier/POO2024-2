package br.ufpb.Projetos.Atividade1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Leitor {
    public static void main (String [] args){
        Scanner leitor = new Scanner(System.in);
        List<Arquivo> livros = new ArrayList<>();
        List<Arquivo> capitu = new ArrayList<>();

        Livro livro1 = new Livro("A revolução dos bichos", new Data(), 12);
        livros.add(livro1);

        try{
            System.out.println("Digite a quantidade paginas do cap");
            int pag = Integer.parseInt(leitor.nextLine());
            Capitulo capitulo1 = new Capitulo("", new Data(), 0, 0);
            capitu.add(capitulo1);
        } catch (NumberFormatException e) {
            e.getMessage();
        }



        System.out.println(livros.toString());
        System.out.println(capitu.toString());
        leitor.close();
    }
}
