package model;

public class Curso {
    private int id;
    private String nome;
    private int cargaHoraria;
    private String descricao;
    private float valor;
    private String publicoAlvo;

    public Curso(int id, String nome, int cargaHoraria, String descricao, float valor, String publicoAlvo) {
        this.id = id;
        this.nome = nome;
        this.cargaHoraria = cargaHoraria;
        this.descricao = descricao;
        this.valor = valor;
        this.publicoAlvo = publicoAlvo;
    }

    public int getId() { return id; }
    public String getNome() { return nome; }
    public int getCargaHoraria() { return cargaHoraria; }
    public String getDescricao() { return descricao; }
    public float getValor() { return valor; }
    public String getPublicoAlvo() { return publicoAlvo; }

    @Override
    public String toString() {
        return String.format(
                "model.Curso [id=%d, nome=%s, cargaHoraria=%dh, descricao=%s, valor=R$%.2f, publicoAlvo=%s]",
                id, nome, cargaHoraria, descricao, valor, publicoAlvo
        );
    }
}
