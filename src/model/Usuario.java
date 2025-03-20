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

    public String getNome() {
        return nome;
    }

    public long getCpf() {
        return cpf;
    }

    public String getTipoDeTarifa() {
        return tipoDeTarifa;
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
