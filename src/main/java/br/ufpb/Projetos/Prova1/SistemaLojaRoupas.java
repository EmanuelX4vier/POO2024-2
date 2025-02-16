package br.ufpb.Projetos.Prova1;

import java.util.List;

public interface SistemaLojaRoupas {
    List<Roupa> pesquisaRoupaPorTamanho(Tamanho tamanhoRoupa);
    List <Roupa> pesquisaRoupaComDescricaoComecandoCom(String prefixoDescricao);
    Tamanho consultaTamanhoDaRoupa(String codigoRoupa) throws RoupaInexistenteException;
    void cadastraRoupa(String codigoRoupa, String descricao, int quantidade, Tamanho tamanho) throws RoupaJaExisteException;


    void alteraQuantidadeDeRoupaNoEstoque(String codigoRoupa, int novaQuantidade) throws RoupaInexistenteException;
    int pesquisaQuantidadeDeRoupaNoEstoque(String codigoRoupa) throws RoupaInexistenteException;
    Roupa pesquisaRoupa(String codigoRoupa) throws RoupaInexistenteException;


}

