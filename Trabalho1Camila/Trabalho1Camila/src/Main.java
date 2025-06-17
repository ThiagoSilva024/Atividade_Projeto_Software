import Service.CursoService;
import model.Curso;
import repository.MySQLCurso;
import repository.SQLServerCurso;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CursoService service = new CursoService();
        Scanner scanner   = new Scanner(System.in);
        boolean executando = true;

        System.out.println("=== Sistema de Cursos (Java) ===");
        while (executando) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1 - Usar MySQL");
            System.out.println("2 - Usar SQL Server");
            System.out.println("3 - Cadastrar curso");
            System.out.println("4 - Listar cursos");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            String opcao = scanner.nextLine();

            switch (opcao) {
                case "1" -> {
                    service.setRepositorio(new MySQLCurso());
                    System.out.println(">> Repositório MySQL selecionado.");
                }
                case "2" -> {
                    service.setRepositorio(new SQLServerCurso());
                    System.out.println(">> Repositório SQL Server selecionado.");
                }
                case "3" -> {
                    System.out.print("ID: ");
                    int id = Integer.parseInt(scanner.nextLine());

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("Carga horária (horas): ");
                    int carga = Integer.parseInt(scanner.nextLine());

                    System.out.print("Descrição: ");
                    String desc = scanner.nextLine();

                    System.out.print("Valor (R$): ");
                    float valor = Float.parseFloat(scanner.nextLine());

                    System.out.print("Público-alvo: ");
                    String publico = scanner.nextLine();

                    Curso curso = new Curso(id, nome, carga, desc, valor, publico);
                    service.cadastrarCurso(curso);
                }
                case "4" -> service.listarCursos();
                case "0" -> executando = false;
                default  -> System.out.println("Opção inválida.");
            }
        }
        scanner.close();
        System.out.println("Programa encerrado.");
    }
}
