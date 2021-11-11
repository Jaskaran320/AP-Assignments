class singleton implements matrixfunctions{
    private final int[][] matrix;

    public singleton(int[][] matrix) {
        this.matrix = matrix;
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
