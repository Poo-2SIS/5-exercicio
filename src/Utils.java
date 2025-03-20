import model.BilheteUnico;

import static javax.swing.JOptionPane.*;

public class Utils {

    private BilheteUnico[] bilhetes = new BilheteUnico[10];

    public static void menuPrincipal() {
        int opcao;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";
        do {
            opcao = criaMenuComOpcoes(menu);
            if(opcao < 1 || opcao > 3) {
                showMessageDialog(null, "Opção inválida");
            } else {
                switch (opcao) {
                    case 1:
                        menuAdmin();
                        break;
                    case 2:
                        menuUsuario();
                }
            }
        } while (opcao != 3);

    }

    private static int criaMenuComOpcoes(String mensagem) {
        int opcao;
        opcao = Integer.parseInt(showInputDialog(mensagem));
        return opcao;
    }

    private static void menuUsuario() {
    }

    private static void menuAdmin() {
        int opcao;
        String menu = "1. Emitir bilhete\n2. Listar bilhetes\n3. Remover um bilhete\n4. Sair";
        do {
            opcao = criaMenuComOpcoes(menu);
            if(opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida");
            } else {
                switch (opcao) {
                    case 1:
                        emitirBilhete();
                        break;
                    case 2:
                        //listarBilhete();
                        break;
                    case 3:
                        // removerBilhete();

                }
            }
        } while (opcao != 4);
    }

    private static void emitirBilhete() {

    }

}
