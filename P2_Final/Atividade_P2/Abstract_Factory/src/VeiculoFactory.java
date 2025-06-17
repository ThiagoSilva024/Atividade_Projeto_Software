public interface VeiculoFactory {
    Motor criarMotor();
    Tanque criarTanque();       // Para combustão
    Bateria criarBateria();     // Para elétrico
}
