package grafos;

public class Main {

	public static void main(String[] args) {
		// Criação do grafo com 16 vértices (10 professores + 6 disciplinas)
		Grafo<String> grafo = new Grafo<>(16);

		// Adicionando professores
		String[] professores = {"Nattane", "Lucas", "Cristiane", "Junio", "Jean", "Paulo", "Júlio", "Aumaury", "Gabriel", "Marcio"};
		String[] disciplinas = {"Desenvolvimento Web I", "Álgebra Linear", "Banco de Dados II", "Estrutura de Dados II",
				"Redes de Computadores", "Metodologia Científica"};

		// Adicionando os professores e disciplinas no grafo
		for (String professor : professores) {
			grafo.addVertice(professor);
		}
		for (String disciplina : disciplinas) {
			grafo.addVertice(disciplina);
		}

		// Adicionando arestas e pesos iniciais
		grafo.addAresta(2, "Nattane", "Desenvolvimento Web I");
		grafo.addAresta(1, "Nattane", "Metodologia Científica");
		grafo.addAresta(2, "Nattane", "Intro. Mineração de Dados");
		grafo.addAresta(10, "Lucas", "Álgebra Linear");
		grafo.addAresta(2, "Cristiane", "Banco de Dados II");
		grafo.addAresta(1, "Cristiane", "Programação II");
		grafo.addAresta(2, "Cristiane", "Elaboração de Projetos");
		grafo.addAresta(1, "Junio", "Estrutura de Dados II");
		grafo.addAresta(1, "Junio", "Programação Mobile");
		grafo.addAresta(2, "Jean", "Redes de Computadores");
		grafo.addAresta(1, "Jean", "Ética");
		grafo.addAresta(1, "Paulo", "Eng. de Software");
		grafo.addAresta(1, "Júlio", "Lógica");
		grafo.addAresta(1, "Aumaury", "Sistemas Operacionais");
		grafo.addAresta(1, "Gabriel", "Arquitetura de Software");
		grafo.addAresta(1, "Marcio", "Marketing e Inovação");

		// Atualização dos pesos (se necessário)
		grafo.atualizarPeso("Nattane", "Desenvolvimento Web I", 3);

		// Obter matriz de custos
		int[][] costMatrix = grafo.getMatrizDeCustos();

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
