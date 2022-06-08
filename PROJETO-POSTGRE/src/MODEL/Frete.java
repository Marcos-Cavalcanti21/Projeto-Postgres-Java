package MODEL;

public class Frete {
    private int id;
    private float distancia;
    private double valor;

    public Frete(int id, float distancia, double valor) {
        this.id = id;
        this.distancia = distancia;
        this.valor = valor;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public float getDistancia() { return distancia; }

    public void setDistancia(float distancia) { this.distancia = distancia; }

    public double getValor() { return valor; }

    public void setValor(double valor) { this.valor = valor; }
}
