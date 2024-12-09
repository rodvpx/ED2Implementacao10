package grafos;

public class Nodo<T> {
    private T item;
    private Nodo<T> prox;
    private int peso;

    public Nodo(T item) {
        this.item = item;
    }

    public T getItem() {
        return item;
    }

    public void setItem(T item) {
        this.item = item;
    }

    public Nodo<T> getProx() {
        return prox;
    }

    public void setProx(Nodo<T> prox) {
        this.prox = prox;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }
}