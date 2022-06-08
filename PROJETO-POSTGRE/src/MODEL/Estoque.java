package MODEL;

public class Estoque {

    String produto;
    int qtd;

    public Estoque(String produto, int qtd) {
        this.produto = produto;
        this.qtd = qtd;
    }

    public String getProduto() { return produto; }

    public void setProduto(String produto) { this.produto = produto; }

    public int getQtd() { return qtd; }

    public void setQtd(int qtd) { this.qtd = qtd; }
}
