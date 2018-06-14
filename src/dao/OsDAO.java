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
import model.OS;

/**
 *
 * @author DC CENTER PAES
 */
public class OsDAO {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EliteTeSystemPU");
    private EntityManager em;
    
    public OsDAO() {
        em = factory.createEntityManager();
    }

    public boolean gravar(OS os) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(os);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public List<OS> listar() {
        List<OS> oss = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from OS c ");
            oss = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oss;
    }

    public List<OS> buscaClientePorNome(String nome) {
        List<OS> oss = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from OS c where c.nome like :pnome ");
            query.setParameter("pnome", "%" + nome + "%");

            oss = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oss;
    }
    public List<OS> buscaClientePorCel(String cel) {
        List<OS> oss = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from OS c where c.celular like :pcelular ");
            query.setParameter("pcelular", "%" + cel + "%");

            oss = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return oss;
    }

    public OS selecionar(Long codigo) {
        OS os = null;
        try {
            //em.getTransaction().begin();
            os = em.find(OS.class, codigo);
            // em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return os;
//    public boolean remover(OS os) {
//        boolean sucesso = false;
//        try {
//            em.getTransaction().begin();
//            os = selecionar(os.getCodigo());
//            em.remove(os);
//            sucesso = true;
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sucesso;
//    }
    }

    public boolean alterar(OS os) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(os);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;

    }
    public boolean remover(OS os) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            os = selecionar(os.getCodigo());
            em.remove(os);
            sucesso = true;
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
    public OS getClienteByCodigo(Long codigo) {
       OS os = null;
        try {
            //em.getTransaction().begin();
            os = em.find(OS.class, codigo);
            //em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return os;
    }
   
}
