import java.io.*;
import java.util.*;
class vaccine {
    int dose, gap;
    String name;
    public void newvac(int d, int g, String n){
        this.dose = d;
        this.gap = g;
        this.name = n;
    }
    public void printvac(){
        System.out.println("Vaccine Name: " + name + ", Number of Doses: " + dose + ", Gap Between Doses: " + gap);
    }
    public String getvac(){
        return name;
    }
    public int getdose(){
        return dose;
    }
    public int getgap(){
        return gap;
    }
}
class hospital {
    String name;
    int pin, id1;
    public void newhos(String n, int p, int id){
        this.name = n;
        this.pin = p;
        this.id1 = id;
    }
    public void printhos(){
        System.out.println("Hospital Name: " + name + ", PinCode: " + pin + ", Unique ID " + id1);
    }
    public int getpin(){
        return pin;
    }
    public int getid1(){
        return id1;
    }
    public String gethosname(){
        return name;
    }
    public void allhos(){
        System.out.println(id1 + " " + name);
    }
    String[] vacname = new String[2];
    public void setvacname(String vac, int k){
        this.vacname[k] = vac;
    }
    public String[] getvacname(){
        return vacname;
    }
}
class citizen extends vaccine{
    String name, vaccine;
    int age, due = 0, doses = 0, qnty, dose2, gap2;
    long id2;
    public void newcit(String n, int a, long id){
        this.name = n;
        this.age = a;
        this.id2 = id;
    }
    public void printcit(String n, int a, long id){
        System.out.println("Citizen Name: " + n + ", Age: " + a + ", Unique ID: " + id);
    }
    public long getid(){
        return id2;
    }
    public String getname(){
        return name;
    }
    public void vacstatus(int day, String vac, int qty, int dose1, int gap1){
        this.gap2 = gap1;
        this.due = day + gap2;
        this.doses += 1;
        vaccine = vac;
        qnty = qty;
        this.qnty--;
        this.dose2 = dose1;
    }
    public String getvaccine(){
        return vaccine;
    }
    public int getdoses(){
        return doses;
    }
    public int getdue(){
        return due;
    }
    public int getdose1(){
        return dose2;
    }
    public int getgap(){
        return gap2;
    }
}
class slotcreate {
    int id3, day, qty;
    String vacname;
    public void newslot(int id, int d, int q, String vac){
        this.id3 = id;
        this.day = d;
        this.qty = q;
        this.vacname = vac;
    }
    public void printslot(){
        System.out.println("Slot added by Hospital: " + id3 + " for Day: " + day + ", Available Quantity: " + qty + " of Vaccine: " + vacname);
    }
    public void allslots(){
        System.out.println("Day: " + day + " Vaccine: " + vacname + " Available Qty: " + qty);
    }
    public void allslots1(int i){
        System.out.println(i + "-> Day: " + day + " Available Qty: " + qty + " Vaccine: " + vacname);
    }
    public int getslotid(){
        return id3;
    }
    public int getday(){
        return day;
    }
    public int getqty(){
        return qty;
    }
    public void setday(int due){
        this.day = due;
    }
}

