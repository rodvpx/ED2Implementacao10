package grafos;

public class Nodo<T> {
	T item;
	Nodo<T> prox;
	int peso;

	public Nodo(T item) {
		this.item = item;
	}
}
