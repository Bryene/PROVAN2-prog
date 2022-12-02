
package br.edu.femass.dao;

import br.edu.femass.model.Exemplar;
import java.util.List;

public class DaoExemplar extends Dao<Exemplar> {

    public static List<Exemplar> buscarTodos() {
        return em.createQuery("select a from exemplar a order by a.dataAquisicao").getResultList();
    }

    public static List<Exemplar> buscarTodosPorid() {
        return em.createQuery("select a from Exemplar a order by a.id").getResultList();
    }

}
