package repository;

import model.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLServerCurso implements ICursoRepositorio {
    private final String url = "jdbc:sqlserver://localhost:1433;"
            + "databaseName=CursosDB;"
            + "integratedSecurity=true;"
            + "encrypt=false";

    @Override
    public void salvar(Curso curso) {
        String sql = "INSERT INTO Cursos "
                + "(id, nome, cargaHoraria, descricao, valor, publicoAlvo) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url);
                 PreparedStatement stmt = conn.prepareStatement(sql)) {

                stmt.setInt(1,   curso.getId());
                stmt.setString(2, curso.getNome());
                stmt.setInt(3,   curso.getCargaHoraria());
                stmt.setString(4, curso.getDescricao());
                stmt.setFloat(5, curso.getValor());
                stmt.setString(6, curso.getPublicoAlvo());

                stmt.executeUpdate();
                System.out.println(">> model.Curso salvo no SQL Server (Windows Auth).");
            }
        } catch (ClassNotFoundException e) {
            System.out.println("Driver JDBC do SQL Server não encontrado: " + e.getMessage());
        } catch (SQLException e) {
            System.out.println("Erro ao salvar no SQL Server: " + e.getMessage());
        }
    }

    @Override
    public List<Curso> listar() {
        List<Curso> lista = new ArrayList<>();
        String sql = "SELECT id, nome, cargaHoraria, descricao, valor, publicoAlvo FROM Cursos";

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            try (Connection conn = DriverManager.getConnection(url);
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
            System.out.println("Erro ao listar do SQL Server: " + e.getMessage());
        }
        return lista;
    }
}
