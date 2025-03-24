import model.BilheteUnico;
import model.Usuario;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int[] v = new int[5];

        preencherVetor(v);
        imprimeVetor(v);

        Utils.menuPrincipal();

    }

    private static void imprimeVetor(int[] vetor) {
        for (int n : vetor) {
            System.out.print(n + "\t");
        }
    }

    private static void preencherVetor(int[] vetor) {
        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = new Random().nextInt(100);
        }
    }
}
