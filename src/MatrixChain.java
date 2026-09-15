public class MatrixChain {
    private final Matrix[] matrices;
    private long[][] cost;
    private int[][] split;

    public MatrixChain(Matrix[] matrices) {
        if (matrices == null || matrices.length == 0) {
            throw new IllegalArgumentException("At least one matrix is required.");
        }

        for (int i = 1; i < matrices.length; i++) {
            if (matrices[i - 1].getColumns() != matrices[i].getRows()) {
                throw new IllegalArgumentException(
                    "Invalid matrix chain: " + matrices[i - 1].getName()
                    + " columns (" + matrices[i - 1].getColumns() + ") must equal "
                    + matrices[i].getName() + " rows (" + matrices[i].getRows() + ")."
                );
            }
        }

        this.matrices = matrices;
        this.cost = new long[matrices.length][matrices.length];
        this.split = new int[matrices.length][matrices.length];
    }

    public long optimize() {
        int n = matrices.length;

        for (int i = 0; i < n; i++) {
            cost[i][i] = 0;
        }

        for (int length = 2; length <= n; length++) {
            for (int i = 0; i <= n - length; i++) {
                int j = i + length - 1;
                cost[i][j] = Long.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    long multiplicationCost =
                        (long) matrices[i].getRows()
                        * matrices[k].getColumns()
                        * matrices[j].getColumns();

                    long current =
                        cost[i][k] + cost[k + 1][j] + multiplicationCost;

                    if (current < cost[i][j]) {
                        cost[i][j] = current;
                        split[i][j] = k;
                    }
                }
            }
        }

        return cost[0][n - 1];
    }

    public String getOptimalOrder() {
        if (matrices.length == 1) {
            return matrices[0].getName();
        }
        return buildOrder(0, matrices.length - 1);
    }

    private String buildOrder(int i, int j) {
        if (i == j) {
            return matrices[i].getName();
        }

        int k = split[i][j];
        return "(" + buildOrder(i, k) + " × " + buildOrder(k + 1, j) + ")";
    }

    public long[][] getCostTable() {
        return cost;
    }

    public int[][] getSplitTable() {
        return split;
    }

    public Matrix[] getMatrices() {
        return matrices;
    }
}
