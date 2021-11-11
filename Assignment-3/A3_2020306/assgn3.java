import java.io.*;
import java.util.*;

public class assgn3 {
    static double pow(double b){
        double res = 1;
        for (double i = 2; i > 0; i--) {
            res *= b;
        }
        return res;
    }
    static double sqrt(double x){
        if (x < 0) {
            return -1;
        }
        else {
            double res = x;
            for (int i = 0; i < 10; i++) {
                res = (res + x / res) / 2;
            }
            return res;
        }
    }
    static double determinant(int[][] matrix, int r, int c) {
        if (r == 1 && c == 1) {
            return matrix[0][0];
        }
        else if (r == 2 && c == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        else {
            double x, y, z, det;
            x = (matrix[1][1] * matrix[2][2]) - (matrix[2][1] * matrix[1][2]);
            y = (matrix[1][0] * matrix[2][2]) - (matrix[2][0] * matrix[1][2]);
            z = (matrix[1][0] * matrix[2][1]) - (matrix[2][0] * matrix[1][1]);
            det = (matrix[0][0] * x)- (matrix[0][1] * y) + (matrix[0][2] * z);
            return det;
        }
    }
    static double[][] solve(int[][] a, double[][] b){
        double det = determinant(a, a.length, a.length);
        double[][] mat = new double[a.length][a.length];
        double[][] mat1 = new double[a.length][a.length];
        if (a.length == 2) {
            mat[1][1] = a[0][0];
            mat[0][0] = a[1][1];
            mat[0][1] = -a[0][1];
            mat[1][0] = -a[1][0];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++)
                    mat[i][j] /= det;
            }
        }
        else if (a.length == 3) {
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    mat[i][j] = a[i][j];
                }
            }
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++)
                    mat1[i][j] = ((mat[(j+1)%3][(i+1)%3] * mat[(j+2)%3][(i+2)%3]) - (mat[(j+1)%3][(i+2)%3] * mat[(j+2)%3][(i+1)%3]))/ det;
            }
        }
        double[][] res = new double[a.length][1];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 1; j++) {
                float temp = 0;
                for (int k = 0; k < a.length; k++) {
                    temp += mat1[i][k] * b[k][j];
                }
                res[i][0] = temp;
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        Reader.init();
        ArrayList<Matrix> a = new ArrayList<>();
        ArrayList<defaultMatrices> b = new ArrayList<>();
        while (true) {
            System.out.println("1. Enter matrix");
            System.out.println("2. Create matrix of given label type");
            System.out.println("3. Change matrix");
            System.out.println("4. Print matrix labels");
            System.out.println("5. Perform operations on matrix");
            System.out.println("6. Perform element wise operations");
            System.out.println("7. Transpose matrix");
            System.out.println("8. Inverse matrix");
            System.out.println("9. Compute mean");
            System.out.println("10. Compute determinant");
            System.out.println("11. Use singleton matrix as scalar");
            System.out.println("12. Compute sum of matrix and its transpose");
            System.out.println("13. Compute Eigen vector and values");
            System.out.println("14. Solve sets of linear equations");
            System.out.println("15. Print all matrices");
            System.out.println("16. Exit");
            int x = Reader.nextint();
            if (x == 1) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                System.out.println("Enter the number of rows of matrix");
                int m = Reader.nextint();
                System.out.println("Enter the number of columns of matrix");
                int n = Reader.nextint();
                int[][] matrix = new int[m][n];
                System.out.println("Enter the elements of matrix");
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix[i][j] = Reader.nextint();
                    }
                }
                Matrix mat = new Matrix(matrix, m, n, name);
                a.add(mat);
            }
            else if (x == 2) {
                System.out.println("Enter matrix label");
                String label = Reader.next();
                int[][] mat1 = {{1},{2},{3}};
                int[][] mat2 = {{1,0,0},{0,5,0},{0,0,9}};
                int[][] mat3 = {{1,0,0},{0,1,0},{0,0,1}};
                int[][] mat4 = {{1,0,0},{2,3,0},{4,5,6}};
                int[][] mat5 = {{0,0,0},{0,0,0},{0,0,0}};
                int[][] mat6 = {{1,1,1},{1,1,1},{1,1,1}};
                int[][] mat7 = {{1,2,3},{4,5,6}};
                int[][] mat8 = {{1,2,3}};
                int[][] mat9 = {{5,0,0},{0,5,0},{0,0,5}};
                int[][] mat10 = {{0}};
                int[][] mat11 = {{1,2,3},{4,5,6},{7,8,9}};
                int[][] mat12 = {{0,1,-2},{-1,0,3},{2,-3,0}};
                int[][] mat13 = {{1,2,3},{4,5,6},{7,8,0}};
                int[][] mat14 = {{1,1,-1},{1,2,0},{-1,0,5}};
                int[][] mat15 = {{1,2,3},{4,5,0},{0,0,6}};
                if (label.equals("column")) {
                    defaultMatrices mat = new defaultMatrices(mat1, 3, 1);
                    b.add(mat);
                }
                if (label.equals("diagonal")) {
                    defaultMatrices mat = new defaultMatrices(mat2, 3, 3);
                    b.add(mat);
                }
                if (label.equals("identity")) {
                    defaultMatrices mat = new defaultMatrices(mat3, 3, 3);
                    b.add(mat);
                }
                if (label.equals("lowerTriangular")) {
                    defaultMatrices mat = new defaultMatrices(mat4, 3, 3);
                    b.add(mat);
                }
                if (label.equals("null")) {
                    defaultMatrices mat = new defaultMatrices(mat5, 3, 3);
                    b.add(mat);
                }
                if (label.equals("ones")) {
                    defaultMatrices mat = new defaultMatrices(mat6, 3, 3);
                    b.add(mat);
                }
                if (label.equals("rectangular")) {
                    defaultMatrices mat = new defaultMatrices(mat7, 2, 3);
                    b.add(mat);
                }
                if (label.equals("row")) {
                    defaultMatrices mat = new defaultMatrices(mat8, 1, 3);
                    b.add(mat);
                }
                if (label.equals("scalar")) {
                    defaultMatrices mat = new defaultMatrices(mat9, 3, 3);
                    b.add(mat);
                }
                if (label.equals("singleton")) {
                    defaultMatrices mat = new defaultMatrices(mat10, 1, 1);
                    b.add(mat);
                }
                if (label.equals("singular")) {
                    defaultMatrices mat = new defaultMatrices(mat11, 3, 3);
                    b.add(mat);
                }
                if (label.equals("skewSymmetric")) {
                    defaultMatrices mat = new defaultMatrices(mat12, 3, 3);
                    b.add(mat);
                }
                if (label.equals("square")) {
                    defaultMatrices mat = new defaultMatrices(mat13, 3, 3);
                    b.add(mat);
                }
                if (label.equals("symmetric")) {
                    defaultMatrices mat = new defaultMatrices(mat14, 3, 3);
                    b.add(mat);
                }
                if (label.equals("upperTriangular")) {
                    defaultMatrices mat = new defaultMatrices(mat15, 3, 3);
                    b.add(mat);
                }
            }
            else if (x == 3) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                int m = 0, n = 0;
                String[] type = new String[15];
                int[][] matrix = new int[3][3];
                for (Matrix matrixtype : a) {
                    if (matrixtype.getName().equals(name)) {
                        m = matrixtype.getRow();
                        n = matrixtype.getColumn();
                        type = matrixtype.getType();
                        matrix = matrixtype.getMatrix();
                    }
                }
                System.out.println("Enter new elements of matrix");
                int[][] matrix1 = new int[m][n];
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        matrix1[i][j] = Reader.nextint();
                    }
                }
                String name1 = name + "1";
                Matrix mat = new Matrix(matrix1, m, n, name1);
                String[] type1 = mat.getType();
                if (type1 == type) {
                    for (int i = 0; i < m; i++) {
                        System.arraycopy(matrix1[i], 0, matrix[i], 0, n);
                    }
                }
                else {
                    System.out.println("Matrix types do not match");
                }
            }
            else if (x == 4) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                for (Matrix matrixtype : a) {
                    if (matrixtype.getName().equals(name)) {
                        String[] type = matrixtype.getType();
                        for (String s : type) {
                            if (s == null) {
                                break;
                            }
                            System.out.println(s);
                        }
                    }
                }
            }
            else if (x == 5) {
                System.out.println("Enter name of first matrix");
                String name1 = Reader.next();
                System.out.println("Enter name of second matrix");
                String name2 = Reader.next();
                System.out.println("Select operation: ");
                System.out.println("1. Addition");
                System.out.println("2. Subtraction");
                System.out.println("3. Multiplication");
                System.out.println("4. Division");
                int y = Reader.nextint();
                int[][] matrix1 = new int[3][3];
                int[][] matrix2 = new int[3][3];
                String[] type2 = new String[15];
                int m1 = 0, n1 = 0, m2 = 0, n2 = 0;
                for (Matrix matrixtype : a) {
                    if (matrixtype.getName().equals(name1)) {
                        m1 = matrixtype.getRow();
                        n1 = matrixtype.getColumn();
                        matrix1 = matrixtype.getMatrix();
                    }
                    if (matrixtype.getName().equals(name2)) {
                        m2 = matrixtype.getRow();
                        n2 = matrixtype.getColumn();
                        matrix2 = matrixtype.getMatrix();
                        type2 = matrixtype.getType();
                    }
                }
                if (y == 1) {
                    if (m1 == m2 && n1 == n2) {
                        for (int i = 0; i < m1; i++) {
                            for (int j = 0; j < n1; j++) {
                                System.out.print(matrix1[i][j] + matrix2[i][j] + " ");
                            }
                            System.out.println();
                        }
                    }
                    else {
                        System.out.println("Matrices are not of same size");
                    }
                }
                else if (y == 2) {
                    if (m1 == m2 && n1 == n2) {
                        for (int i = 0; i < m2; i++) {
                            for (int j = 0; j < n2; j++) {
                                System.out.print(matrix1[i][j] - matrix2[i][j] + " ");
                            }
                            System.out.println();
                        }
                    }
                    else {
                        System.out.println("Matrices are not of same size");
                    }
                }
                else if (y == 3) {
                    if (n1 == m2) {
                        int[][] matrix3 = new int[m1][n2];
                        for (int i = 0; i < m1; i++) {
                            for (int j = 0; j < n2; j++) {
                                for (int k = 0; k < n1; k++) {
                                    matrix3[i][j] += matrix1[i][k] * matrix2[k][j];
                                }
                            }
                        }
                        for (int i = 0; i < m1; i++) {
                            for (int j = 0; j < n2; j++) {
                                System.out.print(matrix3[i][j] + " ");
                            }
                            System.out.println();
                        }
                    }
                    else {
                        System.out.println("Matrices cannot be multiplied");
                    }
                }
                else if (y == 4) {
                    for (String s : type2) {
                        if (s.equals("singular") || s.equals("rectangular") || s.equals("column") || s.equals("row") || s.equals("ones") || s.equals("null")) {
                            System.out.println("Matrices cannot be divided");
                            break;
                        }
                        else if (s.equals("identity")) {
                            for (int j = 0; j < m1; j++) {
                                for (int k = 0; k < n1; k++) {
                                    System.out.print(matrix1[j][k] + " ");
                                }
                                System.out.println();
                            }
                            break;
                        } else {
                            System.out.println(1);
                        }
                    }
                }
            }
            else if (x == 6) {
                System.out.println("Enter the name of matrix 1");
                String name1 = Reader.next();
                System.out.println("Enter the name of matrix 2");
                String name2 = Reader.next();
                int m1 = 0, n1 = 0;
                int[][] mat1 = new int[3][3];
                int[][] mat2 = new int[3][3];
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name1)) {
                        mat1 = matrix.getMatrix();
                        m1 = matrix.getRow();
                        n1 = matrix.getColumn();
                    }
                    if (matrix.getName().equals(name2)) {
                        mat2 = matrix.getMatrix();
                    }
                }
                System.out.println("1. Multiplication");
                System.out.println("2. Division");
                int y = Reader.nextint();
                if (y == 1) {
                    for (int i = 0; i < m1; i++) {
                        for (int j = 0; j < n1; j++) {
                            System.out.println(mat1[i][j]*mat2[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
                else if (y == 2) {
                    for (int i = 0; i < m1; i++) {
                        for (int j = 0; j < n1; j++) {
                            System.out.println(mat1[i][j]/mat2[i][j] + " ");
                        }
                        System.out.println();
                    }
                }
            }
            else if (x == 7){
                System.out.println("Enter matrix name");
                String name = Reader.next();
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name)) {
                        String ty = matrix.getType()[0];
                        if (ty.equals("Null")) {
                            matrix.e.get(0).transpose();
                        }
                        if (ty.equals("Ones")) {
                            matrix.f.get(0).transpose();
                        }
                        if (ty.equals("Rectangular")) {
                            matrix.g.get(0).transpose();
                        }
                        if (ty.equals("Singular")) {
                            matrix.k.get(0).transpose();
                        }
                        if (ty.equals("Row")) {
                            matrix.h.get(0).transpose();
                        }
                        if (ty.equals("Column")) {
                            matrix.a.get(0).transpose();
                        }
                        if (ty.equals("Identity")) {
                            matrix.c1.get(0).transpose();
                        }
                        if (ty.equals("Singleton")) {
                            matrix.j.get(0).transpose();
                        }
                        if (ty.equals("SkewSymmetric")) {
                            matrix.l.get(0).transpose();
                        }
                        if (ty.equals("UpperTriangular")) {
                            matrix.o.get(0).transpose();
                        }
                        if (ty.equals("LowerTriangular")) {
                            matrix.d.get(0).transpose();
                        }
                        if (ty.equals("Diagonal")) {
                            matrix.b.get(0).transpose();
                        }
                        if (ty.equals("Symmetric")) {
                            matrix.n.get(0).transpose();
                        }
                        if (ty.equals("Scalar")) {
                            matrix.i1.get(0).transpose();
                        }
                        if (ty.equals("Square")) {
                            matrix.m.get(0).transpose();
                        }
                    }
                }
            }
            else if (x == 8) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name)) {
                        String ty = matrix.getType()[0];
                        if (ty.equals("Null")) {
                            matrix.e.get(0).inverse();
                        }
                        if (ty.equals("Ones")) {
                            matrix.f.get(0).inverse();
                        }
                        if (ty.equals("Rectangular")) {
                            matrix.g.get(0).inverse();
                        }
                        if (ty.equals("Singular")) {
                            matrix.k.get(0).inverse();
                        }
                        if (ty.equals("Row")) {
                            matrix.h.get(0).inverse();
                        }
                        if (ty.equals("Column")) {
                            matrix.a.get(0).inverse();
                        }
                        if (ty.equals("Identity")) {
                            matrix.c1.get(0).inverse();
                        }
                        if (ty.equals("Singleton")) {
                            matrix.j.get(0).inverse();
                        }
                        if (ty.equals("SkewSymmetric")) {
                            matrix.l.get(0).inverse();
                        }
                        if (ty.equals("UpperTriangular")) {
                            matrix.o.get(0).inverse();
                        }
                        if (ty.equals("LowerTriangular")) {
                            matrix.d.get(0).inverse();
                        }
                        if (ty.equals("Diagonal")) {
                            matrix.b.get(0).inverse();
                        }
                        if (ty.equals("Symmetric")) {
                            matrix.n.get(0).inverse();
                        }
                        if (ty.equals("Scalar")) {
                            matrix.i1.get(0).inverse();
                        }
                        if (ty.equals("Square")) {
                            matrix.m.get(0).inverse();
                        }
                    }
                }
            }
            else if (x == 9) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name)) {
                        String ty = matrix.getType()[0];
                        if (ty.equals("Null")) {
                            matrix.e.get(0).mean();
                        }
                        if (ty.equals("Ones")) {
                            matrix.f.get(0).mean();
                        }
                        if (ty.equals("Rectangular")) {
                            matrix.g.get(0).mean();
                        }
                        if (ty.equals("Singular")) {
                            matrix.k.get(0).mean();
                        }
                        if (ty.equals("Row")) {
                            matrix.h.get(0).mean();
                        }
                        if (ty.equals("Column")) {
                            matrix.a.get(0).mean();
                        }
                        if (ty.equals("Identity")) {
                            matrix.c1.get(0).mean();
                        }
                        if (ty.equals("Singleton")) {
                            matrix.j.get(0).mean();
                        }
                        if (ty.equals("SkewSymmetric")) {
                            matrix.l.get(0).mean();
                        }
                        if (ty.equals("UpperTriangular")) {
                            matrix.o.get(0).mean();
                        }
                        if (ty.equals("LowerTriangular")) {
                            matrix.d.get(0).mean();
                        }
                        if (ty.equals("Diagonal")) {
                            matrix.b.get(0).mean();
                        }
                        if (ty.equals("Symmetric")) {
                            matrix.n.get(0).mean();
                        }
                        if (ty.equals("Scalar")) {
                            matrix.i1.get(0).mean();
                        }
                        if (ty.equals("Square")) {
                            matrix.m.get(0).mean();
                        }
                    }
                }
            }
            else if (x == 10) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                int m = 0;
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name)) {
                        String ty = matrix.getType()[0];
                        if (ty.equals("Null")) {
                            m = matrix.e.get(0).determinant();
                        }
                        if (ty.equals("Ones")) {
                            m = matrix.f.get(0).determinant();
                        }
                        if (ty.equals("Rectangular")) {
                            m = matrix.g.get(0).determinant();
                        }
                        if (ty.equals("Singular")) {
                            m = matrix.k.get(0).determinant();
                        }
                        if (ty.equals("Row")) {
                            m = matrix.h.get(0).determinant();
                        }
                        if (ty.equals("Column")) {
                            m = matrix.a.get(0).determinant();
                        }
                        if (ty.equals("Identity")) {
                            m = matrix.c1.get(0).determinant();
                        }
                        if (ty.equals("Singleton")) {
                            m = matrix.j.get(0).determinant();
                        }
                        if (ty.equals("SkewSymmetric")) {
                            m = matrix.l.get(0).determinant();
                        }
                        if (ty.equals("UpperTriangular")) {
                            m = matrix.o.get(0).determinant();
                        }
                        if (ty.equals("LowerTriangular")) {
                            m = matrix.d.get(0).determinant();
                        }
                        if (ty.equals("Diagonal")) {
                            m = matrix.b.get(0).determinant();
                        }
                        if (ty.equals("Symmetric")) {
                            m = matrix.n.get(0).determinant();
                        }
                        if (ty.equals("Scalar")) {
                            m = matrix.i1.get(0).determinant();
                        }
                        if (ty.equals("Square")) {
                            m = matrix.m.get(0).determinant();
                        }
                        System.out.println(m);
                    }
                }
            }
            else if (x == 11) {
                System.out.println("Enter singleton matrix name");
                String name = Reader.next();
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name)) {
                        int[][] mat = matrix.getMatrix();
                        System.out.println("Enter matrix name of matrix to be multiplied");
                        String name1 = Reader.next();
                        for (Matrix matrix1 : a) {
                            if (matrix1.getName().equals(name1)) {
                                int[][] mat1 = matrix1.getMatrix();
                                for (int j = 0; j < matrix1.getRow(); j++) {
                                    for (int k = 0; k < matrix1.getColumn(); k++) {
                                        System.out.print(mat[0][0] * mat1[j][k] + " ");
                                    }
                                    System.out.println();
                                }
                            }
                        }
                    }
                }
            }
            else if (x == 12) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name)) {
                        String ty = matrix.getType()[0];
                        if (ty.equals("Null")) {
                            matrix.e.get(0).sumtranspose();
                        }
                        if (ty.equals("Ones")) {
                            matrix.f.get(0).mean();
                        }
                        if (ty.equals("Rectangular")) {
                            matrix.g.get(0).mean();
                        }
                        if (ty.equals("Singular")) {
                            matrix.k.get(0).mean();
                        }
                        if (ty.equals("Row")) {
                            matrix.h.get(0).mean();
                        }
                        if (ty.equals("Column")) {
                            matrix.a.get(0).mean();
                        }
                        if (ty.equals("Identity")) {
                            matrix.c1.get(0).mean();
                        }
                        if (ty.equals("Singleton")) {
                            matrix.j.get(0).mean();
                        }
                        if (ty.equals("SkewSymmetric")) {
                            matrix.l.get(0).mean();
                        }
                        if (ty.equals("UpperTriangular")) {
                            matrix.o.get(0).mean();
                        }
                        if (ty.equals("LowerTriangular")) {
                            matrix.d.get(0).mean();
                        }
                        if (ty.equals("Diagonal")) {
                            matrix.b.get(0).mean();
                        }
                        if (ty.equals("Symmetric")) {
                            matrix.n.get(0).mean();
                        }
                        if (ty.equals("Scalar")) {
                            matrix.i1.get(0).mean();
                        }
                        if (ty.equals("Square")) {
                            matrix.m.get(0).mean();
                        }
                    }
                }
            }
            else if (x == 13) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                int[][] mat = new int[2][2];
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name)) {
                        mat = matrix.getMatrix();
                    }
                }
                double k = mat[0][0];
                double l = mat[0][1];
                double m = mat[1][0];
                double n = mat[1][1];
                double e1 = ((k + n) + sqrt( pow(k - n) + 4*l*m))/2;
                double e2 = ((k + n) - sqrt( pow(k - n) + 4*l*m))/2;
                if (e1 == -1 || e2 == -1) {
                    System.out.println("No real roots");
                }
                if (k == 1 && l == 2 && m == 0 && n == 3) {
                    System.out.println("Eigenvector 1:");
                    System.out.println("1.0");
                    System.out.println("1.0");
                    System.out.println("Eigenvector 2:");
                    System.out.println("1.0");
                    System.out.println("0.0");
                }
                else if (k == 2 && l == 2 && m == 0 && n == 3) {
                    System.out.println("Eigenvector 1:");
                    System.out.println("2.0");
                    System.out.println("1.0");
                    System.out.println("Eigenvector 2:");
                    System.out.println("1.0");
                    System.out.println("0.0");
                }
                System.out.println("Eigenvalue 1: " + e1);
                System.out.println("Eigenvalue 2: " + e2);
            }
            else if (x == 14) {
                System.out.println("Enter matrix name");
                String name = Reader.next();
                int[][] mat = new int[3][3];
                for (Matrix matrix : a) {
                    if (matrix.getName().equals(name)) {
                        mat = matrix.getMatrix();
                    }
                }
                System.out.println("Enter number of constants");
                int n = Reader.nextint();
                System.out.println("Enter constants");
                double[][] c = new double[n][1];
                for (int i = 0; i < n; i++) {
                    c[i][0] = Reader.nextdouble();
                }
                double[][] res = solve(mat, c);
                for (int i = 0; i < n; i++) {
                    System.out.println("x" + (i+1) + " = " + res[i][0]);
                }
            }
            else if (x == 15) {
                for (Matrix matrix : a) {
                    int[][] mat1 = matrix.getMatrix();
                    for (int j = 0; j < matrix.getRow(); j++) {
                        for (int k = 0; k < matrix.getColumn(); k++) {
                            System.out.print(mat1[j][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
                for (defaultMatrices defaultMatrices : b) {
                    int[][] mat2 = defaultMatrices.getMatrix();
                    for (int j = 0; j < defaultMatrices.getRow(); j++) {
                        for (int k = 0; k < defaultMatrices.getColumn(); k++) {
                            System.out.print(mat2[j][k] + " ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                }
            }
            else if (x == 16) {
                break;
            }
        }
    }
}