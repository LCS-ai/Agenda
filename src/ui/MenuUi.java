package ui;

import java.util.Scanner;

public class MenuUi {

    private Scanner scan;

    public void menu() {
        ContatoUi agenda = new ContatoUi();

        boolean chave = true;
        while (chave) {

            int opcao = inInt(
                    "\n\n===========================================\n[1] Cadastrar contato\n[2] Remover contato\n[3] Cadastrar chamada não atendida\n[4] Mostrar lista de chamadas não atendidas\n[5] Excluir todas chamadas não atendidas\n[6] Sair \n===========================================\n");
            switch (opcao) {
                case 1:
                    agenda.adicionaNovoContato();
                    break;

                case 2:
                    agenda.removeContato();
                    break;

                case 3:
                    agenda.chamadaNaoAtendida();
                    break;

                case 4:
                    agenda.mostraChamadasNaoAtendidas();
                    break;

                case 5:
                    agenda.excluirTodasAsChamadas();
                    break;

                case 6:
                    chave = false;
                    break;

                default:
                    break;
            }

        }
    }

    public int inInt(String entrada) {
        System.out.println(entrada);
        scan = new Scanner(System.in);
        return scan.nextInt();
    }
}
