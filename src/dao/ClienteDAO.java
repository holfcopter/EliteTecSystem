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
import model.Bairro;
import model.Cidade;
import model.Cliente;

/**
 *
 * @author DC CENTER PAES
 */
public class ClienteDAO {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EliteTeSystemPU");
    private EntityManager em;

    public ClienteDAO() {
        em = factory.createEntityManager();
    }

    public boolean gravar(Cliente cliente) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public List<Cliente> listar() {
        List<Cliente> clientes = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Cliente c ");
            clientes = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public List<Cliente> buscaClientePorNome(String nome) {
        List<Cliente> clientes = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Cliente c where c.nome like :pnome ");
            query.setParameter("pnome", "%" + nome + "%");

            clientes = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public List<Cliente> buscaClientePorCel(String cel) {
        List<Cliente> clientes = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Cliente c where c.celular like :pcelular ");
            query.setParameter("pcelular", "%" + cel + "%");

            clientes = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return clientes;
    }

    public Cliente selecionar(Long codigo) {
        Cliente cliente = null;
        try {
            //em.getTransaction().begin();
            cliente = em.find(Cliente.class, codigo);
            // em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
//    public boolean remover(Cliente cliente) {
//        boolean sucesso = false;
//        try {
//            em.getTransaction().begin();
//            cliente = selecionar(cliente.getCodigo());
//            em.remove(cliente);
//            sucesso = true;
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sucesso;
//    }
    }

    public boolean alterar(Cliente cliente) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(cliente);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;

    }

    public boolean remover(Cliente cliente) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            cliente = selecionar(cliente.getCodigo());
            em.remove(cliente);
            sucesso = true;
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public Cliente getClienteByCodigo(Long codigo) {
        Cliente cliente = null;
        try {
            //em.getTransaction().begin();
            cliente = em.find(Cliente.class, codigo);
            //em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return cliente;
    }

   
}