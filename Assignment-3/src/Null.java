class Null implements matrixfunctions{

    public Null() {}
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
