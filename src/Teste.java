import model.BilheteUnico;
import model.Usuario;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        BilheteUnico[] bilheteUnicos = new BilheteUnico[2];

        bilheteUnicos[0] = new BilheteUnico(new Usuario("Alec", 123,"Normal"));
        bilheteUnicos[1] = new BilheteUnico(new Usuario("Rafael", 124,"Estudante"));
        for (BilheteUnico bilhete : bilheteUnicos) {
            System.out.println(bilhete.getUsuario().getNome());
        }
    }
}
