package models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entities.Aluno;
import entities.Curso;

public class CursoModel {

    public void create(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(curso);
            em.getTransaction().commit();
            System.out.println("Curso criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar um Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public Curso findById(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        Curso cr = new Curso();
        try {
            System.out.println("Iniciando a transação");
            cr = em.find(Curso.class, curso.getId());
            
           
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao pesquisar Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return cr;
    }

    public  List<Curso> findAll() {
        List<Curso> curso = new ArrayList<Curso>();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createQuery("SELECT p FROM Curso p");
             curso =  query.getResultList();

            
           
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao lista Alunos !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
        return curso;
    }

    public void update(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            
            Curso cr = em.find(Curso.class, curso.getId());
            cr.setAluno(curso.getAluno());
            cr.setMaterial(curso.getMaterial());
            cr.setNome(curso.getNome());
            cr.setProfessor(curso.getProfessor());
            cr.setSigla(curso.getSigla());
            em.getTransaction().begin();
            em.merge(cr);
            em.getTransaction().commit();
            System.out.println("Curso alterado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao alterar a Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void delete(Curso curso) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            
            Curso cs = em.find(Curso.class, curso.getId());
            em.getTransaction().begin();
            em.remove(cs);
            em.getTransaction().commit();
            System.out.println("Curso exclído com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao excluir Curso !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }     }
}
