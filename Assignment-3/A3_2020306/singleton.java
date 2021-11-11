class singleton implements matrixfunctions{
    private final int[][] matrix;
    private final int r;
    private final int c;
    private final String name;

    public singleton(int[][] matrix, int r, int c, String name) {
        this.matrix = matrix;
        this.r = r;
        this.c = c;
        this.name = name;
    }

    @Override
    public int determinant() {
        return matrix[0][0];
    }

    @Override
    public void inverse() {
        System.out.println(1);
    }

    @Override
    public void transpose() {
        System.out.println(matrix[0][0]);
    }

    @Override
    public void mean() {
        System.out.println("The mean is: " + matrix[0][0]);
    }

    @Override
    public void sumtranspose() {
        System.out.println(2*matrix[0][0]);
    }
}