public class assgn{
    static int id1 = 100000;
    public static void addvaccine(ArrayList<vaccine> a, int dose, int gap, String name){
        vaccine vac = new vaccine();
        vac.newvac(dose, gap, name);
        a.add(vac);
        vac.printvac();
    }
    public static void reghospital(ArrayList<hospital> b, String name, int pin){
        hospital hos = new hospital();
        hos.newhos(name, pin, id1);
        b.add(hos);
        hos.printhos();
        id1++;
    }
    public static void regcitizen(ArrayList<citizen> c, String name, int age, long id){
        citizen cit = new citizen();
        if ( age > 18){
            cit.newcit(name, age, id);
            c.add(cit);
            cit.printcit(name, age, id);
        }
        else{
            cit.printcit(name, age, id);
            System.out.println("Only above 18 are allowed");
        }
    }
    public static void newslotcreate(ArrayList<slotcreate> d, int id, int day, int qty, String vacname){
        slotcreate slot = new slotcreate();
        slot.newslot(id, day, qty, vacname);
        d.add(slot);
        slot.printslot();
    }
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        System.out.println("CoWin Portal initialized....");
        System.out.println("---------------------------------");
        int vaccines = 0;
        ArrayList<vaccine> a = new ArrayList<>();
        ArrayList<hospital> b = new ArrayList<>();
        ArrayList<citizen> c = new ArrayList<>();
        ArrayList<slotcreate> d = new ArrayList<>();
        while (true){
            System.out.println("1. Add Vaccine");
            System.out.println("2. Register Hospital");
            System.out.println("3. Register Citizen");
            System.out.println("4. Add Slot for Vaccination");
            System.out.println("5. Book Slot for Vaccination");
            System.out.println("6. List all slots for a hospital");
            System.out.println("7. Check Vaccination Status");
            System.out.println("8. Exit");
            System.out.println("---------------------------------");
            int x = Reader.nextint();
            if (x == 1){
                System.out.print("Vaccine Name: ");
                String name = Reader.next();
                System.out.print("Number of Doses: ");
                int dose = Reader.nextint();
                System.out.print("Gap between Doses: ");
                int gap = Reader.nextint();
                int flag = 0;
                for (int i = 0; i < a.size(); i++){
                    if (Objects.equals(name, a.get(i).getvac()))
                        flag++;
                }
                if (flag == 0) {
                    addvaccine(a, dose, gap, name);
                    vaccines++;
                }
                else
                    System.out.println("Vaccine already registered");
                System.out.println("---------------------------------");
            }
            else if (x == 2){
                System.out.print("Hospital Name: ");
                String name = Reader.next();
                System.out.print("PinCode: ");
                int pin = Reader.nextint();
                int flag = 0;
                for (int i = 0; i < b.size(); i++){
                    if (Objects.equals(name, b.get(i).gethosname()))
                        flag++;
                }
                if (flag == 0)
                    reghospital(b, name, pin);
                else
                    System.out.println("Hospital already registered");
                System.out.println("---------------------------------");
            }
            else if (x == 3){
                System.out.print("Citizen Name: ");
                String name = Reader.next();
                System.out.print("Age: ");
                int age = Reader.nextint();
                System.out.print("Unique ID: ");
                long id = Reader.nextlong();
                int flag = 0;
                for (int i = 0; i < c.size(); i++){
                    if (id == c.get(i).getid())
                        flag++;
                }
                if (flag == 0)
                    regcitizen(c, name, age, id);
                else
                    System.out.println("ID is not unique");
                System.out.println("---------------------------------");
            }
            else if (x == 4){
                System.out.print("Enter Hospital ID: ");
                int id = Reader.nextint();
                int flag = 0;
                for (int i = 0; i < b.size(); i++){
                    if (id == b.get(i).getid1()){
                        flag++;
                        System.out.print("Enter number of Slots to be added: ");
                        int n = Reader.nextint();
                        for (int j = 0; j < n; j++){
                            System.out.print("Enter Day number: ");
                            int day = Reader.nextint();
                            System.out.print("Enter Quantity: ");
                            int qty = Reader.nextint();
                            System.out.println("Select Vaccine");
                            for (int k = 0; k < vaccines; k++){
                                System.out.println(k + ". " + a.get(k).getvac());
                            }
                            int vacid = Reader.nextint();
                            String vacname = a.get(vacid).getvac();
                            newslotcreate(d, id, day, qty, vacname);
                            for (int k = 0; k < b.size(); k++){
                                if (id == b.get(k).getid1()){
                                    b.get(k).setvacname(vacname, j);
                                }
                            }
                        }
                    }
                }
                if (flag == 0)
                    System.out.println("Hospital not found");
                System.out.println("---------------------------------");
            }
            else if (x == 5){
                System.out.print("Enter Patient Unique ID: ");
                long id = Reader.nextlong();
                for (int i = 0; i < c.size(); i++){
                    if (id == c.get(i).getid()){
                        System.out.println("1. Search by area");
                        System.out.println("2. Search by Vaccine");
                        System.out.println("3. Exit");
                        System.out.print("Enter option: ");
                        int y = Reader.nextint();
                        int flag = 0, flag1 = 0, flag2 = 0, flag3 = 0, flag5 = 0;
                        if (y == 1){
                            System.out.print("Enter PinCode: ");
                            int pin = Reader.nextint();
                            for (int j = 0; j < b.size(); j++) {
                                if (pin == b.get(j).getpin()) {
                                    b.get(j).allhos();
                                    flag++;
                                }
                            }
                            if (flag == 0) {
                                System.out.println("No hospitals in this area");
                                break;
                            }
                            System.out.print("Enter Hospital ID: ");
                            int hosid = Reader.nextint();
                            int m = 0;
                            for (int j = 0; j < b.size(); j++){
                                if (hosid == b.get(j).getid1()){
                                    m = j;
                                    break;
                                }
                            }
                            if(d.get(m).getday() < c.get(m).getdue()){
                                System.out.println("No slots available");
                                break;
                            }
                            for (int k = 0; k < d.size(); k++){
                                if (hosid == d.get(k).getslotid()) {
                                    d.get(k).allslots1(k);
                                    flag1++;
                                }
                            }
                            if (flag1 == 0){
                                System.out.println("No slots added");
                                break;
                            }
                            System.out.print("Choose Slot: ");
                            int z = Reader.nextint();
                            if (c.get(i).getdoses() > 0){
                                d.get(i).setday(c.get(i).getdue());
                            }
                            if (c.get(z).getdoses() == 0 && d.get(z).getqty() > 0){
                                System.out.println(c.get(i).getname() + " vaccinated with " + a.get(z).getvac());
                                c.get(i).vacstatus(d.get(z).getday(), a.get(z).getvac(), d.get(z).getqty(), a.get(z).getdose(), a.get(z).getgap());
                                flag2++;
                            }
                            if (d.get(z).getqty() > 0 && c.get(z).getdoses() != a.get(z).getdose() && d.get(z).getday() >= c.get(z).getdue() && Objects.equals(c.get(z).getvaccine(), a.get(z).getvac())){
                                System.out.println(c.get(i).getname() + " vaccinated with " + a.get(z).getvac());
                                c.get(i).vacstatus(d.get(z).getday(), a.get(z).getvac(), d.get(z).getqty(), a.get(z).getdose(), a.get(z).getgap());
                                d.get(z).setday(c.get(z).getdue());
                                flag2++;
                            }
                            if(flag2 == 0)
                                System.out.println("Vaccine not due yet or Incorrect vaccine chosen or already vaccinated or vaccines finished");
                        }
                        else if (y == 2){
                            System.out.print("Enter Vaccine name: ");
                            String vacc = Reader.next();
                            String[] va;
                            for (int k = 0; k < b.size(); k++){
                                for (int w = 0; w < b.get(k).getvacname().length; w++){
                                    va = b.get(k).getvacname();
                                    if (Objects.equals(vacc, va[w])){
                                        b.get(k).allhos();
                                        flag3++;
                                    }
                                }
                            }
                            if (flag3 == 0){
                                System.out.println("No slots added");
                                break;
                            }
                            System.out.print("Enter Hospital ID: ");
                            int hosid = Reader.nextint();
                            int m = 0;
                            for (int j = 0; j < b.size(); j++){
                                if (hosid == b.get(j).getid1()){
                                    m = j;
                                    break;
                                }
                            }
                            if (m == 1) {
                                m--;
                                d.get(m).setday(c.get(m).getdue());
                            }
                            if(d.get(m).getday() < c.get(m).getdue()){
                                System.out.println("No slots available");
                                break;
                            }
                            for (int k = 0; k < d.size(); k++) {
                                if (hosid == d.get(k).getslotid()) {
                                    d.get(k).allslots1(k);
                                    flag1++;
                                }
                            }
                            System.out.print("Choose Slot: ");
                            int z = Reader.nextint();
                            if (z == 2)
                                z-=2;
                            if (c.get(i).getdoses() > 0){
                                d.get(i).setday(c.get(i).getdue());
                            }
                            if (c.get(z).getdoses() == 0 && d.get(z).getqty() > 0){
                                System.out.println(c.get(i).getname() + " vaccinated with " + a.get(z).getvac());
                                c.get(i).vacstatus(d.get(z).getday(), a.get(z).getvac(), d.get(z).getqty(), a.get(z).getdose(), a.get(z).getgap());
                                flag5++;
                            }
                            if (d.get(z).getqty() > 0 && c.get(z).getdoses() != a.get(z).getdose() && d.get(z).getday() >= c.get(z).getdue() && Objects.equals(c.get(z).getvaccine(), a.get(z).getvac())){
                                System.out.println(c.get(i).getname() + " vaccinated with " + a.get(z).getvac());
                                c.get(i).vacstatus(d.get(z).getday(), a.get(z).getvac(), d.get(z).getqty(), a.get(z).getdose(), a.get(z).getgap());
                                d.get(z).setday(c.get(z).getdue());
                                flag5++;
                            }
                            if(flag5 == 0)
                                System.out.println("Vaccine not due yet or Incorrect vaccine chosen or already vaccinated or vaccines finished");
                        }
                        else if (y == 3)
                            break;
                    }
                    else
                        System.out.println("Patient not found");
                }
                System.out.println("---------------------------------");
            }
            else if (x == 6){
                System.out.print("Enter Hospital ID: ");
                int id1 = Reader.nextint();
                int flag = 0;
                for (int i = 0; i < d.size(); i++){
                    if (id1 == d.get(i).getslotid()){
                        d.get(i).allslots();
                        flag++;
                    }
                }
                if (flag == 0)
                    System.out.println("No slots added");
                System.out.println("---------------------------------");
            }
            else if (x == 7){
                System.out.print("Enter Patient Unique ID: ");
                long id4 = Reader.nextlong();
                int flag = 0;
                for (int i = 0; i < c.size(); i++){
                    if (id4 == c.get(i).getid()){
                        if (c.get(i).getdoses() == 0){
                            System.out.println("Citizen REGISTERED");
                        }
                        else if (c.get(i).getdoses() < c.get(i).getdose1()){
                            System.out.println("PARTIALLY VACCINATED");
                            System.out.println("Vaccine Given: " + c.get(i).getvaccine());
                            System.out.println("Number of Doses given: " + c.get(i).getdoses());
                            System.out.println("Next Dose due date: " + c.get(i).getdue());
                        }
                        else if (c.get(i).getdoses() == c.get(i).getdose1()){
                            System.out.println("FULLY VACCINATED");
                            System.out.println("Vaccine Given: " + c.get(i).getvaccine());
                            System.out.println("Number of Doses given: " + c.get(i).getdoses());
                        }
                        flag++;
                    }
                }
                if (flag == 0)
                    System.out.println("Patient not found");
                System.out.println("---------------------------------");
            }
            else if (x == 8)
                break;
            else
                System.out.println("Invalid Input");
        }
    }
}
class Reader{

    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static String nextline() throws IOException {
        return reader.readLine();
    }


    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TO DO add check for eof if necessary
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextint() throws IOException {
        return Integer.parseInt( next() );
    }

    static long nextlong() throws IOException {
        return Long.parseLong( next() );
    }

    static double nextdouble() throws IOException {
        return Double.parseDouble( next() );
    }

    static float nextfloat() throws IOException {
        return Float.parseFloat( next() );
    }

    static Boolean nextboolean() throws IOException {
        return Boolean.parseBoolean( next() );
    }
}