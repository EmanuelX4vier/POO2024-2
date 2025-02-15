package br.ufpb.Projetos.AtividadePosto;

import java.util.*;

public class SistemaGerenciadorAtendimentosPosto implements SistemaGerenciadorDeAtendimentos {


    private Map<String, Medico> medicos;
    private Map<String, AtendimentoMedico> atendimentos;

    public SistemaGerenciadorAtendimentosPosto() {
        this.medicos = new HashMap<>();
        this.atendimentos = new HashMap<>();
    }

    @Override
    public void cadastrarAtendimento(String codigoFicha, CategoriaAtendimento categoria, String cpfPaciente, String crmMedico, Data diaAtendimento) throws MedicoNaoCadastradoException, AtendimentoJaCadastradoException {
        if(this.atendimentos.containsKey(codigoFicha)){
            throw new AtendimentoJaCadastradoException("Atendimento já cadastrado");
        } else if (!this.medicos.containsKey(crmMedico)) {
            throw new MedicoNaoCadastradoException("Medico não cadastrado");
        } else{
            AtendimentoMedico atendimento = new AtendimentoMedico(codigoFicha, categoria, cpfPaciente, crmMedico, diaAtendimento);
            this.atendimentos.put(codigoFicha, atendimento);
        }
    }

    @Override
    public void cadastrarMedico(String crmMedico, String nomeMedico) throws MedicoJaCadastradoException {
        if (this.medicos.containsKey(crmMedico)) {
            throw new MedicoJaCadastradoException(
                    "Já existe médico com o CRM " + crmMedico);
        } else {
            this.medicos.put(crmMedico, new Medico(crmMedico, nomeMedico));
        }

    }

    public int contaAtendimentosDeMedicoNoMes (String crmMedico, int mes, int ano){
        int quantAtendimentoDeMedicoNoMes = 0;
        for(AtendimentoMedico a: this.atendimentos.values()){
            if (a.getCrmMedico().equals(crmMedico)) {
                Data dataA = a.getDiaAtendimento();
                if(dataA.getMes() == mes && dataA.getAno() == ano){
                    quantAtendimentoDeMedicoNoMes++;
                }
            }
        }


        return quantAtendimentoDeMedicoNoMes;
    }

    @Override
    public Collection<AtendimentoMedico> pesquisaAtendimentosDoDia(Data diaAtendimento) {
       Collection<AtendimentoMedico> atendimentosDoDia = new LinkedList<>();
       for(AtendimentoMedico a: this.atendimentos.values()){
           if(a.getDiaAtendimento().equals(diaAtendimento)){
               atendimentosDoDia.add(a);
           }
       }
       return atendimentosDoDia;
    }

    public AtendimentoMedico pesquisaAtendimento(String ficha) throws AtendimentoNaoCadastradoException{
        if(this.atendimentos.containsKey(ficha)){
            return this.atendimentos.get(ficha);
        }else{
            throw new AtendimentoNaoCadastradoException("Atendimento não cadastrado");
        }
    }

    public int contaAtendimentosDaCategoria(CategoriaAtendimento categoria){
        int quantAtendimentosDaCategoria = 0;
        for(AtendimentoMedico a: this.atendimentos.values()){
            if(a.getCategoria()==categoria){
                quantAtendimentosDaCategoria++;
            }
        }
        return quantAtendimentosDaCategoria;
    }
}



