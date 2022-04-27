package MODEL;

import java.sql.Time;

public class Venda {
    private int id;
    private Time dataHora;
    private int clienteId;
    private int funcionarioId;
    private int produtoId;
    private int qtd;
    private double total;
    private boolean entrega;
    private int entregadorId;
    private int freteId;

    public Venda(int id, Time dataHora, int clienteId, int funcionarioId, int produtoId, int qtd, double total, boolean entrega, int entregadorId, int freteId) {
        this.id = id;
        this.dataHora = dataHora;
        this.clienteId = clienteId;
        this.funcionarioId = funcionarioId;
        this.produtoId = produtoId;
        this.qtd = qtd;
        this.total = total;
        this.entrega = entrega;
        this.entregadorId = entregadorId;
        this.freteId = freteId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Time getDataHora() {
        return dataHora;
    }

    public void setDataHora(Time dataHora) {
        this.dataHora = dataHora;
    }

    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }

    public int getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(int funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public int getProdutoId() {
        return produtoId;
    }

    public void setProdutoId(int produtoId) {
        this.produtoId = produtoId;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public boolean isEntrega() {
        return entrega;
    }

    public void setEntrega(boolean entrega) {
        this.entrega = entrega;
    }

    public int getEntregadorId() {
        return entregadorId;
    }

    public void setEntregadorId(int entregadorId) {
        this.entregadorId = entregadorId;
    }

    public int getFreteId() {
        return freteId;
    }

    public void setFreteId(int freteId) {
        this.freteId = freteId;
    }
}
