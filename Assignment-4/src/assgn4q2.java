import java.io.*;
import java.util.*;
abstract class matrix {
    abstract String getName();
    abstract int getRow();
    abstract int getCol();
    abstract <T> T getMatrix();
    abstract void create();
    abstract <T> void update(T obj);
    abstract void display();
}
class RGB extends matrix {
    private final int m, n;
    private int[][][] matrix;
    private final String name;
    RGB(int[][][] rgb, int m, int n, String na){
        this.matrix = rgb;
        this.m = m;
        this.n = n;
        this.name = na;
    }
    @Override
    void create(){
        int[][][] mat = new int[3][m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                mat[0][i][j] = (int)(Math.random() * 256);
                mat[1][i][j] = (int)(Math.random() * 256);
                mat[2][i][j] = (int)(Math.random() * 256);
            }
        }
        this.matrix = mat;
    }
    @Override
    <T> void update(T mat){
        this.matrix = (int[][][])mat;
    }
    @Override
    void display(){
        System.out.println(this.name + ":");
        System.out.println("Red");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[0][i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Green");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[1][i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("Blue");
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                System.out.print(matrix[2][i][j] + " ");
            }
            System.out.println();
        }
    }
    @Override
    <T> T getMatrix(){
        return (T)this.matrix;
    }
    @Override
    String getName(){
        return this.name;
    }
    @Override
    int getRow(){
        return this.m;
    }
    @Override
    int getCol(){
        return this.n;
    }
}
class grayscale extends matrix {
    private final int m, n;
    private int[][] matrix;
    private final String name;
    grayscale(int [][] mat, int r, int c, String n) {
        this.matrix = mat;
        this.m = r;
        this.n = c;
        this.name = n;
    }
    @Override
    void create() {
        int [][] mat = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = (int)(Math.random() * 256);
            }
        }
        this.matrix = mat;
    }
    @Override
    <T> void update ( T mat) {
        this.matrix = (int[][]) mat;
    }
    @Override
    void display() {
        System.out.println(this.name + ":");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    <T> T getMatrix(){
        return (T)this.matrix;
    }
    @Override
    String getName(){
        return this.name;
    }
    @Override
    int getRow(){
        return this.m;
    }
    @Override
    int getCol(){
        return this.n;
    }
}

