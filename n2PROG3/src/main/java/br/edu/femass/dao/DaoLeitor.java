package br.edu.femass.dao;

import br.edu.femass.model.Leitor;

import java.util.List;

public class DaoLeitor extends Dao<Leitor> {

    public List<Leitor> buscarTodos() {
        return em.createQuery("select a from Aluno a order by a.nome").getResultList();
    }

}