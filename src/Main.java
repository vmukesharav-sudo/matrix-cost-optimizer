import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    private static Matrix[] matrices;
    private static MatrixChain chain;

    public static void main(String[] args) {
        printHeader();

        boolean running = true;
        while (running) {
            printMenu();
            int choice = readInt("Enter your choice: ");

            switch (choice) {
                case 1 -> enterMatrices();
                case 2 -> displayMatrices();
                case 3 -> optimize();
                case 4 -> displayCostTable();
                case 5 -> displayComplexity();
                case 6 -> loadSample();
                case 7 -> {
                    System.out.println("\nThank you for using Matrix Cost Optimizer!");
                    running = false;
                }
                default -> System.out.println("\nInvalid choice. Please select 1-7.");
            }
        }
        scanner.close();
    }

    private static void printHeader() {
        System.out.println("==============================================");
        System.out.println("          MATRIX COST OPTIMIZER");
        System.out.println("   Java Data Structures Mini Project");
        System.out.println("==============================================");
    }

    private static void printMenu() {
        System.out.println("\n--------------- MENU ----------------");
        System.out.println("1. Enter matrices");
        System.out.println("2. Display matrix dimensions");
        System.out.println("3. Find minimum multiplication cost");
        System.out.println("4. Display DP cost table");
        System.out.println("5. Display algorithm complexity");
        System.out.println("6. Load sample matrices");
        System.out.println("7. Exit");
        System.out.println("--------------------------------------");
    }

    private static void enterMatrices() {
        int n;
        do {
            n = readInt("Enter number of matrices (1 or more): ");
            if (n <= 0) {
                System.out.println("Number of matrices must be positive.");
            }
        } while (n <= 0);

        Matrix[] temp = new Matrix[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter dimensions for A" + (i + 1));
            int rows = readPositiveInt("Rows: ");
            int columns = readPositiveInt("Columns: ");

            if (i > 0 && temp[i - 1].getColumns() != rows) {
                System.out.println("Invalid dimension. A" + i + " has "
                    + temp[i - 1].getColumns()
                    + " columns, so A" + (i + 1)
                    + " must have " + temp[i - 1].getColumns() + " rows.");
                System.out.println("Please restart matrix entry with compatible dimensions.");
                return;
            }

            temp[i] = new Matrix("A" + (i + 1), rows, columns);
        }

        matrices = temp;
        chain = new MatrixChain(matrices);
        System.out.println("\nMatrices entered successfully.");
    }

    private static void loadSample() {
        matrices = new Matrix[] {
            new Matrix("A1", 10, 30),
            new Matrix("A2", 30, 5),
            new Matrix("A3", 5, 60)
        };
        chain = new MatrixChain(matrices);

        System.out.println("\nSample data loaded:");
        displayMatrices();
    }

    private static void displayMatrices() {
        if (!checkData()) return;

        System.out.println("\nMatrix Dimensions:");
        for (Matrix matrix : matrices) {
            System.out.println("  " + matrix);
        }
    }

    private static void optimize() {
        if (!checkData()) return;

        long minimumCost = chain.optimize();

        System.out.println("\n==============================================");
        System.out.println("                 RESULT");
        System.out.println("==============================================");
        System.out.println("Minimum Scalar Multiplication Cost: " + minimumCost);
        System.out.println("Optimal Multiplication Order: " + chain.getOptimalOrder());
        System.out.println("==============================================");
    }

    private static void displayCostTable() {
        if (!checkData()) return;

        chain.optimize();
        long[][] table = chain.getCostTable();

        System.out.println("\nDynamic Programming Cost Table:");
        System.out.print("      ");
        for (int i = 0; i < matrices.length; i++) {
            System.out.printf("%8s", "A" + (i + 1));
        }
        System.out.println();

        for (int i = 0; i < matrices.length; i++) {
            System.out.printf("%-6s", "A" + (i + 1));
            for (int j = 0; j < matrices.length; j++) {
                if (j < i) {
                    System.out.printf("%8s", "-");
                } else {
                    System.out.printf("%8d", table[i][j]);
                }
            }
            System.out.println();
        }
    }

    private static void displayComplexity() {
        System.out.println("\nAlgorithm Complexity");
        System.out.println("---------------------");
        System.out.println("Time Complexity : O(n^3)");
        System.out.println("Space Complexity: O(n^2)");
        System.out.println("Data Structures : 1D and 2D arrays");
        System.out.println("Technique       : Dynamic Programming");
    }

    private static boolean checkData() {
        if (matrices == null || chain == null) {
            System.out.println("\nNo matrices available. Choose option 1 or 6 first.");
            return false;
        }
        return true;
    }

    private static int readPositiveInt(String message) {
        int value;
        do {
            value = readInt(message);
            if (value <= 0) {
                System.out.println("Please enter a positive integer.");
            }
        } while (value <= 0);
        return value;
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            if (scanner.hasNextInt()) {
                return scanner.nextInt();
            }
            System.out.println("Invalid input. Enter an integer.");
            scanner.next();
        }
    }
}
