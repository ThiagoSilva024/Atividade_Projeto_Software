public class EletricoFactory implements VeiculoFactory {

    private String autonomiaBateria;

    public EletricoFactory(String autonomiaBateria) {
        this.autonomiaBateria = autonomiaBateria;
    }

    @Override
    public Motor criarMotor() {
        return new MotorEletrico();
    }

    @Override
    public Tanque criarTanque() {
        return null; // Carro elétrico não tem tanque
    }

    @Override
    public Bateria criarBateria() {
        if (autonomiaBateria.equals("200")) {
            return new Bateria200km();
        } else if (autonomiaBateria.equals("300")) {
            return new Bateria300km();
        } else {
            throw new IllegalArgumentException("Autonomia de bateria inválida: " + autonomiaBateria);
        }
    }
}
