package demo;

import java.time.LocalDate;
import java.util.Date;

import entities.Aluno;
import entities.Curso;
import entities.Endereco;
import entities.MaterialCurso;
import entities.Professor;
import entities.Telefone;
import models.AlunoModel;
import models.CursoModel;

public class GestaoCursosMain {
    public static void main(String[] args) {

        AlunoModel alunoModel = new AlunoModel();

        Aluno a1 = new Aluno();

        Endereco e1 = new Endereco();
        e1.setCidade("Curitiba");
        e1.setBairro("Xaxim");
        e1.setEndereco("Doutor Xaxim");
        e1.setCep("123456789");
        e1.setLogradouro("Rua");
        e1.setEstado("PR");
        e1.setNumero("123");
        Telefone t1 = new Telefone();
        t1.setDDD("41");
        t1.setNumero("999999999");
        a1.setEndereco(e1);
        a1.setTelefone(t1);
        a1.setNomeCompleto("Nome do aluno1");
        a1.setEmail("testealuno@aluno.com.br");
        a1.setMatricula("11111111111");
        a1.setNascimento(new Date());

        alunoModel.create(a1);
        alunoModel.findAll();
        alunoModel.findById(a1);
        
        a1.setNomeCompleto("Nome do Aluno ALterado");
        alunoModel.update(a1);

        //alunoModel.delete(a1);


        CursoModel cursoModel = new CursoModel();
        Curso curso = new Curso();

        MaterialCurso materialCurso = new MaterialCurso();
        materialCurso.setUrl("material.com.br");

        Professor professor = new Professor();
        professor.setEmail("professor@prof.com.br");
        professor.setMatricula("9999999999");
        professor.setNomeCompleto("Professor legal da silva");

        curso.setProfessor(professor);
        curso.setMaterial(materialCurso);
        curso.setNome("Curso Culinária");
        curso.setSigla("AA");
        
        cursoModel.create(curso);

        cursoModel.findAll();
        cursoModel.findById(curso);
        
        curso.setNome("Curso Matematica");
        cursoModel.update(curso);

        //cursoModel.delete(curso);

    }
}
