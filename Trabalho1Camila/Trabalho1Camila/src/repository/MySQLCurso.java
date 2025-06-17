package repository;

import model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLCurso implements ICursoRepositorio {
    private final String url  = "jdbc:mysql://localhost:3306/cursos_db";
    private final String user = "root";
    private final String password = "admin";

    @Override
    public void salvar(Curso curso) {
        String sql = "INSERT INTO cursos "
                + "(id, nome, cargaHoraria, descricao, valor, publicoAlvo) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1,   curso.getId());
                stmt.setString(2, curso.getNome());
                stmt.setInt(3,   curso.getCargaHoraria());
                stmt.setString(4, curso.getDescricao());
                stmt.setFloat(5, curso.getValor());
                stmt.setString(6, curso.getPublicoAlvo());

                stmt.executeUpdate();
                System.out.println(">> model.Curso salvo no MySQL.");
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar no MySQL: " + e.getMessage());
        }
    }

    @Override
    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT id, nome, cargaHoraria, descricao, valor, publicoAlvo FROM cursos";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt  = conn.createStatement();
                 ResultSet rs    = stmt.executeQuery(sql)) {

                while (rs.next()) {
                    lista.add(new Curso(
                            rs.getInt("id"),
                            rs.getString("nome"),
                            rs.getInt("cargaHoraria"),
                            rs.getString("descricao"),
                            rs.getFloat("valor"),
                            rs.getString("publicoAlvo")
                    ));
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar do MySQL: " + e.getMessage());
        }
        return lista;
    }
}
