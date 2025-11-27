package Observer_BF;
public class Main {
    public static void main( String[] args){
        Produto p = new Produto("Sorvete de Coco Queimado", 10.0f);
        Clientes c1 = new Clientes();
        Clientes c2 = new Clientes();

        p.subscribe(c1);
        p.subscribe(c2);
        p.unsubscribe(c2);
        p.mainBussnesLogic(true);


    }
}
