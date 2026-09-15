import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);

    static Matrix[] matrices = null;

    public static void main(String[] args) {

        int choice;

        do {

            showMenu();

            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                case 1:
                    enterMatrices();
                    break;

                case 2:
                    displayDimensions();
                    break;

                case 3:
                    findMinimumCost();
                    break;

                case 4:
                    displayDPTable();
                    break;

                case 5:
                    displayComplexity();
                    break;

                case 6:
                    loadSampleMatrices();
                    break;

                case 7:
                    System.out.println();
                    System.out.println(
                        "Thank you for using Matrix Cost Optimizer!"
                    );
                    break;

                default:
                    System.out.println();
                    System.out.println(
                        "Invalid choice! Please enter 1 to 7."
                    );
            }

        } while (choice != 7);

        scanner.close();
    }


    // MENU
    static void showMenu() {

        System.out.println();
        System.out.println("==========================================");
        System.out.println("        MATRIX COST OPTIMIZER");
        System.out.println("==========================================");
        System.out.println("1. Enter matrices");
        System.out.println("2. Display matrix dimensions");
        System.out.println("3. Find minimum multiplication cost");
        System.out.println("4. Display DP cost table");
        System.out.println("5. Display algorithm complexity");
        System.out.println("6. Load sample matrices");
        System.out.println("7. Exit");
        System.out.println("==========================================");
    }


    // OPTION 1
    static void enterMatrices() {

        System.out.println();
        System.out.println("----- ENTER MATRICES -----");

        System.out.print("Enter number of matrices: ");

        int n = scanner.nextInt();
        scanner.nextLine();

        matrices = new Matrix[n];

        for (int i = 0; i < n; i++) {

            System.out.println();
            System.out.println("Matrix A" + (i + 1));

            System.out.print("Enter rows: ");
            int rows = scanner.nextInt();

            System.out.print("Enter columns: ");
            int columns = scanner.nextInt();

            scanner.nextLine();

            matrices[i] =
                new Matrix("A" + (i + 1), rows, columns);
        }

        System.out.println();
        System.out.println("Matrices entered successfully!");
    }


    // OPTION 2
    static void displayDimensions() {

        System.out.println();
        System.out.println("----- MATRIX DIMENSIONS -----");

        if (matrices == null) {

            System.out.println(
                "No matrices loaded!"
            );

            System.out.println(
                "Please choose option 1 or option 6 first."
            );

            return;
        }

        for (int i = 0; i < matrices.length; i++) {

            System.out.println(
                matrices[i].name
                + " = "
                + matrices[i].rows
                + " x "
                + matrices[i].columns
            );
        }
    }


    // OPTION 3
    static void findMinimumCost() {

        System.out.println();
        System.out.println("----- MINIMUM MULTIPLICATION COST -----");

        if (matrices == null) {

            System.out.println(
                "No matrices loaded!"
            );

            System.out.println(
                "Please choose option 1 or option 6 first."
            );

            return;
        }

        if (!checkCompatibility()) {
            return;
        }

        MatrixChain chain =
            new MatrixChain(matrices);

        long cost =
            chain.findMinimumCost();

        System.out.println(
            "Minimum multiplication cost = "
            + cost
        );

        System.out.println(
            "Optimal order = "
            + chain.getOptimalOrder()
        );
    }


    // OPTION 4
    static void displayDPTable() {

        System.out.println();
        System.out.println("----- DP COST TABLE -----");

        if (matrices == null) {

            System.out.println(
                "No matrices loaded!"
            );

            System.out.println(
                "Please choose option 1 or option 6 first."
            );

            return;
        }

        if (!checkCompatibility()) {
            return;
        }

        MatrixChain chain =
            new MatrixChain(matrices);

        chain.findMinimumCost();

        int n = matrices.length;

        System.out.println();

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n; j++) {

                if (j < i) {

                    System.out.printf("%10s", "-");

                } else {

                    System.out.printf(
                        "%10d",
                        chain.dp[i][j]
                    );
                }
            }

            System.out.println();
        }
    }


    // OPTION 5
    static void displayComplexity() {

        System.out.println();
        System.out.println("----- ALGORITHM COMPLEXITY -----");

        System.out.println(
            "Algorithm          : Matrix Chain Multiplication"
        );

        System.out.println(
            "Technique          : Dynamic Programming"
        );

        System.out.println(
            "Time Complexity    : O(n^3)"
        );

        System.out.println(
            "Space Complexity   : O(n^2)"
        );
    }


    // OPTION 6
    static void loadSampleMatrices() {

        matrices = new Matrix[3];

        matrices[0] =
            new Matrix("A1", 10, 30);

        matrices[1] =
            new Matrix("A2", 30, 5);

        matrices[2] =
            new Matrix("A3", 5, 60);

        System.out.println();
        System.out.println(
            "Sample matrices loaded successfully!"
        );

        displayDimensions();
    }


    // COMPATIBILITY CHECK
    static boolean checkCompatibility() {

        for (int i = 0; i < matrices.length - 1; i++) {

            if (matrices[i].columns
                    != matrices[i + 1].rows) {

                System.out.println();
                System.out.println(
                    "Matrix multiplication is not possible."
                );

                System.out.println(
                    matrices[i].name
                    + " columns must equal "
                    + matrices[i + 1].name
                    + " rows."
                );

                return false;
            }
        }

        return true;
    }
}