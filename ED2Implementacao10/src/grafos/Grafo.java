package grafos;

import java.util.ArrayList;
import java.util.List;

public class Grafo<T> {
	private List<Vertice<T>> vertices;
	private List<Aresta<T>> arestas;

	public Grafo() {
		// TODO Auto-generated constructor stub
		vertices = new ArrayList<Vertice<T>>();
		arestas = new ArrayList<Aresta<T>>();
	}

	public void addVertice(T dado) {
		Vertice<T> novo = new Vertice<T>(dado);
		vertices.add(novo);
	}

	public void addAresta(int peso, T disciplina, T professor) {
		Vertice<T> inicio = getVertice(disciplina);
		Vertice<T> fim = getVertice(professor);

		Aresta<T> aresta = new Aresta<T>(peso, inicio, fim);

		inicio.addArestaSaida(aresta);
		fim.addArestaEntrada(aresta);
		arestas.add(aresta);

	}

	public Vertice<T> getVertice(T dado) {
		for (Vertice<T> vertice : vertices) {
			if (vertice.getDado().equals(dado))
				return vertice;
		}
		return null;
	}

	public Vertice<T> getVertice(int dado) {

		return vertices.get(dado);
	}

	public Pilha<Vertice<T>> buscaProfundidade(T dado) {
		Pilha<Vertice<T>> pilha = new Pilha<Vertice<T>>();

		pilha.empilha(getVertice(dado));

		while (!pilha.vazia()) {

			for (Aresta<T> aresta : pilha.topopilha().getArestasSaida()) {
				if (!pilha.existe(aresta.getFim())) {
					pilha.empilha(aresta.getFim());
				}
			}

			if (pilha.tamanho() == vertices.size())
				break;

		}
		pilha.imprime();
		return pilha;
	}

	public Pilha<Vertice<T>> buscaProfundidade(T inicio, T fim) {
		Pilha<Vertice<T>> pilha = new Pilha<Vertice<T>>();

		pilha.empilha(getVertice(inicio));

		while (!pilha.vazia()) {

			for (Aresta<T> aresta : pilha.topopilha().getArestasSaida()) {
				if (pilha.topopilha().getDado().equals(fim))
					break;

				if (!pilha.existe(aresta.getFim())) {
					pilha.empilha(aresta.getFim());
				}
			}

			if (pilha.topopilha().getDado().equals(fim))
				break;
		}
		pilha.imprime();
		return pilha;
	}

}
