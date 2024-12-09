package grafos;

import java.util.Arrays;

public class AlgoritimoHungaro {

    public int[] hungarianAlgorithm(int[][] costMatrix) {
        int n = costMatrix.length;
        int m = costMatrix[0].length;

        // Normalização da matriz de custos
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

        int[] assignment = new int[m];
        Arrays.fill(assignment, -1);
        boolean[] rowCovered = new boolean[n];
        boolean[] colCovered = new boolean[m];
        boolean[][] markedZeros = new boolean[n][m];

        // Encontrar as atribuições iniciais
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (costMatrix[i][j] == 0 && !rowCovered[i] && !colCovered[j]) {
                    assignment[j] = i;
                    rowCovered[i] = true;
                    colCovered[j] = true;
                    markedZeros[i][j] = true;
                }
            }
        }

        Arrays.fill(rowCovered, false);
        Arrays.fill(colCovered, false);

        // Ajuste da matriz de custos
        while (true) {
            // Cobrir todas as linhas e colunas que possuem zeros marcados
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (markedZeros[i][j]) {
                        rowCovered[i] = true;
                        colCovered[j] = true;
                    }
                }
            }

            boolean allZerosCovered = true;
            for (int i = 0; i < n; i++) {
                if (!rowCovered[i]) {
                    allZerosCovered = false;
                    break;
                }
            }

            if (allZerosCovered) {
                break;
            }

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
                if (!rowCovered[i]) {
                    for (int j = 0; j < m; j++) {
                        costMatrix[i][j] -= minUncovered;
                    }
                }
            }

            for (int j = 0; j < m; j++) {
                if (colCovered[j]) {
                    for (int i = 0; i < n; i++) {
                        costMatrix[i][j] += minUncovered;
                    }
                }
            }

            Arrays.fill(rowCovered, false);
            Arrays.fill(colCovered, false);
        }

        return assignment;
    }
}
