package contatos;

import java.util.ArrayList;
import java.util.List;

public class ListaDeContato {

    private Contato contato;
    private List<Contato> chamadasNaoAtendidas;
    private List<Contato> listaDeContatos;

    public ListaDeContato() {
        chamadasNaoAtendidas = new ArrayList<>();
        listaDeContatos = new ArrayList<>();
    }

    public Contato getContato() {
        return this.contato;
    }

    public boolean existeNaAgenda(Contato contato){
        return listaDeContatos.contains(contato);
    }    

    public void adicionaNovo(Contato contato){
        listaDeContatos.add(contato);
    }

    public void adicionaChamadaNaoAtendida(Contato contato){
        chamadasNaoAtendidas.add(contato);
    }

    public boolean verificaContatoExistente(String contato) {
        if (listaDeContatos.size() > 0) {
            for (int i = 0; i < listaDeContatos.size(); i++) {
                if (listaDeContatos.get(i).getTelefone().equals(contato) || listaDeContatos.get(i).getNome().equals(contato)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean verificaContatoChamadasNaoAtendidas(String contato) {
        if (chamadasNaoAtendidas.size() > 0) {
            for (int i = 0; i < chamadasNaoAtendidas.size(); i++) {
                if (chamadasNaoAtendidas.get(i).getTelefone().equals(contato) || chamadasNaoAtendidas.get(i).getNome().equals(contato)) {
                    return true;
                }
            }
        }
        return false;
    }

    public Contato retornaContatoExistente(String contatoDaAgenda) {
        contato = null;
        for (int i = 0; i < listaDeContatos.size(); i++) {
            if (listaDeContatos.get(i).getTelefone().equals(contatoDaAgenda)
                    || listaDeContatos.get(i).getNome().equals(contatoDaAgenda)) {
                contato = listaDeContatos.get(i);
            }
        }
        return contato;
    }

    public Contato retornaContatoChamadaNaoAtendida(String contatoDaAgenda) {
        contato = null;
        for (int i = 0; i < chamadasNaoAtendidas.size(); i++) {
            if (chamadasNaoAtendidas.get(i).getTelefone().equals(contatoDaAgenda)) {
                contato = chamadasNaoAtendidas.get(i);
            }
        }
        return contato;
    }
    
    public Contato acessaChamadaNaoAtendida(int indice){
        return chamadasNaoAtendidas.get(indice);
    }

    public Contato acessaAoContato(int indice){
        return chamadasNaoAtendidas.get(indice);
    }
    
    public int quantiaDeContatos(){
        return listaDeContatos.size();
    }

    public int quantiaDeChamadas() {
        return chamadasNaoAtendidas.size();
    }

    public void excluirTodasAsChamadas() {
        chamadasNaoAtendidas.clear();
    }    

}
