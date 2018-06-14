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
import model.*;

/**
 *
 * @author DC CENTER PAES
 */
public class BairroDAO {
    //CLASSE QUE FAZ COMUNICAÇÃO COM O DB ATRAVÉS DE PERSISTENCIA (ELITETECSYSTEMPU)
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EliteTeSystemPU");
    private EntityManager em;
    //ABRE COMUNICAÇÃO COM O DB
    public BairroDAO() {
        em = factory.createEntityManager();
    }
    //GRAVA OS DADOS NO DB
    public boolean gravar(Bairro bairro) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(bairro);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
    //CRIA UMA LISTAGEM DO DB NO SISTEMA
    public List<Bairro> listar() {
        List<Bairro> bairros = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Bairro c ORDER BY c.descricao ASC ");
            bairros = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bairros;
    }
//    public List<Bairro> buscaBairroPorNome(String nome) {
//        List<Bairro> bairros = null;
//        try {
//            em.getTransaction().begin();
//            Query query = em.createQuery("Select c from Bairro c where c.nome like :pnome ");
//            query.setParameter("pnome", "%" + nome + "%");
//
//            bairros = query.getResultList();
//
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return bairros;
//}
    //SELECIONA ALGUM DADO NO DB ATRAVÉS DO CÓDIGO DO ITEM NO DB
    public Bairro selecionar(Long codigo) {
        Bairro bairro = null;
        try {
            //em.getTransaction().begin();
            bairro = em.find(Bairro.class, codigo);
            // em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bairro;
    }
    //ALTERA REGISTRO NO DB
    public boolean alterar(Bairro bairro) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(bairro);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
    //REMOVE DADOS SELECIONADOS NO DB ATRAVÉZ DO CÓDIGO DO DB
    public boolean remover(Bairro bairro) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            bairro = selecionar(bairro.getCodigo());
            em.remove(bairro);
            sucesso = true;
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
    //GERA UMA LISTA NO SISTEMA, PEGANDO OS DADOS ATRAVÉZ DO CÓDIGO SELECIONADO NO SISTEMA
    public Bairro getBairroByCodigo(Long codigo) {
        Bairro bairro = null;
        try {
            //em.getTransaction().begin();
            bairro = em.find(Bairro.class, codigo);
            //em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bairro;
    }
    //GERA UMA LISTA NO SISTEMA, PEGANDO OS DADOS ATRAVÉZ DO NOME SELECIONADO NO SISTEMA
    public List<Bairro> buscaBairroPorNome(String nome) {
        List<Bairro> bairros = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Bairro c where c.descricao like :pnome ");
            query.setParameter("pnome", "%" + nome + "%");

            bairros = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bairros;
    }
}