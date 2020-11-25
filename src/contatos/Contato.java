package contatos;

public class Contato {

    private String nome;
    private String telefone;

    public Contato(String nome, String telefone) {
        this.nome = nome;
        this.telefone = telefone;
    }

    public Contato(String telefone) {
        this.nome = "";
        this.telefone = telefone;
    }    

    public String getNome() {
        return this.nome;
    }

    public String getTelefone() {
        return this.telefone;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void desconhecido() {
        this.nome = "";
    }

    @Override
    public String toString() {
        return "Nome: " + getNome() + "\nTelefone: " + getTelefone();
    }

}
