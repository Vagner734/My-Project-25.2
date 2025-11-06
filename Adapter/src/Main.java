public class Main {
    public static void main(String[] args) {
        Buraco buraco = new Buraco(5);
        Cilindro cilindro = new Cilindro(5);

        if (buraco.getRaio() == cilindro.getRaio()) {
            System.out.println("O cilindro pode passar pelo buraco.");
        } else {
            System.out.println("O cilindro não pode passar pelo buraco.");
        }
    }
}