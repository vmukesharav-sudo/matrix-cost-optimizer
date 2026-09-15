# MATRIX COST OPTIMIZER
## Java Data Structures Mini Project

### 1. Abstract
Matrix multiplication is an important operation in computer science and scientific computing. When more than two matrices are multiplied, the order in which the matrices are multiplied affects the number of scalar multiplications required. The final matrix is mathematically the same, but different parenthesizations may have very different computational costs.

The Matrix Cost Optimizer is a Java application that solves this optimization problem using Matrix Chain Multiplication and Dynamic Programming. It accepts compatible matrix dimensions, constructs a cost table, finds the minimum scalar multiplication cost, and displays the optimal parenthesization.

### 2. Introduction
A matrix is a rectangular arrangement of numbers. Two matrices can be multiplied only when the number of columns in the first matrix equals the number of rows in the second matrix.

For a chain A1 A2 ... An, there can be many possible ways to place parentheses. A direct brute-force approach repeatedly evaluates the same subproblems. Dynamic Programming stores the result of each subproblem and reuses it.

### 3. Problem Statement
Design and implement a Java program that accepts a sequence of compatible matrices and determines:
1. The minimum number of scalar multiplications.
2. The optimal order of multiplication.
3. The Dynamic Programming cost table.

### 4. Objectives
- Understand Matrix Chain Multiplication.
- Apply Dynamic Programming.
- Use one-dimensional and two-dimensional arrays.
- Reduce repeated computation.
- Produce a practical Java mini-project.
- Analyze time and space complexity.

### 5. Existing System
A simple approach tries every possible parenthesization. The number of possible parenthesizations grows rapidly as the number of matrices increases. This makes exhaustive search inefficient.

### 6. Proposed System
The proposed system uses Dynamic Programming. Each subproblem is solved once and stored in a two-dimensional table. A second table stores the split point used to reconstruct the optimal multiplication order.

### 7. Data Structures Used
#### 7.1 One-Dimensional Array
Matrix objects are stored in a one-dimensional array.

#### 7.2 Two-Dimensional Array
`cost[i][j]` stores the minimum cost for multiplying matrices i through j.

`split[i][j]` stores the position where the optimal chain is divided.

### 8. Algorithm
For every chain length from 2 to n:
1. Select the starting matrix i.
2. Select the ending matrix j.
3. Try every split k between i and j.
4. Calculate the cost of the left subchain, right subchain, and final multiplication.
5. Store the smallest value in `cost[i][j]`.
6. Store the corresponding split point.

### 9. Recurrence
The recurrence is:

`M[i,j] = min(M[i,k] + M[k+1,j] + p[i-1] * p[k] * p[j])`

where k ranges from i to j-1.

### 10. Modules
- Matrix model
- Matrix chain optimizer
- User interface / menu
- Cost table display
- Complexity display
- Sample data loader

### 11. Sample Test Case
A1 = 10 x 30
A2 = 30 x 5
A3 = 5 x 60

For `(A1 × A2) × A3`:
- A1 × A2 = 10 × 30 × 5 = 1500
- Result × A3 = 10 × 5 × 60 = 3000
- Total = 4500

For `A1 × (A2 × A3)`:
- A2 × A3 = 30 × 5 × 60 = 9000
- A1 × result = 10 × 30 × 60 = 18000
- Total = 27000

Minimum cost = 4500.

### 12. Advantages
- Avoids repeated subproblem calculations.
- Finds the globally optimal order.
- Easy to understand and implement.
- Demonstrates Dynamic Programming clearly.
- Suitable for educational use.

### 13. Limitations
- It optimizes multiplication order, not the actual matrix values.
- Time complexity is O(n^3).
- Space complexity is O(n^2).
- Very large matrix chains require more memory.

### 14. Future Enhancements
- Java Swing or JavaFX GUI.
- Graphical visualization of the DP table.
- Execution-time comparison with recursive brute force.
- Export results to PDF/CSV.
- Random test-case generation.
- Performance charts.

### 15. Conclusion
The Matrix Cost Optimizer demonstrates how Data Structures and Dynamic Programming can be applied to a practical optimization problem. By storing intermediate results in a DP table, the program efficiently determines the minimum scalar multiplication cost and the best parenthesization. The project provides a strong example of algorithmic optimization in Java.

### 16. References
1. Thomas H. Cormen et al., Introduction to Algorithms.
2. Robert Lafore, Data Structures and Algorithms in Java.
3. Oracle Java Documentation.
4. Standard concepts of Matrix Chain Multiplication and Dynamic Programming.
