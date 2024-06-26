class rectangular implements matrixfunctions{
    private final int[][] matrix;
    private final int r;
    private final int c;

    public rectangular(int[][] matrix, int r, int c) {
        this.matrix = matrix;
        this.r = r;
        this.c = c;
    }

    @Override
    public int determinant() {
        System.out.println("Determinant is not defined");
        return 0;
    }

    @Override
    public void inverse() {
        System.out.println("The inverse is not defined");
    }

    @Override
    public void transpose() {
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(matrix[j][i] + " ");
            }
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
        System.out.println("Not possible");
    }
}
