class identity implements matrixfunctions{
    private final int[][] matrix;
    private final int r;
    private final int c;

    public identity(int[][] matrix, int r, int c) {
        this.matrix = matrix;
        this.r = r;
        this.c = c;
    }
    @Override
    public int determinant() {
        return 1;
    }

    @Override
    public void inverse() {
        System.out.println("This matrix is already the inverse of itself");
    }

    @Override
    public void transpose() {
        System.out.println("This matrix is already the transpose of itself");
    }

    @Override
    public void mean() {
        System.out.println("Mean of every column is 1");
        System.out.println("Mean of every column is 1");
        System.out.println("Mean of all elements is 1");
    }

    @Override
    public void sumtranspose() {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(2*matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}
