import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o tipo de veículo:");
        System.out.println("1 - Carro a Combustão");
        System.out.println("2 - Carro Elétrico");
        System.out.print("Digite sua escolha: ");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // consumir newline

        VeiculoFactory factory = null;

        switch (escolha) {
            case 1:
                System.out.println("Escolha o tipo de combustível:");
                System.out.println("1 - Gasolina");
                System.out.println("2 - Álcool");
                System.out.print("Digite sua escolha: ");
                int escolhaCombustivel = scanner.nextInt();
                scanner.nextLine(); // consumir newline

                String tipoTanque;
                if (escolhaCombustivel == 1) {
                    tipoTanque = "gasolina";
                } else if (escolhaCombustivel == 2) {
                    tipoTanque = "alcool";
                } else {
                    System.out.println("Opção inválida para combustível!");
                    scanner.close();
                    return;
                }
                factory = new CombustaoFactory(tipoTanque);
                break;

            case 2:
                System.out.println("Escolha a autonomia da bateria:");
                System.out.println("1 - 200 km");
                System.out.println("2 - 300 km");
                System.out.print("Digite sua escolha: ");
                int escolhaBateria = scanner.nextInt();
                scanner.nextLine(); // consumir newline

                String autonomia;
                if (escolhaBateria == 1) {
                    autonomia = "200";
                } else if (escolhaBateria == 2) {
                    autonomia = "300";
                } else {
                    System.out.println("Opção inválida para autonomia da bateria!");
                    scanner.close();
                    return;
                }
                factory = new EletricoFactory(autonomia);
                break;

            default:
                System.out.println("Opção inválida para tipo de veículo!");
                scanner.close();
                return;
        }

        Veiculo veiculo = new Veiculo(factory);
        System.out.println("\nInformações do veículo criado:");
        veiculo.mostrarInfo();

        scanner.close();
    }
}
