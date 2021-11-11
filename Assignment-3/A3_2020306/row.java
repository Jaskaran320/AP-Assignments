class row implements matrixfunctions{
    private final int[][] matrix;
    private final int r;
    private final int c;
    private final String name;

    public row(int[][] matrix, int r, int c, String name) {
        this.matrix = matrix;
        this.r = r;
        this.c = c;
        this.name = name;
    }
    @Override
    public int determinant() {
        System.out.println("Determinant is not defined");
        return 0;
    }

    @Override
    public void inverse() {
        System.out.println("Inverse is not defined");
    }

    @Override
    public void transpose() {
        for(int i = 0; i < c; i++){
            for(int j = 0; j < r; j++) {
                System.out.println(matrix[j][i]);
            }
            System.out.println();
        }
    }

    @Override
    public void mean() {
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
    }

    @Override
    public void sumtranspose() {
        System.out.println("Not possible");
    }
}
