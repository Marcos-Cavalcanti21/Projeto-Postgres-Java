package MODEL;

public class Frete {
    private int id;
    private float distancia;
    private String valor;

    public Frete(int id, float distancia, String valor) {
        this.id = id;
        this.distancia = distancia;
        this.valor = valor;
    }

    public Frete(float distancia, String valor) {
        this.distancia = distancia;
        this.valor = valor;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public float getDistancia() { return distancia; }

    public void setDistancia(float distancia) { this.distancia = distancia; }

    public String getValor() { return valor; }

    public void setValor(String valor) { this.valor = valor; }
}
