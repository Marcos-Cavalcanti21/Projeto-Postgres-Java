package MODEL;

public class Produto {
    private int id;
    private String nome;
    private int categoriaId;
    private int vendas;
    private int estoque;
    private double preco;

    public Produto(int id, String nome, int categoriaId, int vendas, int estoque, double preco) {
        this.id = id;
        this.nome = nome;
        this.categoriaId = categoriaId;
        this.vendas = vendas;
        this.estoque = estoque;
        this.preco = preco;
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

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getVendas() {
        return vendas;
    }

    public void setVendas(int vendas) {
        this.vendas = vendas;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
}
