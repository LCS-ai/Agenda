package ui;

import contatos.Contato;
import contatos.ListaDeContato;
import util.Entrada;

public class ContatoUi {

    private ListaDeContato contatos;
    private Entrada entrada;

    public ContatoUi() {
        contatos = new ListaDeContato();
        entrada = new Entrada();
    }

    public void adicionaNovoContato() {
        String nome = entrada.inString("Digite o nome do contato: ");
        String telefone = entrada.inString("Digite o telefone do contato: ");
        Contato contato = new Contato(nome, telefone);
        if (contatos.existeNaAgenda(contato)) {
            System.out.println("Contato já cadastrado.");
        }

        else if (contatos.verificaContatoChamadasNaoAtendidas(telefone)) {
            contatos.retornaContatoChamadaNaoAtendida(telefone).setNome(nome);
        }

        else {
            contatos.adicionaNovo(contato);
            System.out.println("Contato salvo na agenda.");
        }
    }

    public void removeContato() {

        boolean chave = true;
        while (chave) {
            String nomeParaRemocao = entrada.inString("Digite o nome do contato para remoção: ");
            if (contatos.verificaContatoExistente(nomeParaRemocao)) {
                chave = false;
            }

            if (contatos.verificaContatoChamadasNaoAtendidas(nomeParaRemocao)) {
                contatos.retornaContatoChamadaNaoAtendida(nomeParaRemocao).setNome("");
                chave = false;
            }

            else if (contatos.verificaContatoExistente(nomeParaRemocao) == false
                    && contatos.verificaContatoChamadasNaoAtendidas(nomeParaRemocao)) {
                System.out.println("Contato não encontrado.");
            }
        }
    }

    public void chamadaNaoAtendida() {
        String telefoneNaoAtendido = entrada.inString("Digite o telefone não atendido: ");

        if (contatos.verificaContatoExistente(telefoneNaoAtendido) == true
                && contatos.verificaContatoChamadasNaoAtendidas(telefoneNaoAtendido) == true) {
            contatos.retornaContatoChamadaNaoAtendida(telefoneNaoAtendido)
                    .setNome(contatos.retornaContatoExistente(telefoneNaoAtendido).getNome());
        }

        else if (contatos.verificaContatoExistente(telefoneNaoAtendido) == true
                && contatos.verificaContatoChamadasNaoAtendidas(telefoneNaoAtendido) == false) {
            contatos.adicionaChamadaNaoAtendida(contatos.retornaContatoExistente(telefoneNaoAtendido));

        }

        else {
            contatos.adicionaChamadaNaoAtendida(new Contato(telefoneNaoAtendido));
        }
    }

    public void mostraChamadasNaoAtendidas() {
        if (contatos.quantiaDeChamadas() > 0) {
            for (int i = 0; i < contatos.quantiaDeChamadas(); i++) {
                System.out.println(contatos.acessaChamadaNaoAtendida(i).toString());
            }
        }

        else {
            System.out.println("Não há chamadas não atendidas.");
        }
    }
    

    public void excluirTodasAsChamadas() {
        contatos.excluirTodasAsChamadas();
        System.out.println("Todos os contatos apagados.");
    }

}
