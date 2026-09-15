# Matrix Cost Optimizer

A Java mini-project based on **Data Structures and Dynamic Programming** for finding the minimum scalar multiplication cost and optimal parenthesization of a chain of matrices.

## Features
- Console-based menu-driven interface
- Matrix Chain Multiplication using Dynamic Programming
- Minimum multiplication cost calculation
- Optimal parenthesization
- DP cost table display
- Matrix dimension validation
- Complexity information
- Sample test data

## Requirements
- Java JDK 8 or later
- Command Prompt / Terminal / IntelliJ IDEA / Eclipse / VS Code

## Project Structure
```text
Matrix_Cost_Optimizer/
├── src/
│   ├── Matrix.java
│   ├── MatrixChain.java
│   └── Main.java
├── docs/
│   ├── PROJECT_REPORT.md
│   ├── ALGORITHM.md
│   └── VIVA_QUESTIONS.md
├── data/
│   └── sample_input.txt
├── screenshots/
└── README.md
```

## Compile and Run
Open a terminal inside the project folder:

```bash
javac -d out src/*.java
java -cp out Main
```

## Example
For matrices:
- A1 = 10 × 30
- A2 = 30 × 5
- A3 = 5 × 60

The minimum cost is **4500** and the optimal order is:

```text
((A1 × A2) × A3)
```

## Data Structures Used
- One-dimensional array for matrix dimensions
- Two-dimensional arrays for Dynamic Programming cost and split tables

## Complexity
- Time: O(n³)
- Space: O(n²)
