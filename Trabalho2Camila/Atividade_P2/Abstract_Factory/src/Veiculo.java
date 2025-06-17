public class Veiculo {
    private Motor motor;
    private Tanque tanque;
    private Bateria bateria;

    public Veiculo(VeiculoFactory factory) {
        motor = factory.criarMotor();
        tanque = factory.criarTanque();
        bateria = factory.criarBateria();
    }

    public void mostrarInfo() {
        if (motor != null) motor.infoMotor();
        if (tanque != null) tanque.infoTanque();
        if (bateria != null) bateria.infoBateria();
    }
}
