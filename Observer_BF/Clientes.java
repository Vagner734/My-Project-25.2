 package Observer_BF;;

public class Clientes implements Assinantes{
    
    public void update(Produto publisher){
        if( publisher.getPromocao() == 1){
            System.out.println("Seu produto está com desconto - preco R$ "+ publisher.getPreco());
        }else{
            System.out.println("Seu produto está com preco R$ "+ publisher.getPreco());
        }
    } 
}