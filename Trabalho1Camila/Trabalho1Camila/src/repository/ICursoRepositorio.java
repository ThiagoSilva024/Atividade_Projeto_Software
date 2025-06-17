package repository;

import model.Curso;

import java.util.List;

public interface ICursoRepositorio {
    void salvar(Curso curso);
    List<Curso> listar();
}
