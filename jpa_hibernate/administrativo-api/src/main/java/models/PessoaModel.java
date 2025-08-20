package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Pessoa;

public class PessoaModel {

    public void create(Pessoa p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Pessoa criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o Pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa p) {
        // TODO
    }

    public void delete(Pessoa p) {
        // TODO
    }

    public Pessoa findById(Pessoa p) {
        // TODO
        return null;
    }

    public List<Pessoa> findAll() {

        List<Pessoa> Pessoas = new ArrayList<Pessoa>();
        // TODO
        return null;
    }
}
