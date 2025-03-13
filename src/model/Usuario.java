package model;

public class Usuario {
    String nome;
    long cpf;
    String tipoDeTarifa;

    public Usuario(String nome, long cpf, String tipoDeTarifa) {
        this.nome = nome;
        this.cpf = cpf;
        this.tipoDeTarifa = tipoDeTarifa;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", cpf=" + cpf +
                ", tipoDeTarifa='" + tipoDeTarifa + '\'' +
                '}';
    }
}
