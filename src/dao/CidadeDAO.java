/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import model.Cidade;

/**
 *
 * @author Jackson
 */
public class CidadeDAO {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EliteTeSystemPU");
    private EntityManager em;

    public CidadeDAO() {
        em = factory.createEntityManager();
    }

    public boolean gravar(Cidade cidade) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(cidade);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public List<Cidade> listar(String uf) {
        List<Cidade> cidades = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Cidade c where c.uf = :estado order by c.descricao asc ");
            query.setParameter("estado", uf);
            cidades = query.getResultList();
            //em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }

    public List<Cidade> listar1() {
        List<Cidade> cidades = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Cidade c order by c.uf asc ");
            cidades = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }

    public List<Cidade> buscaCidadePorNome(String nome) {
        List<Cidade> cidades = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Cidade c where c.descricao like :pnome ");
            query.setParameter("pnome", "%" + nome + "%");

            cidades = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }

    public Cidade getCidadeByCodigo(Long codigo) {
        Cidade cidade = null;
        try {
            //em.getTransaction().begin();
            cidade = em.find(Cidade.class, codigo);
            //em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidade;
    }

    public List<Cidade> listarCidadeByNome() {
        List<Cidade> cidades = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT C FROM Cidade c ORDER BY c.descricao ASC");
            cidades = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }

    public List<Cidade> listarCidadeByUf() {
        List<Cidade> cidades = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT C FROM Cidade c ORDER BY c.uf ASC");
            cidades = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }
//     List<ProfessorDisciplinaSerieTurma> professorDiciplinaSerieTurma = null;
//        try {
//            Query query = em.createQuery("Select p From ProfessorDisciplinaSerieTurma p Where p.codigoprofessor = :codigo");
//            query.setParameter("codigo", codigoProfessor);
//            professorDiciplinaSerieTurma = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return professorDiciplinaSerieTurma;
}
