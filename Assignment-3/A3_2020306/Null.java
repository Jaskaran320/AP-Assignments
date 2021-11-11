class Null implements matrixfunctions{
    private final int[][] matrix;
    private final int r;
    private final int c;
    private final String name;

    public Null(int[][] matrix, int r, int c, String name) {
        this.matrix = matrix;
        this.r = r;
        this.c = c;
        this.name = name;
    }
    @Override
    public int determinant() {
        return 0;
    }

    @Override
    public void inverse() {
        System.out.println("The inverse is not defined");
    }

    @Override
    public void transpose() {
        System.out.println("This matrix is already the transpose of itself");
    }

    @Override
    public void mean() {
        System.out.println("The mean is 0");
    }

    @Override
    public void sumtranspose() {
        System.out.println("This will result in the same matrix");
    }
}
