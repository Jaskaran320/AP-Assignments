class defaultMatrices {
    private final int r;
    private final int c;
    private final int[][] matrix;
    public defaultMatrices(int[][] mat, int r, int c) {
        this.r = r;
        this.c = c;
        this.matrix = mat;
        checktype();
    }
    public void checktype() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("labels:");
        boolean a1 = isNull(matrix, r, c);
        if (a1) {
            System.out.println("Null");
        }
        boolean a2 = isOnes(matrix, r, c);
        if (a2) {
            System.out.println("Ones");
        }
        boolean a3 = isRectangular(r, c);
        if (a3) {
            System.out.println("Rectangular");
        }
        boolean a4 = isSingular(matrix, r);
        if (a4) {
            System.out.println("Singular");
        }
        boolean a5 = isRowMatrix(r);
        if (a5) {
            System.out.println("Row");
        }
        boolean a6 = isColumnMatrix(c);
        if (a6) {
            System.out.println("Column");
        }
        boolean a7 = isIdentity(matrix, r, c);
        if (a7) {
            System.out.println("Identity");
        }
        boolean a8 = isSingleton(r, c);
        if (a8) {
            System.out.println("Singleton");
        }
        boolean a9 = isSkewSymmetric(matrix, r, c);
        if (a9) {
            System.out.println("SkewSymmetric");
        }
        boolean a10 = isUpperTriangular(matrix, r, c);
        if (a10) {
            System.out.println("UpperTriangular");
        }
        boolean a11 = isLowerTriangular(matrix, r, c);
        if (a11) {
            System.out.println("LowerTriangular");
        }
        boolean a12 = isDiagonal(matrix, r, c);
        if (a12) {
            System.out.println("Diagonal");
        }
        boolean a13 = isSymmetric(matrix, r, c);
        if (a13) {
            System.out.println("Symmetric");
        }
        boolean a14 = isScalar(matrix, r, c);
        if (a14) {
            System.out.println("Scalar");
        }
        boolean a15 = isSquare(r, c);
        if (a15) {
            System.out.println("Square");
        }

    }
    private boolean isNull(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isIdentity(int[][] matrix, int m, int n) {
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((matrix[i][j] != 0 && i != j) || matrix[i][i] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isSingleton(int m, int n) {
        return m == 1 && n == 1;
    }
    private boolean isOnes(int[][] matrix, int m, int n) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isSingular(int[][] matrix, int m) {
        int det;
        if (m == 1) {
            det = matrix[0][0];
        }
        else if (m == 2) {
            det = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        else {
            int x, y, z;
            x = (matrix[1][1] * matrix[2][2]) - (matrix[2][1] * matrix[1][2]);
            y = (matrix[1][0] * matrix[2][2]) - (matrix[2][0] * matrix[1][2]);
            z = (matrix[1][0] * matrix[2][1]) - (matrix[2][0] * matrix[1][1]);
            det = (matrix[0][0] * x)- (matrix[0][1] * y) + (matrix[0][2] * z);
        }
        return det == 0;
    }
    private boolean isRowMatrix(int m) {
        return m == 1;
    }
    private boolean isColumnMatrix(int n) {
        return n == 1;
    }
    private boolean isSkewSymmetric(int[][] matrix, int m, int n) {
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != -matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isUpperTriangular(int[][] matrix, int m, int n) {
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((j < i && matrix[i][j] != 0) || (j > i && matrix[i][j] == 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isLowerTriangular(int[][] matrix, int m, int n) {
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if ((i < j && matrix[i][j] != 0) || (i > j && matrix[i][j] == 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isDiagonal(int[][] matrix, int m, int n) {
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i != j && matrix[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isSymmetric(int[][] matrix, int m, int n) {
        if (m != n) {
            return false;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] != matrix[j][i]) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isScalar(int[][] matrix, int m, int n) {
        if (m != n) {
            return false;
        }
        int k = matrix[0][0];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[j][j] != k || (i != j && matrix[i][j] != 0)) {
                    return false;
                }
            }
        }
        return true;
    }
    private boolean isSquare(int m, int n) {
        return m == n;
    }
    private boolean isRectangular(int m, int n) {
        return m != n;
    }
    public int [][] getMatrix() {
        return matrix;
    }
    public int getRow() {
        return r;
    }
    public int getColumn() {
        return c;
    }
}
