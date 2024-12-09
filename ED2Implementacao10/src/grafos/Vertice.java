package grafos;

import java.util.ArrayList;
import java.util.List;

public class Vertice<T> {
	private T dado;
	private List<Aresta<T>> arestasEntrada;
	private List<Aresta<T>> arestasSaida;

	public Vertice(T valor) {
		dado = valor;
		arestasEntrada = new ArrayList<Aresta<T>>();
		arestasSaida = new ArrayList<Aresta<T>>();
	}

	public T getDado() {
		return dado;
	}

	public void setDado(T dado) {
		this.dado = dado;
	}

	public void addArestaEntrada(Aresta<T> aresta) {
		arestasEntrada.add(aresta);
	}

	public void addArestaSaida(Aresta<T> aresta) {
		arestasSaida.add(aresta);
	}

	public List<Aresta<T>> getArestasEntrada() {
		return arestasEntrada;
	}

	public void setArestasEntrada(List<Aresta<T>> restasEntrada) {
		this.arestasEntrada = restasEntrada;
	}

	public List<Aresta<T>> getArestasSaida() {
		return arestasSaida;
	}

	public void setArestasSaida(List<Aresta<T>> restasSaida) {
		this.arestasSaida = restasSaida;
	}
	@Override
	public String toString() {
		return dado.toString();
	}
}
