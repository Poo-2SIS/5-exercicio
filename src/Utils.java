import model.BilheteUnico;
import model.Usuario;

import static javax.swing.JOptionPane.*;

public class Utils {

    private static BilheteUnico[] bilhetes = new BilheteUnico[10];
    static int contador = 0;

    public static void menuPrincipal() {
        int opcao;
        String menu = "1. Administrador\n2. Usuário\n3. Finalizar";
        do {
            opcao = criaMenuComOpcoes(menu);
            if (opcao < 1 || opcao > 3) {
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

    private static void menuAdmin() {
        int opcao;
        String menu = "1. Emitir bilhete\n2. Listar bilhetes\n3. Remover um bilhete\n4. Sair";
        do {
            opcao = criaMenuComOpcoes(menu);
            if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida");
            } else {
                switch (opcao) {
                    case 1:
                        emitirBilhete();
                        break;
                    case 2:
                        listarBilhete();
                        break;
                    case 3:
                        removerBilhete();

                }
            }
        } while (opcao != 4);
    }

    private static void menuUsuario() {
        int id = Integer.parseInt(showInputDialog("Qual o cpf?"));
        BilheteUnico buUser = procuraBilhete(id);
        if (buUser == null) {
            showMessageDialog(null, "Bilhete não encontrado");
        } else {

            int opcao;
            String menu = "1. Consultar Saldo\n" +
                    "2. Carregar Bilhete\n" +
                    "3. Passar na catraca\n" +
                    "4. Sair";
            do {
                opcao = criaMenuComOpcoes(menu);
                if (opcao < 1 || opcao > 4) {
                    showMessageDialog(null, "Opção inválida");
                } else {
                    switch (opcao) {
                        case 1:
                            consultarSaldo(buUser);
                            break;
                        case 2:
                            carregarBilhete(buUser);
                            break;
                        case 3:
                            passarNaCatraca(buUser);
                    }
                }
            } while (opcao != 4);
        }

    }

    private static void passarNaCatraca(BilheteUnico bilhete) {
        bilhete.comprarPassagem();
        showMessageDialog(null, "Passagem comprada, saldo: " + bilhete.getSaldo());
    }

    private static void carregarBilhete(BilheteUnico bilhete) {
        double carga = Double.parseDouble(showInputDialog("Quanto você ira carregar?"));
        double saldoAtual = bilhete.getSaldo();
        bilhete.carregar(carga);
        if (saldoAtual < bilhete.getSaldo()) {
            showMessageDialog(null, "Operação realizada com sucesso");
        } else {
            showMessageDialog(null, "Erro ao recarregar, tente novamente mais tarde");
        }
    }

    private static void consultarSaldo(BilheteUnico bilhete) {
        showMessageDialog(null, "Saldo: " + bilhete.getSaldo());
    }

    private static BilheteUnico procuraBilhete(int numero) {
        for (int i = 0; i < contador; i++) {
            if (bilhetes[i].getUsuario().getCpf() == numero) {
                showMessageDialog(null, bilhetes[i]);
                return bilhetes[i];
            }
        }
        return null;
    }


    private static void removerBilhete() {
        int cpf = Integer.parseInt(showInputDialog("Digite o cpf do usuario"));
        boolean achou = false;
        for (int i = 0; i < contador; i++) {
            if (cpf == bilhetes[i].getUsuario().getCpf()) {
                int opcao = showConfirmDialog(null, "Realmente deseja remover?");
                if (opcao == YES_OPTION) achou = true;
                else break;
            }
            if (achou && i != bilhetes.length - 1) {
                bilhetes[i] = bilhetes[i + 1];
            } else if (achou) {
                bilhetes[i] = null;
            }
        }
        if (achou) contador--;
    }

    private static void listarBilhete() {
        StringBuilder message = new StringBuilder();
        for (int i = 0; i < contador; i++) {
            message.append(bilhetes[i].toString()).append("\n");
        }
        showMessageDialog(null, message.toString());
    }

    private static void emitirBilhete() {
        if (contador < bilhetes.length) {
            String nome = showInputDialog(null, "Qual o nome do usuário");
            int cpf = Integer.parseInt(showInputDialog(null, "Qual o cpf do usuário"));
            String tipo = showInputDialog(null, "Qual o tipo do bilhete");
            Usuario usuario = new Usuario(nome, cpf, tipo);
            BilheteUnico bu = new BilheteUnico(usuario);
            bilhetes[contador++] = bu;
        } else {
            showMessageDialog(null, "Limite de usuarios excedido.");
        }

    }

    private static int criaMenuComOpcoes(String mensagem) {
        int opcao;
        opcao = Integer.parseInt(showInputDialog(mensagem));
        return opcao;
    }
}
