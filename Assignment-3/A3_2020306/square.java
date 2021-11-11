class square implements matrixfunctions{
    private final int[][] matrix;
    private final int r;
    private final int c;
    private final String name;

    public square(int[][] matrix, int r, int c, String name) {
        this.matrix = matrix;
        this.r = r;
        this.c = c;
        this.name = name;
    }
    @Override
    public int determinant() {
        if (r == 1 && c == 1) {
            return matrix[0][0];
        }
        else if (r == 2 && c == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        }
        else {
            int x, y, z, det;
            x = (matrix[1][1] * matrix[2][2]) - (matrix[2][1] * matrix[1][2]);
            y = (matrix[1][0] * matrix[2][2]) - (matrix[2][0] * matrix[1][2]);
            z = (matrix[1][0] * matrix[2][1]) - (matrix[2][0] * matrix[1][1]);
            det = (matrix[0][0] * x)- (matrix[0][1] * y) + (matrix[0][2] * z);
            return det;
        }
    }

    @Override
    public void inverse() {
        if (r == 2 && c == 2) {
            int det = determinant();
            double[][] mat = new double[2][2];
            mat[1][1] = matrix[0][0];
            mat[0][0] = matrix[1][1];
            mat[0][1] = -matrix[0][1];
            mat[1][0] = -matrix[1][0];
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++)
                    System.out.print((mat[i][j] / det) + " ");
                System.out.println();
            }
        }
        else if (r == 3 && c == 3) {
            int det = determinant();
            double[][] mat = new double[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    mat[i][j] = matrix[i][j];
                }
            }
            for(int i = 0; i < 3; i++) {
                for(int j = 0; j < 3; j++)
                    System.out.print((((mat[(j+1)%3][(i+1)%3] * mat[(j+2)%3][(i+2)%3]) - (mat[(j+1)%3][(i+2)%3] * mat[(j+2)%3][(i+1)%3]))/ det) + " ");
                System.out.println();
            }
        }
    }

    @Override
    public void transpose() {
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++)
                System.out.print(matrix[j][i] + " ");
            System.out.println();
        }
    }

    @Override
    public void mean() {
        System.out.println("column wise mean:");
        double[] mean1 = new double[c];
        for(int i = 0; i < c; i++){
            mean1[i] = 0.0;
            for(int j = 0; j < r; j++){
                mean1[i] += matrix[j][i];
            }
            mean1[i] /= r;
        }
        for (double v : mean1) {
            System.out.println(v);
        }
        System.out.println("row wise mean:");
        double[] mean2 = new double[c];
        for(int i = 0; i < r; i++){
            mean2[i] = 0.0;
            for(int j = 0; j < c; j++){
                mean2[i] += matrix[i][j];
            }
            mean2[i] /= c;
        }
        for (double v : mean2) {
            System.out.println(v);
        }
        System.out.println("mean of all elements:");
        double mean = 0.0;
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                mean += matrix[i][j];
            }
        }
        System.out.println(mean / (r*c));
    }

    @Override
    public void sumtranspose() {
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(matrix[i][j] + matrix[j][i] + " ");
            }
            System.out.println();
        }
    }
}
