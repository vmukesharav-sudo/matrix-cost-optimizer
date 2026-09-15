# Viva Questions and Answers

1. What is Matrix Chain Multiplication?
Matrix Chain Multiplication is an optimization problem that finds the best order for multiplying a sequence of matrices.

2. Does the order change the final result?
No. Matrix multiplication is associative, so the final result is the same, but the computational cost can change.

3. Which technique is used?
Dynamic Programming.

4. What is the main data structure?
Two-dimensional arrays are used for the cost and split tables.

5. What does cost[i][j] represent?
The minimum scalar multiplication cost for matrices i through j.

6. What does split[i][j] store?
The position at which the optimal chain is divided.

7. What is the time complexity?
O(n^3).

8. What is the space complexity?
O(n^2).

9. Why is brute force inefficient?
It evaluates many repeated subproblems and the number of parenthesizations grows rapidly.

10. What is a scalar multiplication?
Multiplication of two individual numeric elements during matrix multiplication.

11. When can two matrices be multiplied?
The columns of the first matrix must equal the rows of the second matrix.

12. What language is used?
Java.

13. Why are arrays useful here?
They provide direct indexed access and are suitable for DP tables.

14. What is the base case?
Multiplying a single matrix requires zero scalar multiplications.

15. What is the main advantage of the project?
It finds the minimum multiplication cost without trying every parenthesization explicitly.
