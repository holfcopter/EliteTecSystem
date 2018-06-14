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
import model.Equipamento;

/**
 *
 * @author DC CENTER PAES
 */
public class EquipamentoDAO {
    
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("EliteTeSystemPU");
    private EntityManager em;
    
    public EquipamentoDAO() {
        em = factory.createEntityManager();
    }

    public boolean gravar(Equipamento equipamento) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(equipamento);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }

    public List<Equipamento> listar() {
        List<Equipamento> equipamentos = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Equipamento c where c.statusControle like 'ATIVO' ");
            equipamentos = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamentos;
    }

    public List<Equipamento> buscaClientePorNome(String nome) {
        List<Equipamento> equipamentos = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Equipamento c where c.nome like :pnome ");
            query.setParameter("pnome", "%" + nome + "%");

            equipamentos = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamentos;
    }
    public List<Equipamento> buscaClientePorCel(String cel) {
        List<Equipamento> equipamentos = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Equipamento c where c.celular like :pcelular ");
            query.setParameter("pcelular", "%" + cel + "%");

            equipamentos = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamentos;
    }

    public Equipamento selecionar(Long codigo) {
        Equipamento equipamento = null;
        try {
            //em.getTransaction().begin();
            equipamento = em.find(Equipamento.class, codigo);
            // em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamento;
//    public boolean remover(Equipamento equipamento) {
//        boolean sucesso = false;
//        try {
//            em.getTransaction().begin();
//            equipamento = selecionar(equipamento.getCodigo());
//            em.remove(equipamento);
//            sucesso = true;
//            em.getTransaction().commit();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return sucesso;
//    }
    }

    public boolean alterar(Equipamento equipamento) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            em.merge(equipamento);
            em.getTransaction().commit();
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;

    }
    public boolean remover(Equipamento equipamento) {
        boolean sucesso = false;
        try {
            em.getTransaction().begin();
            equipamento = selecionar(equipamento.getCodigo());
            em.remove(equipamento);
            sucesso = true;
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sucesso;
    }
    public Equipamento getClienteByCodigo(Long codigo) {
       Equipamento equipamento = null;
        try {
            //em.getTransaction().begin();
            equipamento = em.find(Equipamento.class, codigo);
            //em.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamento;
    }
    
     public List<Equipamento> listarEquipamentoCliente() {
        List<Equipamento> equipamentos = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("SELECT C FROM Equipamento c WHERE c.statusControle = 'ATIVO'");
            equipamentos = query.getResultList();
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamentos;
    }
  public List<Equipamento> listarEquipamentoNSerie(String nSerie) {
        List<Equipamento> equipamentos = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Equipamento c where c.nserie like :pnome and c.statusControle = 'ATIVO' ");
            query.setParameter("pnome", "%" + nSerie + "%");

            equipamentos = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamentos;
    }
  public List<Equipamento> listarEquipamentoCliente(String cliente) {
        List<Equipamento> equipamentos = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Equipamento c where c.cliente like :pnome and c.statusControle = 'ATIVO'");
            query.setParameter("pnome", "%" + cliente + "%");

            equipamentos = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamentos;
    }
  public List<Equipamento> listarEquipamentoDescricao(String descricao) {
        List<Equipamento> equipamentos = null;
        try {
            em.getTransaction().begin();
            Query query = em.createQuery("Select c from Equipamento c where c.descricao like :pnome and c.statusControle = 'ATIVO' ");
            query.setParameter("pnome", "%" + descricao + "%");

            equipamentos = query.getResultList();

            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return equipamentos;
    }

}
