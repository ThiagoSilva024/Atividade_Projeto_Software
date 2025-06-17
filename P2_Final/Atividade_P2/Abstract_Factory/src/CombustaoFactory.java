public class CombustaoFactory implements VeiculoFactory {

    private String tipoTanque;

    public CombustaoFactory(String tipoTanque) {
        this.tipoTanque = tipoTanque;
    }

    @Override
    public Motor criarMotor() {
        return new MotorCombustao();
    }

    @Override
    public Tanque criarTanque() {
        if (tipoTanque.equalsIgnoreCase("gasolina")) {
            return new TanqueGasolina();
        } else if (tipoTanque.equalsIgnoreCase("alcool")) {
            return new TanqueAlcool();
        } else {
            throw new IllegalArgumentException("Tipo de tanque inválido: " + tipoTanque);
        }
    }

    @Override
    public Bateria criarBateria() {
        return null; // Carro a combustão não tem bateria
    }
}
