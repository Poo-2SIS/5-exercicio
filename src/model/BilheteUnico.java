package model;

import java.util.Random;

public class BilheteUnico {
    int numero;
    Usuario usuario;
    double saldo;
    static final double TARIFA_BASE = 5.20;

    public BilheteUnico(Usuario usuario) {
        this.usuario = usuario;
        numero = gerarNumero();
        saldo = 0;
    }

    private int gerarNumero() {
        return new Random().nextInt(1000,10000);
    }

    //metodo para carregar o bilhete
    public void carregar(double saldo){
        this.saldo += saldo;
    }

    //metodo para consultar o saldo
    public double consultarSaldo(){
        return saldo;
    }

    //metodo para passar o bilhete
    public void comprarPassagem(){
        double saldo = this.saldo;
        if(usuario.tipoDeTarifa.equalsIgnoreCase("Estudante")
        || usuario.tipoDeTarifa.equalsIgnoreCase("Professor")){
            saldo -= TARIFA_BASE * 0.5;
        } else {
            saldo -= TARIFA_BASE;
        }
        if(saldo >= 0){
            this.saldo = saldo;
        } else {
            System.out.println("Saldo insuficiente");
        }
    }

    @Override
    public String toString() {
        return "BilheteUnico{" +
                "numero=" + numero +
                ", usuario=" + usuario +
                ", saldo=" + saldo +
                '}';
    }
}
