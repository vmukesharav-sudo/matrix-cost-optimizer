# Algorithm and Working

## Input
Number of matrices and the rows/columns of each matrix.

Example:
A1 = 10 x 30
A2 = 30 x 5
A3 = 5 x 60

## Compatibility Check
For every adjacent pair:
columns(Ai) == rows(Ai+1)

If this is false, matrix multiplication is not possible.

## DP Definition
cost[i][j] = minimum scalar multiplications required to multiply Ai ... Aj.

For one matrix:
cost[i][i] = 0.

## Transition
For each split k:

cost[i][j] =
min(cost[i][k] + cost[k+1][j]
+ rows(Ai) * columns(Ak) * columns(Aj))

The split table stores the best k.

## Pseudocode
```text
for i = 0 to n-1
    cost[i][i] = 0

for length = 2 to n
    for i = 0 to n-length
        j = i + length - 1
        cost[i][j] = infinity

        for k = i to j-1
            current = cost[i][k]
                    + cost[k+1][j]
                    + rows(i) * columns(k) * columns(j)

            if current < cost[i][j]
                cost[i][j] = current
                split[i][j] = k

return cost[0][n-1]
```

## Complexity
Time: O(n^3)
Space: O(n^2)

## Why Dynamic Programming?
Different parenthesizations contain repeated matrix-chain subproblems. Dynamic Programming solves each subproblem once and reuses the stored result.
