public class CuboAdapter extends Cilindro{
    private Cubo cubo;
    public CuboAdapter(Cubo cubo){
        this.cubo = cubo;
    }

    @Override
    public int getRaio() {
        return (int) (this.cubo.getLado() * Math.sqrt(2)/2);
    }
}
