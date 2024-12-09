package grafos;

public class Pilha<T> {
	private Nodo<T> topo;
	private int tam;

	public Pilha() {
		this.topo = null;
		this.tam = 0;
	}

	public void empilha(T x) {
		Nodo<T> aux = this.topo;
		this.topo = new Nodo<T>(x);
		this.topo.prox = aux;
		this.tam++;
	}

	public T desempilha() {
		if (this.vazia()) {
			System.out.println("Erro: A pilha esta vazia");
			return null;
		}
		T item = this.topo.item;
		this.topo = this.topo.prox;
		this.tam--;
		return item;
	}

	public T topopilha() {
		if (this.vazia()) {
			System.out.println("Erro : A pilha esta vazia");
			return null;
		}
		T elemento = this.topo.item;
		return elemento;
	}

	public boolean vazia() {
		return (this.topo == null);
	}

	public boolean existe(T dado) {

		Pilha<T> p = new Pilha<T>();
		boolean existe = false;
		while (!vazia()) {
			T dadoPilha = desempilha();
			p.empilha(dadoPilha);
			if (dadoPilha.equals(dado)) {
				existe = true;
				break;
			}
		}
		rempilharPilha(p);
		return existe;
	}

	public void rempilharPilha(Pilha<T> pilha){
		while (!pilha.vazia()) {
			this.empilha(pilha.desempilha());
		}
	}

	public void imprime() {
		Nodo<T> aux = topo;
		do {
			System.out.println(aux.item.toString() + " ");
			aux = aux.prox;
		} while (aux != null);
	}

	public int tamanho() {
		return this.tam;
	}
}
