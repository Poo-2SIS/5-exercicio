import model.BilheteUnico;
import model.Usuario;

public class Main {
    public static void main(String[] args) {
        Usuario usuario = new Usuario("Joao", 123, "Estudante");
        BilheteUnico bilheteUnico = new BilheteUnico(usuario);

        System.out.println(bilheteUnico);
        bilheteUnico.carregar(5);
        bilheteUnico.consultarSaldo();
        System.out.println(bilheteUnico);
        bilheteUnico.comprarPassagem();
        System.out.println(bilheteUnico.consultarSaldo());
        bilheteUnico.comprarPassagem();
        System.out.println(bilheteUnico.consultarSaldo());


    }
}
