package grafos;

import java.util.ArrayList;
import java.util.List;

class Grafo<T> {
	private List<Vertice<T>> vertices;
	private List<Aresta<T>> arestas;
	private int[][] matrizDeCustos;
	private int numVertices;

	public Grafo(int numVertices) {
		this.numVertices = numVertices;
		vertices = new ArrayList<>();
		arestas = new ArrayList<>();
		matrizDeCustos = new int[numVertices][numVertices];
	}

	public void addVertice(T dado) {
		vertices.add(new Vertice<>(dado));
	}

	public void addAresta(int peso, T inicio, T fim) {
		Vertice<T> verticeInicio = getVertice(inicio);
		Vertice<T> verticeFim = getVertice(fim);
		if (verticeInicio != null && verticeFim != null) {
			Aresta<T> aresta = new Aresta<>(peso, verticeInicio, verticeFim);
			verticeInicio.addArestaSaida(aresta);
			verticeFim.addArestaEntrada(aresta);
			arestas.add(aresta);

			// Atualizar matriz de custos
			int i = vertices.indexOf(verticeInicio);
			int j = vertices.indexOf(verticeFim);
			matrizDeCustos[i][j] = peso;
		}
	}

	public Vertice<T> getVertice(T dado) {
		for (Vertice<T> vertice : vertices) {
			if (vertice.getDado().equals(dado)) {
				return vertice;
			}
		}
		return null;
	}

	public int[][] getMatrizDeCustos() {
		return matrizDeCustos;
	}
}
