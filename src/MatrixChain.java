public class MatrixChain {

    Matrix[] matrices;
    long[][] dp;
    int[][] split;

    MatrixChain(Matrix[] matrices) {

        this.matrices = matrices;

        int n = matrices.length;

        dp = new long[n][n];
        split = new int[n][n];
    }

    long findMinimumCost() {

        int n = matrices.length;

        for (int length = 2; length <= n; length++) {

            for (int i = 0; i <= n - length; i++) {

                int j = i + length - 1;

                dp[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {

                    long cost =
                            dp[i][k]
                            + dp[k + 1][j]
                            + (long) matrices[i].rows
                            * matrices[k].columns
                            * matrices[j].columns;

                    if (cost < dp[i][j]) {

                        dp[i][j] = cost;
                        split[i][j] = k;
                    }
                }
            }
        }

        return dp[0][n - 1];
    }

    String getOptimalOrder() {

        return buildOrder(0, matrices.length - 1);
    }

    String buildOrder(int i, int j) {

        if (i == j) {
            return matrices[i].name;
        }

        int k = split[i][j];

        return "("
                + buildOrder(i, k)
                + " × "
                + buildOrder(k + 1, j)
                + ")";
    }
}