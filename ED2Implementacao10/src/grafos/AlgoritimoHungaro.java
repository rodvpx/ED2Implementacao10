package grafos;

import java.util.Arrays;

public class AlgoritimoHungaro {

    public int[] hungarianAlgorithm(int[][] costMatrix) {
        int n = costMatrix.length; // Número de linhas (professores)
        int m = costMatrix[0].length; // Número de colunas (disciplinas)

        // Passo 1: Normalização da matriz de custos
        for (int i = 0; i < n; i++) {
            int minRow = Arrays.stream(costMatrix[i]).min().getAsInt();
            for (int j = 0; j < m; j++) {
                costMatrix[i][j] -= minRow;
            }
        }

        for (int j = 0; j < m; j++) {
            int minCol = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                minCol = Math.min(minCol, costMatrix[i][j]);
            }
            for (int i = 0; i < n; i++) {
                costMatrix[i][j] -= minCol;
            }
        }

        // Passo 2: Encontrar atribuições iniciais
        int[] assignment = new int[m]; // Cada índice é a disciplina, e o valor é o professor
        Arrays.fill(assignment, -1);
        boolean[] rowCovered = new boolean[n];
        boolean[] colCovered = new boolean[m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (costMatrix[i][j] == 0 && !rowCovered[i] && !colCovered[j]) {
                    assignment[j] = i;
                    rowCovered[i] = true;
                    colCovered[j] = true;
                }
            }
        }

        // Desmarcar coberturas para reiniciar
        Arrays.fill(rowCovered, false);
        Arrays.fill(colCovered, false);

        // Passo 3: Ajustar matriz de custos até atingir correspondência ideal
        while (true) {
            // Verificar se todas as disciplinas já têm professores atribuídos
            boolean optimal = true;
            for (int j = 0; j < m; j++) {
                if (assignment[j] == -1) {
                    optimal = false;
                    break;
                }
            }
            if (optimal) break;

            // Ajustar valores na matriz
            int minUncovered = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if (!rowCovered[i]) {
                    for (int j = 0; j < m; j++) {
                        if (!colCovered[j]) {
                            minUncovered = Math.min(minUncovered, costMatrix[i][j]);
                        }
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                if (rowCovered[i]) {
                    for (int j = 0; j < m; j++) {
                        costMatrix[i][j] += minUncovered;
                    }
                }
            }

            for (int j = 0; j < m; j++) {
                if (!colCovered[j]) {
                    for (int i = 0; i < n; i++) {
                        costMatrix[i][j] -= minUncovered;
                    }
                }
            }
        }

        return assignment;
    }
}
