package grafos;

public class Main {

	public static void main(String[] args) {

		// Criação do grafo com 24 vértices (9 professores + 15 disciplinas)
		Grafo<String> grafo = new Grafo<>(24);

		// Adicionando professores
		String[] professores = {"Nattane", "Lucas", "Cristiane", "Junio", "Jean", "Paulo", "Júlio", "Aumaury", "Gabriel"};
		String[] disciplinas = {"Desenvolvimento Web I", "Álgebra Linear", "Banco de Dados II", "Estrutura de Dados II",
				"Redes de Computadores", "Metodologia Científica", "Programação II", "Elaboração de Projetos",
				"Programação Mobile", "Ética", "Eng. de Software", "Lógica", "Sistemas Operacionais",
				"Arquitetura de Software", "Marketing e Inovação"};

		// Adicionando os professores e disciplinas no grafo
		for (String professor : professores) {
			grafo.addVertice(professor);
		}
		for (String disciplina : disciplinas) {
			grafo.addVertice(disciplina);
		}

		// Adicionando arestas e pesos
		grafo.addAresta(2, professores[0], disciplinas[0]); // Nattane -> Desenvolvimento Web I
		grafo.addAresta(1, professores[0], disciplinas[5]); // Nattane -> Metodologia Científica
		grafo.addAresta(2, professores[0], disciplinas[2]); // Nattane -> Intro. Mineração de Dados
		grafo.addAresta(10, professores[1], disciplinas[1]); // Lucas -> Álgebra Linear
		grafo.addAresta(2, professores[2], disciplinas[2]); // Cristiane -> Banco de Dados II
		grafo.addAresta(1, professores[2], disciplinas[6]); // Cristiane -> Programação II
		grafo.addAresta(2, professores[2], disciplinas[7]); // Cristiane -> Elaboração de Projetos
		grafo.addAresta(1, professores[3], disciplinas[3]); // Junio -> Estrutura de Dados II
		grafo.addAresta(1, professores[3], disciplinas[8]); // Junio -> Programação Mobile
		grafo.addAresta(2, professores[4], disciplinas[4]); // Jean -> Redes de Computadores
		grafo.addAresta(1, professores[4], disciplinas[9]); // Jean -> Ética
		grafo.addAresta(1, professores[5], disciplinas[10]); // Paulo -> Eng. de Software
		grafo.addAresta(1, professores[6], disciplinas[11]); // Júlio -> Lógica
		grafo.addAresta(1, professores[7], disciplinas[12]); // Aumaury -> Sistemas Operacionais
		grafo.addAresta(1, professores[8], disciplinas[13]); // Gabriel -> Arquitetura de Software
		grafo.addAresta(1, professores[1], disciplinas[14]); // Lucas -> Marketing e Inovação

		// Matriz de custos
		int[][] costMatrix = {
				{2, 10, 2, 10, 10, 1, 10, 10, 10, 10, 10, 10, 10, 10, 2}, // Nattane
				{10, 0, 10, 10, 3, 10, 10, 10, 10, 10, 5, 10, 10, 10, 10}, // Lucas
				{10, 1, 2, 10, 10, 2, 1, 2, 10, 10, 10, 4, 10, 10, 10}, // Cristiane
				{10, 1, 10, 1, 10, 10, 10, 10, 1, 10, 10, 10, 2, 10, 6}, // Junio
				{10, 10, 10, 10, 1, 10, 10, 10, 10, 1, 10, 10, 10, 10, 10}, // Jean
				{10, 3, 10, 10, 10, 1, 10, 10, 10, 10, 1, 10, 10, 10, 10}, // Paulo
				{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10, 10}, // Júlio
				{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 10, 10}, // Aumaury
				{10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 1, 10}, // Gabriel
		};

		// Execução do Algoritmo Húngaro
		AlgoritimoHungaro hungaro = new AlgoritimoHungaro();
		int[] assignment = hungaro.hungarianAlgorithm(costMatrix);

		// Exibição do resultado
		System.out.println("Melhor correspondência (Professor -> Disciplina):");
		for (int i = 0; i < assignment.length; i++) {
			int professorIndex = assignment[i];
			if (professorIndex != -1) { // Verificar se a disciplina tem professor atribuído
				System.out.println("Professor: " + professores[professorIndex] + " -> Disciplina: " + disciplinas[i]);
			}
		}
	}
}
