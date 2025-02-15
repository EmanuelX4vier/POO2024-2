package br.ufpb.Projetos.Atividade1;

import java.util.Objects;

public class Data {

    private int dia;
    private int mes;
    private int ano;

    public Data(int dia, int mes, int ano){
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public Data(){
        this(1, 1, 2000);
    }

    //get's
    public int getDia(){
        return dia;
    }

    public int getMes(){
        return mes;
    }

    public int getAno(){
        return ano;
    }

    //set's
    public void setDia(int novoDia){
        this.dia = novoDia;
    }

    public void setMes(int novoMes){
        this.mes = novoMes;
    }

    public void setAno(int novoAno){
        this.ano = novoAno;
    }

    //equals e hashcode

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Data data = (Data) o;
        return dia == data.dia && mes == data.mes && ano == data.ano;
    }

    @Override
    public int hashCode() {
        return Objects.hash(dia, mes, ano);
    }

    @Override
    public String toString(){
        return this.dia+"/"+this.mes+"/"+this.ano;
    }
}
