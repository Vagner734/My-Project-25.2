public class Buraco {

    private int raio;
    public Buraco (int raio) {
        this.raio = raio;
    }
    public int getRaio() {
        return this.raio;
    }

    public int setRaio() {
        return this.raio;
    }
    public boolean verificatamanho(Cilindro c) {
        return c.getRaio() <= this.raio? true : false;

    }
}
