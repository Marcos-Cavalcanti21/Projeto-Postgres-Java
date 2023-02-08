package MODEL;

public class Produto {
    private int id;
    private String nome;
    private String categoria;
    private int vendas;
    private int estoque;
    private String preco;


    public Produto(String nome, String categoria, String preco) {
        this.nome = nome;
        this.categoria = categoria;
        this.preco = preco;
    }

    public Produto(int id, String nome, String categoria, int vendas, int estoque, String preco) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.vendas = vendas;
        this.estoque = estoque;
        this.preco = preco;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public int getVendas() { return vendas; }

    public void setVendas(int vendas) { this.vendas = vendas; }

    public int getEstoque() { return estoque; }

    public void setEstoque(int estoque) { this.estoque = estoque; }

    public String getPreco() { return (String.valueOf(preco)); }

    public void setPreco(String preco) { this.preco = preco; }
}