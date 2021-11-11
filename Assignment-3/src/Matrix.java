import java.util.ArrayList;

class Matrix {
    private final int r;
    private final int c;
    private final int[][] matrix;
    private final String name;
    private final String[] type = new String [15];
    ArrayList<column> a = new ArrayList<>();
    ArrayList<diagonal> b = new ArrayList<>();
    ArrayList<identity> c1 = new ArrayList<>();
    ArrayList<lower_triangular> d = new ArrayList<>();
    ArrayList<Null> e = new ArrayList<>();
    ArrayList<ones> f = new ArrayList<>();
    ArrayList<rectangular> g = new ArrayList<>();
    ArrayList<row> h = new ArrayList<>();
    ArrayList<scalar> i1 = new ArrayList<>();
    ArrayList<singleton> j = new ArrayList<>();
    ArrayList<singular> k = new ArrayList<>();
    ArrayList<skew_symmetric> l = new ArrayList<>();
    ArrayList<square> m = new ArrayList<>();
    ArrayList<symmetric> n = new ArrayList<>();
    ArrayList<upper_triangular> o = new ArrayList<>();
    public Matrix(int[][] mat, int m, int n, String nam) {
        this.matrix = mat;
        this.r = m;
        this.c = n;
        this.name = nam;
        checktype();
    }
    public void checktype() {
        int i = 0;
        boolean a1 = isNull(matrix, r, c);
        if (a1) {
            type[i] = "Null";
            Null nu = new Null();
            e.add(nu);
            i++;
        }
        boolean a2 = isOnes(matrix, r, c);
        if (a2) {
            type[i] = "Ones";
            ones on = new ones(r, c);
            f.add(on);
            i++;
        }
        boolean a3 = isRectangular(r, c);
        if (a3) {
            type[i] = "Rectangular";
            rectangular re = new rectangular(matrix, r, c);
            g.add(re);
            i++;
        }
        boolean a4 = isSingular(matrix, r, c);
        if (a4) {
            type[i] = "Singular";
            singular so = new singular(matrix, r, c);
            k.add(so);
            i++;
        }
        boolean a5 = isRowMatrix(r);
        if (a5) {
            type[i] = "Row";
            row ro = new row(matrix, r, c);
            h.add(ro);
            i++;
        }
        boolean a6 = isColumnMatrix(c);
        if (a6) {
            type[i] = "Column";
            column co = new column(matrix, r, c);
            a.add(co);
            i++;
        }
        boolean a7 = isIdentity(matrix, r, c);
        if (a7) {
            type[i] = "Identity";
            identity id = new identity(matrix, r, c);
            c1.add(id);
            i++;
        }
        boolean a8 = isSingleton(r, c);
        if (a8) {
            type[i] = "Singleton";
            singleton si = new singleton(matrix);
            j.add(si);
            i++;
        }
        boolean a9 = isSkewSymmetric(matrix, r, c);
        if (a9) {
            type[i] = "SkewSymmetric";
            skew_symmetric sk = new skew_symmetric(matrix, r, c);
            l.add(sk);
            i++;
        }
        boolean a10 = isUpperTriangular(matrix, r, c);
        if (a10) {
            type[i] = "UpperTriangular";
            upper_triangular up = new upper_triangular(matrix, r, c);
            o.add(up);
            i++;
        }
        boolean a11 = isLowerTriangular(matrix, r, c);
        if (a11) {
            type[i] = "LowerTriangular";
            lower_triangular lo = new lower_triangular(matrix, r, c);
            d.add(lo);
            i++;
        }
        boolean a12 = isDiagonal(matrix, r, c);
        if (a12) {
            type[i] = "Diagonal";
            diagonal di = new diagonal(matrix, r, c);
            b.add(di);
            i++;
        }
        boolean a13 = isSymmetric(matrix, r, c);
        if (a13) {
            type[i] = "Symmetric";
            symmetric sy = new symmetric(matrix, r, c);
            n.add(sy);
            i++;
        }
        boolean a14 = isScalar(matrix, r, c);
        if (a14) {
            type[i] = "Scalar";
            scalar sc = new scalar(matrix, r, c);
            i1.add(sc);
            i++;
        }
        boolean a15 = isSquare(r, c);
        if (a15) {
            type[i] = "Square";
            square sq = new square(matrix, r, c);
            m.add(sq);
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
    private boolean isSingular(int[][] matrix, int m, int n) {
        int det;
        if ((m == 1 && n != 1) || (m != 1 && n == 1)) {
            return false;
        }
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
    public String[] getType() {
        return type;
    }
    public String getName() {
        return name;
    }
    public int getRow() {
        return r;
    }
    public int getColumn() {
        return c;
    }
}
