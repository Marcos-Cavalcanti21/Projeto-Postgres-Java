package MODEL;

public class Caixa {
    private String inicio;
    private String entradas;
    private String saidas;
    private String saldo;

    public Caixa(String inicio, String entradas, String saidas, String saldo) {
        this.inicio = inicio;
        this.entradas = entradas;
        this.saidas = saidas;
        this.saldo = saldo;
    }

    public String getInicio() { return inicio; }

    public void setInicio(String inicio) { this.inicio = inicio; }

    public String getEntradas() { return entradas; }

    public void setEntradas(String entradas) { this.entradas = entradas; }

    public String getSaidas() { return saidas; }

    public void setSaidas(String saidas) { this.saidas = saidas; }

    public String getSaldo() { return saldo; }

    public void setSaldo(String saldo) { this.saldo = saldo; }
}
