package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Aluno;
import entities.Telefone;

public class AlunoModel {

    public void create(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(aluno);
            em.getTransaction().commit();
            System.out.println("Aluno criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Aluno findById(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        Aluno al = new Aluno();
        try {
            System.out.println("Iniciando a transação");
            al = em.find(Aluno.class, aluno.getId());
            
           
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao pesquisar Aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return al;
    }

    public  List<Aluno> findAll() {
        List<Aluno> pessoas = new ArrayList<Aluno>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Aluno p");
             pessoas =  query.getResultList();

            
           
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao lista Alunos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return pessoas;

    }
    

    public void update(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            
            Aluno al = em.find(Aluno.class, aluno.getId());
            al.setNomeCompleto(aluno.getNomeCompleto());
            al.setEmail(aluno.getEmail());
            al.setMatricula(aluno.getMatricula());
            al.setNascimento(aluno.getNascimento());
            al.setTelefone(aluno.getTelefone());
            al.setEndereco(aluno.getEndereco());
            al.setCurso(aluno.getCurso());
            em.getTransaction().begin();
            em.merge(al);
            em.getTransaction().commit();
            System.out.println("Aluno alterado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao alterar a Aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Aluno aluno) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            
            Aluno al = em.find(Aluno.class, aluno.getId());
            em.getTransaction().begin();
            em.remove(al);
            em.getTransaction().commit();
            System.out.println("Aluno exclído com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao excluir Aluno !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }     }
}
