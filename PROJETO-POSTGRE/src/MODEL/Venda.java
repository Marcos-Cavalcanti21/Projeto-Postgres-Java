package MODEL;

import java.sql.Date;

public class Venda {
    private int id;
    private Date dataHora;
    private String cliente;
    private String funcionario;
    private int idProduto;
    private String produto;
    private int qtd;
    private String total;
    private boolean entrega;
    private String entregador;
    private float frete;

//    public Venda(int id, SimpleDateFormat dataHora, String cliente, String funcionario, String produto, int qtd, String total, boolean entrega, String frete, String entregador) {
//        this.id = id;
//        this.dataHora = dataHora;
//        this.cliente = cliente;
//        this.funcionario = funcionario;
//        this.produto = produto;
//        this.qtd = qtd;
//        this.total = total;
//        this.entrega = entrega;
//        this.frete = frete;
//        this.entregador = entregador;
//    }

    public Venda(int id, Date dataHora, String cliente, String funcionario,int idProduto , String produto, int qtd, String total, boolean entrega, String entregador, float frete) {
        this.id = id;
        this.dataHora = dataHora;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.idProduto = idProduto;
        this.produto = produto;
        this.qtd = qtd;
        this.total = total;
        this.entrega = entrega;
        this.entregador = entregador;
        this.frete = frete;
    }

    public Venda(String cliente, String funcionario, String produto, int qtd, boolean entrega, String entregador, float frete) {
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.produto = produto;
        this.qtd = qtd;
        this.entrega = entrega;
        this.entregador = entregador;
        this.frete = frete;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getDataHora() { return dataHora; }

    public void setDataHora(Date dataHora) { this.dataHora = dataHora; }

    public String getCliente() { return cliente; }

    public void setCliente(String cliente) { this.cliente = cliente; }

    public String getFuncionario() { return funcionario; }

    public void setFuncionario(String funcionario) { this.funcionario = funcionario; }

    public int getIdProduto() { return idProduto; }

    public void setIdProduto(int idProduto) { this.idProduto = idProduto; }

    public String getProduto() { return produto; }

    public void setProduto(String produto) { this.produto = produto; }

    public int getQtd() { return qtd; }

    public void setQtd(int qtd) { this.qtd = qtd; }

    public String getTotal() { return total; }

    public void setTotal(String total) { this.total = total; }

    public boolean isEntrega() { return entrega; }

    public void setEntrega(boolean entrega) { this.entrega = entrega; }

    public String getEntregador() { return entregador; }

    public void setEntregador(String entregador) { this.entregador = entregador; }

    public float getFrete() { return frete; }

    public void setFrete(float freteId) { this.frete = freteId; }

}