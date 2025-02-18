package br.ufpb.Projetos.Prova1;

import java.io.IOException;
import java.util.*;

public class SistemaLojaRoupasPOO implements SistemaLojaRoupas {

    private GravadorDeRoupas gravadorDeRoupas;
    private Map<String, Roupa> roupasMap;


    public SistemaLojaRoupasPOO() {

        this.roupasMap = new HashMap<>();
        this.gravadorDeRoupas = new GravadorDeRoupas();

    }

    public void recuperaRoupas() throws IOException, RoupaJaExisteException {
        Collection<Roupa> roupasAchadas = this.gravadorDeRoupas.recuperarRoupas();
        for(Roupa r: roupasAchadas){
            this.cadastraRoupa(r.getCodigo(), r.getDescricao(), r.getQuantidade(), r.getTamanho());
        }
    }

    public void salvarRoupas() throws IOException {
        this.gravadorDeRoupas.gravaRoupas(this.roupasMap.values());
    }

    @Override
    public void cadastraRoupa(String codigoRoupa, String descricao, int quantidade, Tamanho tamanho) throws RoupaJaExisteException {
        if (this.roupasMap.containsKey(codigoRoupa)) {
            throw new RoupaJaExisteException("Roupa já cadastrada: " + codigoRoupa);
        } else {
            Roupa roupa = new Roupa(codigoRoupa, descricao, quantidade, tamanho);
            this.roupasMap.put(codigoRoupa, roupa);
        }
    }

    @Override
    public List<Roupa> pesquisaRoupaPorTamanho(Tamanho tamanhoRoupa){
        List<Roupa> roupasDoTamanho = new ArrayList<>();
        for(Roupa r: this.roupasMap.values()){
            if(r.getTamanho() == tamanhoRoupa){
                roupasDoTamanho.add(r);
            }
        }
        return roupasDoTamanho;
    }

    public List<Roupa> pesquisaRoupaComDescricaoComecandoCom(String prefixoDescricao){
        List<Roupa> roupaComPrefixo = new ArrayList<>();
        for(Roupa r: this.roupasMap.values()){
            if(r.getDescricao().startsWith(prefixoDescricao)){
                roupaComPrefixo.add(r);
            }
        }
        return roupaComPrefixo;
    }

    public Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException{
        if(this.roupasMap.containsKey(codigoRoupa)){
            return this.roupasMap.get(codigoRoupa).getTamanho();
        } else{
            throw new RoupaInexistenteException("Roupa não cadastrada");
        }
    }

    public List<Roupa> pesquisaRoupasPorDescricao(String descricao){
        List<Roupa> roupasDaDesricao = new ArrayList<>();
        for(Roupa r: this.roupasMap.values()){
            if(r.getDescricao().equals(descricao)){
                roupasDaDesricao.add(r);
            }
        }
        return roupasDaDesricao;
    }

    @Override
    public void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException {
        for(Roupa r: this.roupasMap.values()){
            if(this.roupasMap.containsKey(codigoRoupa)){
                r.setQuantidade(novaQuantidade);
            }else{
                throw new RoupaInexistenteException("Roupa não cadastrada.");
            }
        }
    }

    public Roupa pesquisaRoupa (String codigoRoupa) throws RoupaInexistenteException {
        if (this.roupasMap.containsKey(codigoRoupa)) {
            return this.roupasMap.get(codigoRoupa);
        } else {
            throw new RoupaInexistenteException("Roupa não cadastrada.");
        }
    }

    public int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException{
        int quantRoupaNoEstoque = 0;
        if(this.roupasMap.containsKey(codigoRoupa)){
            quantRoupaNoEstoque = this.roupasMap.get(codigoRoupa).getQuantidade();
        }else{
            throw new RoupaInexistenteException("Roupa não cadastrada");
        }
        return quantRoupaNoEstoque;
    }
}