package MODEL;

public class Funcionario {
    private int id;
    private String nome;
    private String telefone;
    private String cpf;
    private double valorVendido;
    private int qtdEntregas;
    private String endereco;
    private String email;
    private int cargoId;

    public Funcionario(int id, String nome, String telefone, String cpf, double valorVendido, int qtdEntregas, String endereco, String email, int cargoId) {
        this.id = id;
        this.nome = nome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.valorVendido = valorVendido;
        this.qtdEntregas = qtdEntregas;
        this.endereco = endereco;
        this.email = email;
        this.cargoId = cargoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getValorVendido() {
        return valorVendido;
    }

    public void setValorVendido(double valorVendido) {
        this.valorVendido = valorVendido;
    }

    public int getQtdEntregas() {
        return qtdEntregas;
    }

    public void setQtdEntregas(int qtdEntregas) {
        this.qtdEntregas = qtdEntregas;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCargoId() {
        return cargoId;
    }

    public void setCargoId(int cargo) {
        this.cargoId = cargo;
    }
}
