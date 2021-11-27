import java.util.*;
import java.io.*;
class Library {
    private final String name;
    private final long isbn, barcode;
    Library(String name1, long isbn1, long bar) {
        this.name = name1;
        this.isbn = isbn1;
        this.barcode = bar;
    }
    public String getName() {
        return this.name;
    }
    public long getIsbn() {
        return this.isbn;
    }
    public long getBarcode() {
        return this.barcode;
    }
    @Override // method of Object class
    public String toString() {
        return this.name + " " + this.isbn + " " + this.barcode;
    }
}
class sort implements Comparator<Library> {
    @Override // method of Comparator class
    public int compare(Library a, Library b) {
        int x = a.getName().compareTo(b.getName());
        int y = (int) (a.getIsbn() - b.getIsbn());
        int z = (int) (a.getBarcode() - b.getBarcode());
        if (x == 0) {
            if (y == 0) {
                return z;
            }
            return y;
        }
        return x;
    }
}
public class assgn4q1 {
    public static void main(String[] args) throws IOException {
        Reader.init();
        ArrayList<Library> lib = new ArrayList<>();
        System.out.print("Enter number of books: ");
        int n = Reader.nextint();
        System.out.print("Enter number of racks: ");
        int k = Reader.nextint();
        for (int i = 0; i < n; i++) {
            int f = 0;
            System.out.print("\nEnter title of book " + (i+1) + ": ");
            String title = Reader.next();
            System.out.print("Enter ISBN of book " + (i+1) + ": ");
            long isbn = Reader.nextlong();
            System.out.print("Enter barcode of book " + (i+1) + ": ");
            long barcode = Reader.nextlong();
            for (Library library : lib) {
                if (library.getBarcode() == barcode) {
                    System.out.println("Barcode already exists, add another book");
                    f = 1;
                    i--;
                    break;
                }
            }
            if (f == 0) {
                lib.add(new Library(title, isbn, barcode));
            }
        }
        lib.sort(new sort());
        System.out.println("\nSorted list of books:");
        for (Library library : lib) {
            System.out.println(library);
        }
        System.out.println();
        int r = n / k;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < r; j++) {
                System.out.println("Rack " + (i+1) + ", Slot " + (j+1) + ": " + lib.get(i*r+j));
            }
        }
    }
}