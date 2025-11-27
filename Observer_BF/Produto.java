package Observer_BF;

import java.util.ArrayList;

public class Produto {

    private ArrayList<Assinantes> subscribers;
    private float preco_original;
    private float preco_atual;
    private int promocao;
    private String nome;

    public Produto(String nome, float preco_original){
        this.nome = nome;
        this.preco_original = preco_original;
        this.preco_atual = preco_original;
        this.promocao = 0;
        this.subscribers = new ArrayList<Assinantes>();
    }

    public void subscribe( Assinantes s){
        subscribers.add(s);
    }

    public void unsubscribe( Assinantes s){
        subscribers.remove(s);
    }

    public void notifySubscribers(){
        for(int i = 0; i < subscribers.size(); i++){
            subscribers.get(i).update(this);
        }
    }

    public void mainBussnesLogic(boolean isBlackFraude){

        if(isBlackFraude){
            this.preco_atual = this.preco_original * 0.5f;
            promocao = 1;
            notifySubscribers();
        }else{
            this.preco_atual = this.preco_original;
             promocao = 0;
             notifySubscribers();
        }
    }

    public float getPreco(){
        return this.preco_atual;
    }

    public float getPromocao(){
        return this.promocao;
    }

    public String getNome(){
        return this.nome;
    }
     
}