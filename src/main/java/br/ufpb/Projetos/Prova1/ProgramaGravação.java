package br.ufpb.Projetos.Prova1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class ProgramaGravação {
    public static void main (String [] args){

        List<Roupa> roupas = new LinkedList<>();
        Roupa r1 = new Roupa("444", "calça rosa", 10, Tamanho.G);
        Roupa r2 = new Roupa("888", "bermuda azul", 2, Tamanho.M);
        roupas.add(r1);
        roupas.add(r2);

        GravadorDeRoupas gravadorDeRoupas = new GravadorDeRoupas();
        System.out.println("Recuperando roupas...");

        try{
            Collection<Roupa> roupasAchadas = gravadorDeRoupas.recuperarRoupas();
            System.out.println("Roupas achadas:");
            for(Roupa r: roupasAchadas){
                System.out.println(r.toString());
            }

            gravadorDeRoupas.gravaRoupas(roupas);

        }catch (IOException e){
            e.printStackTrace();
        }

    }
}
