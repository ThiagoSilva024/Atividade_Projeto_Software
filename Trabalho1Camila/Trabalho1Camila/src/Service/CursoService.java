package Service;

import model.Curso;
import repository.ICursoRepositorio;

import java.util.List;

public class CursoService {
    private ICursoRepositorio repositorio;

    public void setRepositorio(ICursoRepositorio repositorio) {
        this.repositorio = repositorio;
    }

    public void cadastrarCurso(Curso curso) {
        if (repositorio != null) {
            repositorio.salvar(curso);
        } else {
            System.out.println(">> Nenhum repositório selecionado.");
        }
    }

    public void listarCursos() {
        if (repositorio != null) {
            List<Curso> cursos = repositorio.listar();
            for (Curso c : cursos) {
                System.out.println(c);
            }
        } else {
            System.out.println(">> Nenhum repositório selecionado.");
        }
    }
}
