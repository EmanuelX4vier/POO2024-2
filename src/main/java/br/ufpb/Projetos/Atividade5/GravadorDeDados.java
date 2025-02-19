package br.ufpb.Projetos.Atividade5;



import br.ufpb.Projetos.Prova1.Roupa;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

public class GravadorDeDados implements Serializable {

    private String listaAlunos;

    public GravadorDeDados(){
        this.listaAlunos = "listaAlunos.dat";
    }

    public void gravaDados(Collection<Aluno> alunos) throws IOException {
        ArrayList<Aluno> alunosArrayList= new ArrayList<>();
        alunosArrayList.addAll(alunos);
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(listaAlunos))){
            out.writeObject(alunos);
        }
    }

    public Collection<Aluno> recuperaDados() throws IOException{
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(this.listaAlunos))) {
            Collection<Aluno> alunosAchados = (ArrayList<Aluno>) in.readObject();
            return alunosAchados;
        } catch (ClassNotFoundException | ClassCastException e) {
            throw new IOException(e);
        }
    }
}
