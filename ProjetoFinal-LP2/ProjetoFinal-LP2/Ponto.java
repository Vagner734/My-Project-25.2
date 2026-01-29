import java.io.Serializable;

public class Ponto implements Serializable {
    private static final long serialVersionUID = 1L;

    int log;
    int lat;

    public Ponto(int log, int lat) {
        this.log = log;
        this.lat = lat;
    }

    @Override
    public String toString() {
        return "(" + log + ", " + lat + ")";
    }
}
