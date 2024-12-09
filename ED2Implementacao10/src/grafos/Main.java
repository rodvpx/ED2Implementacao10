package grafos;

public class Main {

	public static void main(String[] args) {

		Grafo<String> grafo = new Grafo();

		grafo.addVertice(("Nattane")); // Informatica / pratico/Linguagens
		grafo.addVertice(("Lucas")); // Matematica
		grafo.addVertice(("Cristiane")); // Informatica / pratico / teorico / linguagens
		grafo.addVertice(("Junio")); // Informatica / pratico/ Teorico
		grafo.addVertice(("Jean")); // Linguagens/Redes/ teorico
		grafo.addVertice(("Paulo")); // Linguagens / teorico
		grafo.addVertice(("Júlio")); // Matematica
		grafo.addVertice(("Aumaury")); // Informatica / teorico
		grafo.addVertice(("Gabriel")); // Informatica / pratico / teorico
		grafo.addVertice(("Marcio")); // Informatica / linguagens

		grafo.addVertice(("Desenvolvimento Web I")); // Informatica/ pratica
		grafo.addVertice(("Álgebra Linear")); // Matematica
		grafo.addVertice(("Banco de Dados II")); // Informatica / pratico
		grafo.addVertice(("Estrutura de Dados II")); // Informatica / terorico
		grafo.addVertice(("Redes de Computadores")); // Redes / teorico
		grafo.addVertice(("Programação II")); // Informatica / pratico
		grafo.addVertice(("Eng. de Software")); // Informatica / terorico
		grafo.addVertice(("Lógica")); // Matematica
		grafo.addVertice(("Sistemas Operacionais")); // Informatica / terorico
		grafo.addVertice(("Metodologia Cientifica")); // Linguagens
		grafo.addVertice(("Intro. Mineração de Dados")); // Informatica / terorico
		grafo.addVertice(("Programação Mobile")); // Informatica / pratico
		grafo.addVertice(("Elaboração de Projetos")); // Informatica / teorico / linguagens
		grafo.addVertice(("Projeto Integrador III")); // Informatica / teorico / linguagens
		grafo.addVertice(("Arquitetura de Software")); // Informatica / teorico
		grafo.addVertice(("Marketing e Inovação")); // Informatica / linguagens
		grafo.addVertice(("Etica")); // Informatica / linguagens
		
		grafo.addAresta(0, ("Nattane"), ("Desenvolvimento Web I"));
		grafo.addAresta(1, ("Nattane"), ("Metodologia Cientifica"));
		grafo.addAresta(2, ("Nattane"), ("Intro. Mineração de Dados"));
		grafo.addAresta(0, ("Lucas"), ("Álgebra Linear"));
		grafo.addAresta(0, ("Cristiane"), ("Banco de Dados II"));
		grafo.addAresta(1, ("Cristiane"), ("Programação II"));
		grafo.addAresta(2, ("Cristiane"), ("Elaboração de Projetos"));
		grafo.addAresta(0, ("Junio"), ("Estrutura de Dados II"));
		grafo.addAresta(1, ("Junio"), ("Programação Mobile"));
		grafo.addAresta(0, ("Jean"), ("Redes de Computadores"));
		grafo.addAresta(1, ("Jean"), ("Etica"));
		grafo.addAresta(0, ("Paulo"), ("Eng. de Software"));
		grafo.addAresta(0, ("Júlio"), ("Lógica"));
		grafo.addAresta(0, ("Aumaury"), ("Sistemas Operacionais"));
		grafo.addAresta(0, ("Gabriel"), ("Arquitetura de Software"));
		grafo.addAresta(0, ("Marcio"), ("Marketing e Inovação"));

		// 1. Listas de professores e disciplinas
		String[] professores = {"Nattane", "Lucas", "Cristiane", "Junio", "Jean", "Paulo", "Júlio", "Aumaury", "Gabriel", "Marcio"};
		String[] disciplinas = {"Desenvolvimento Web I", "Álgebra Linear", "Banco de Dados II", "Estrutura de Dados II", "Redes de Computadores", "Metodologia Científica"};

		// 2. Criar a matriz de custos
		int[][] costMatrix = {
				{2, 1, 2, 10, 10, 10}, // Nattane
				{10, 0, 10, 10, 10, 10}, // Lucas
				{0, 1, 2, 10, 10, 10}, // Cristiane
				{0, 1, 10, 10, 10, 10}, // Junio
				{0, 10, 10, 10, 10, 1}, // Jean
				{10, 10, 10, 10, 0, 10}, // Paulo
				{10, 0, 10, 10, 10, 10}, // Júlio
				{10, 10, 10, 0, 10, 10}, // Aumaury
				{10, 10, 10, 10, 1, 10}, // Gabriel
				{10, 10, 10, 1, 10, 10}  // Marcio
		};

		// 3. Executar o algoritmo Húngaro
		AlgoritimoHungaro hungaro = new AlgoritimoHungaro();
		int[] assignment = hungaro.hungarianAlgorithm(costMatrix);

// 4. Interpretar o resultado
		System.out.println("Melhor correspondência (Professor -> Disciplina):");
		for (int i = 0; i < assignment.length; i++) {
			int professorIndex = assignment[i];
			if (professorIndex != -1) { // Verificar se a disciplina tem professor atribuído
				System.out.println("Professor: " + professores[professorIndex] + " -> Disciplina: " + disciplinas[i]);
			}
		}

	}

}
