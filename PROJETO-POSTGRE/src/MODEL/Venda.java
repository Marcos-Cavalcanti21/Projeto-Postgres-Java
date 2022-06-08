package MODEL;

import java.sql.Time;
import java.text.SimpleDateFormat;

public class Venda {
    private int id;
    private SimpleDateFormat dataHora;
    private String cliente;
    private String funcionario;
    private String produto;
    private int qtd;
    private double total;
    private boolean entrega;
    private String entregador;
    private double frete;

    public Venda(int id, SimpleDateFormat dataHora, String cliente, String funcionario, String produto, int qtd, double total, boolean entrega, String entregador, double frete) {
        this.id = id;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.produto = produto;
        this.qtd = qtd;
        this.total = total;
        this.entrega = entrega;
        this.entregador = entregador;
        this.frete = frete;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public SimpleDateFormat getDataHora() { return dataHora; }

    public void setDataHora(SimpleDateFormat dataHora) { this.dataHora = dataHora; }

    public String getCliente() { return cliente; }

    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getFuncionario() { return funcionario; }

    public void setFuncionario(String funcionario) { this.funcionario = funcionario; }

    public String getProduto() { return produto; }

    public void setProduto(String produto) { this.produto = produto; }

    public int getQtd() { return qtd; }

    public void setQtd(int qtd) { this.qtd = qtd; }

    public double getTotal() { return total; }

    public void setTotal(double total) { this.total = total; }

    public boolean isEntrega() { return entrega; }

    public void setEntrega(boolean entrega) { this.entrega = entrega; }

    public String getEntregador() { return entregador; }

    public void setEntregador(String entregador) { this.entregador = entregador; }

    public double getFrete() { return frete; }

    public void setFrete(double freteId) { this.frete = freteId; }

}