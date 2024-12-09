package grafos;

import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {
	private T dado;
	private List<Aresta<T>> arestasEntrada;
	private List<Aresta<T>> arestasSaida;

	public Vertice(T valor) {
		this.dado = valor;
		this.arestasEntrada = new ArrayList<>();
		this.arestasSaida = new ArrayList<>();
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public void addArestaEntrada(Aresta<T> aresta) {
		this.arestasEntrada.add(aresta);
	}

	public void addArestaSaida(Aresta<T> aresta) {
		this.arestasSaida.add(aresta);
	}

	public List<Aresta<T>> getArestasEntrada() {
		return arestasEntrada;
	}

	public void setArestasEntrada(List<Aresta<T>> arestasEntrada) {
		this.arestasEntrada = arestasEntrada;
	}

	public List<Aresta<T>> getArestasSaida() {
		return arestasSaida;
	}

	public void setArestasSaida(List<Aresta<T>> arestasSaida) {
		this.arestasSaida = arestasSaida;
	}

	@Override
	public String toString() {
		return dado.toString();
	}
}
