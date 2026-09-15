public class Matrix {
    private final String name;
    private final int rows;
    private final int columns;

    public Matrix(String name, int rows, int columns) {
        if (rows <= 0 || columns <= 0) {
            throw new IllegalArgumentException("Rows and columns must be positive.");
        }
        this.name = name;
        this.rows = rows;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    @Override
    public String toString() {
        return name + " = " + rows + " x " + columns;
    }
}
