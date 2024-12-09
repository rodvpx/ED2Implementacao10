
package grafos;

public class Aresta<T> {
	private int peso;
	private Vertice<T> inicio;
	private Vertice<T> fim;

	public Aresta(int peso, Vertice<T> inicio, Vertice<T> fim) {
		this.peso = peso;
		this.inicio = inicio;
		this.fim = fim;
	}

	public Vertice<T> getFim() {
		return fim;
	}

	public void setFim(Vertice<T> fim) {
		this.fim = fim;
	}

	public Vertice<T> getInicio() {
		return inicio;
	}

	public void setInicio(Vertice<T> inicio) {
		this.inicio = inicio;
	}

	public int getPeso() {
		return peso;
	}

	public void setPeso(int peso) {
		this.peso = peso;
	}
}