public class assgn4q2 {
    static<T extends matrix> void Negatives(T obj, int m, int n){
        if (obj.getClass() == grayscale.class){
            int[][] matrix= obj.getMatrix();
            for (int i = 0;i < m; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(255-matrix[i][j] + " ");
                }
                System.out.println();
            }
        }
        else if (obj.getClass() == RGB.class){
            int[][][] matrix = obj.getMatrix();
            int[][] red = matrix[0];
            int[][] green = matrix[1];
            int[][] blue = matrix[2];
            System.out.println("Negative of Red:");
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(255 - red[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("Negative of Green:");
            for (int i = 0; i < m; i++){
                for (int j = 0; j < n; j++){
                    System.out.print(255 - green[i][j]+" ");
                }
                System.out.println();
            }
            System.out.println("Negative of Blue:");
            for (int i = 0; i < m; i++){
                for (int j = 0;j < n; j++){
                    System.out.print(255 - blue[i][j]+" ");
                }
                System.out.println();
            }
        }
        else {
            System.out.println("Type does not match");
        }
    }
    public static void main(String[] args) throws IOException {
        ArrayList<RGB> rgb = new ArrayList<>();
        ArrayList<grayscale> gray = new ArrayList<>();
        Map <String, matrix> map = new HashMap<>();
        Reader.init();
        while(true) {
            System.out.println("1. Enter matrix");
            System.out.println("2. Create matrix");
            System.out.println("3. Update matrix");
            System.out.println("4. Display matrix");
            System.out.println("5. Compute negatives");
            System.out.println("6. Exit");
            int x = Reader.nextint();
            if(x == 1) {
                System.out.print("Enter name of matrix: ");
                String name = Reader.next();
                System.out.print("Enter number of rows: ");
                int r = Reader.nextint();
                System.out.print("Enter number of columns: ");
                int c = Reader.nextint();
                System.out.println("1. Grayscale");
                System.out.println("2. RGB");
                System.out.print("Enter choice: ");
                int y = Reader.nextint();
                if (y == 1) {
                    System.out.println("Enter grayscale values");
                    int[][] mat = new int[r][c];
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            mat[i][j] = Reader.nextint();
                        }
                    }
                    grayscale g = new grayscale(mat, r, c, name);
                    gray.add(g);
                    map.put(name, g);
                }
                else if (y == 2) {
                    int[][][] mat = new int[3][r][c];
                    System.out.println("Enter Red values");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            mat[0][i][j] = Reader.nextint();
                        }
                    }
                    System.out.println("Enter Green values");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            mat[1][i][j] = Reader.nextint();
                        }
                    }
                    System.out.println("Enter Blue values");
                    for (int i = 0; i < r; i++) {
                        for (int j = 0; j < c; j++) {
                            mat[2][i][j] = Reader.nextint();
                        }
                    }
                    RGB rg = new RGB(mat, r, c, name);
                    rgb.add(rg);
                    map.put(name, rg);
                }
            }
            else if(x == 2) {
                System.out.print("Enter name of matrix: ");
                String name = Reader.next();
                System.out.print("Enter number of rows: ");
                int r = Reader.nextint();
                System.out.print("Enter number of columns: ");
                int c = Reader.nextint();
                System.out.println("1. Grayscale");
                System.out.println("2. RGB");
                System.out.print("Enter choice: ");
                int y = Reader.nextint();
                if (y == 1) {
                    int[][] mat = new int[r][c];
                    grayscale g = new grayscale(mat, r, c, name);
                    g.create();
                    gray.add(g);
                    map.put(name, g);
                }
                else if (y == 2) {
                    int[][][] mat = new int[3][r][c];
                    RGB rgb1 = new RGB(mat, r, c, name);
                    rgb1.create();
                    rgb.add(rgb1);
                    map.put(name, rgb1);
                }
            }
            else if(x == 3) {
                System.out.print("Enter name of matrix: ");
                String name = Reader.next();
                for (grayscale grayscale : gray) {
                    if (grayscale.getName().equals(name)) {
                        int r = grayscale.getRow();
                        int c = grayscale.getCol();
                        int[][] mat = new int[r][c];
                        System.out.println("Enter grayscale values");
                        for (int i = 0; i < r; i++) {
                            for (int j = 0; j < c; j++) {
                                mat[i][j] = Reader.nextint();
                            }
                        }
                        grayscale.update(mat);
                    }
                    else if (!grayscale.getName().equals(name)) {
                        for (RGB rgb1 : rgb) {
                            if (rgb1.getName().equals(name)) {
                                int r = rgb1.getRow();
                                int c = rgb1.getCol();
                                int[][][] mat = new int[3][r][c];
                                System.out.println("Enter Red values");
                                for (int i = 0; i < r; i++) {
                                    for (int j = 0; j < c; j++) {
                                        mat[0][i][j] = Reader.nextint();
                                    }
                                }
                                System.out.println("Enter Green values");
                                for (int i = 0; i < r; i++) {
                                    for (int j = 0; j < c; j++) {
                                        mat[1][i][j] = Reader.nextint();
                                    }
                                }
                                System.out.println("Enter Blue values");
                                for (int i = 0; i < r; i++) {
                                    for (int j = 0; j < c; j++) {
                                        mat[2][i][j] = Reader.nextint();
                                    }
                                }
                                rgb1.update(mat);
                            }
                        }
                    }
                    else{
                        System.out.println("Matrix not found");
                    }
                }
            }
            else if(x == 4) {
                for (grayscale grayscale : gray) {
                    grayscale.display();
                }
                for (RGB rgb1 : rgb) {
                    rgb1.display();
                }
            }
            else if(x == 5) {
                System.out.print("Enter name of matrix: ");
                String name = Reader.next();
                if (map.containsKey(name)) {
                    matrix i = map.get(name);
                    Negatives(i, map.get(name).getRow(), map.get(name).getCol());
                }
            }
            else if(x == 6) {
                break;
            }
        }
    }
}