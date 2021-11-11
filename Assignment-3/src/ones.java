class ones implements matrixfunctions{
    private final int r;
    private final int c;

    public ones( int r, int c) {
        this.r = r;
        this.c = c;
    }
    @Override
    public int determinant() {
        if (r == 1 && c == 1) {
            return 1;
        }
        else {
            return 0;
        }
    }

    @Override
    public void inverse() {
        if (r == 1 && c == 1) {
            System.out.println(1);
        }
        else {
            System.out.println("The inverse is not defined");
        }
    }

    @Override
    public void transpose() {
        System.out.println("This matrix is already the transpose of itself");
    }

    @Override
    public void mean() {
        System.out.println("The mean of the matrix is 1");
    }

    @Override
    public void sumtranspose() {
        System.out.println("This matrix will have all its elements as 2");
    }
}
