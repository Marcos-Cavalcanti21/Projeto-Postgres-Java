package MODEL;

import VIEW.Menu;

public class Funcionario {
    private int id;
    private String nome;
    private String telefone;
    private String cpf;
    private float valorVendido;
    private int qtdEntreg;
    private String endereco;
    private String email;
    private String cargo;

    public Funcionario(String nome, String telefone, String cpf, String endereco, String email, String cargo) {
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.endereco = endereco;
        this.email = email;
        this.cargo = cargo;
    }

    public Funcionario(int id, String nome, String telefone, String cpf, float valorVendido, int qtdEntreg, String endereco, String email, String cargo) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.valorVendido = valorVendido;
        this.qtdEntreg = qtdEntreg;
        this.endereco = endereco;
        this.email = email;
        this.cargo = cargo;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getTelefone() { return telefone; }

    public void setTelefone(String telefone) { this.telefone = telefone; }

    public String getCpf() { return cpf; }

    public void setCpf(String cpf) { this.cpf = cpf; }

    public float getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(float valorVendido) {
        this.valorVendido = valorVendido;
    }

    public int getQtdEntreg() {
        return qtdEntreg;
    }

    public void setQtdEntreg(int qtdEntreg) {
        this.qtdEntreg = qtdEntreg;
    }

    public String getEndereco() { return endereco; }

    public void setEndereco(String endereco) { this.endereco = endereco; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getCargo() { return cargo; }

    public void setCargo(String cargo) { this.cargo = cargo; }
}
