package br.edu.femass.dao;

import br.edu.femass.model.Autor;

import java.util.List;

public class DaoAutor extends Dao<Autor> {

    public static List<Autor> buscarTodos() {
        return em.createQuery("select a from Autor a order by a.nome").getResultList();
    }

    public List<Autor> buscarTodosPorid() {
        return em.createQuery("select a from Autor a order by a.id").getResultList();
    }
}