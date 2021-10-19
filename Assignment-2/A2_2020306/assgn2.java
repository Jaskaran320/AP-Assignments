import java.io.*;
import java.util.*;
interface assess{
    void viewassessment(int id);
}
interface comments{
    void addcomments(String s, java.util.Date dat, String na);
    void viewcomments();
}
interface material{
    void viewmaterials();
    void viewmaterials1();
}
class instructor{
    private int id;
    private String name;
    public void addins(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void printins(){
        System.out.println(id + " - " + name);
    }
    public String getname(){
        return name;
    }
}
class student{
    private int id, i = 0;
    private int[] marks;
    private int[] submitted = new int[2];
    private int[] graded = new int[2];
    private String name;
    private String[] submission = new String[2];
    private String[] insname = new String[2];
    public void addstud(int id, String name){
        this.id = id;
        this.name = name;
    }
    public void printstud(){
        System.out.println(id + " - " + name);
    }
    public int getid(){
        return id;
    }
    public String getname(){
        return name;
    }
    public void setsubmission(String submit, int id){
        this.submission[i] = submit;
        this.submitted[i] = id;
        this.i++;
    }
    public void setmarks(int mark, int i){
        marks[i] = mark;
    }
    public int[] getmarks(){
        return marks;
    }
    public String[] getsubmission(){
        return submission;
    }
    public int[] getsubmitted(){
        return submitted;
    }
    public void setgraded(int n, int i){
        this.graded[i] = n;
    }
    public int[] getgraded(){
        return graded;
    }
    public void setinsname(String nam, int j){
        this.insname[j] = nam;
    }
    public String[] getinsname(){
        return insname;
    }
}
class lecmaterial implements material{
    private String topic, topic1, name, name1, type, filename;
    private java.util.Date date, date1;
    int number;
    ArrayList<String> slid = new ArrayList<>();
    static ArrayList<lecmaterial> lecture = new ArrayList<>();
    public void addmat(String top, java.util.Date dat, String na, int num){
        this.topic = top;
        this.date = dat;
        this.name = na;
        this.number = num;
        this.type = "slide";
        lecture.add(this);
    }
    public void addmat(String top, java.util.Date dat, String na, String filena){
        this.topic1 = top;
        this.date1 = dat;
        this.name1 = na;
        this.filename = filena;
        this.type = "video";
        lecture.add(this);
    }
    @Override
    public void viewmaterials(){
        for(lecmaterial l: lecture){
            if (l.type.equals("slide")) {
                System.out.println("Title: " + l.topic);
                for (int i = 0; i < slid.size(); i++) {
                    System.out.println("Slide " + (i + 1) + ": " + slid.get(i));
                }
                System.out.println("Number of slides: " + l.number);
                System.out.println("Date of upload: " + l.date);
                System.out.println("Uploaded by: " + l.name);
            }
        }
        System.out.println("-------------------------------------------------------------");
    }
    @Override
    public void viewmaterials1(){
        for (lecmaterial l: lecture) {
            if (l.type.equals("video")) {
                System.out.println("Title of video: " + l.topic1);
                System.out.println("Video file: " + l.filename);
                System.out.println("Date of upload: " + l.date1);
                System.out.println("Uploaded by: " + l.name1);
            }
        }
        System.out.println("-------------------------------------------------------------");
    }
}
class assessment implements assess{
    private String string, string1, type;
    private int marks, id1, i = 0;
    private int open;
    static ArrayList<assessment> as = new ArrayList<>();
    public void addassess(String str, int ma){
        this.string = str;
        this.marks = ma;
        this.type = "assgn";
        this.open = 0;
        this.i++;
        as.add(this);
    }
    public void addassess(String str){
        this.string1 = str;
        this.type = "quiz";
        this.open = 0;
        this.i++;
        as.add(this);
    }
    @Override
    public void viewassessment(int id){
        this.id1 = id;
        for(assessment a: as) {
            if (a.type.equals("assgn")) {
                System.out.println("ID: " + id1 + " Assignment: " + a.string + " Max Marks: " + a.marks);
                System.out.println("-------------------------------------------------------------");

            }
            else if (a.type.equals("quiz")) {
                System.out.println("ID: " + id1 + " Question: " + a.string1);
                System.out.println("-------------------------------------------------------------");

            }
            id1++;
        }
    }
    public String gettype(){
        return type;
    }
    public int getmarks(){
        return marks;
    }
    public int getid(){
        return id1;
    }
    public void setclose(){
        this.open = 1;
    }
    public int getopen(){
        return open;
    }
}
class comment implements comments{
    static ArrayList<String> str = new ArrayList<>();
    static ArrayList<java.util.Date> d = new ArrayList<>();
    static ArrayList<String> name = new ArrayList<>();
    @Override
    public void addcomments(String s, java.util.Date dat, String na){
        str.add(s);
        d.add(dat);
        name.add(na);
    }
    @Override
    public void viewcomments(){
        for (int i = 0; i < str.size(); i++) {
            System.out.println(str.get(i) + " - " + name.get(i));
            System.out.println(d.get(i));
            System.out.println("-------------------------------------------------------------");
        }
    }
}
public class assgn2{
    public static void addinstructor(ArrayList<instructor> in, int id, String name){
        instructor ins = new instructor();
        ins.addins(id, name);
        in.add(ins);
    }
    public static void addstudent(ArrayList<student> st, int id, String name){
        student stu = new student();
        stu.addstud(id, name);
        st.add(stu);
    }
    public static void addcomment(String comm, java.util.Date date, String name){
        comments c = new comment();
        c.addcomments(comm, date, name);
    }
    public static void viewcomment(){
        comments c = new comment();
        c.viewcomments();
    }
    public static void addmat(String top, java.util.Date dat, String na, int num){
        lecmaterial lectu = new lecmaterial();
        lectu.addmat(top, dat, na, num);
    }
    public static void addmat(String top, java.util.Date dat, String na, String filena){
        lecmaterial lectu = new lecmaterial();
        lectu.addmat(top, dat, na, filena);
    }
    public static void addassess(String str, int ma){
        assessment assess = new assessment();
        assess.addassess(str, ma);
    }
    public static void addassess(String str){
        assessment assess = new assessment();
        assess.addassess(str);
    }
    public static void main(String[] args) throws IOException{
        ArrayList<instructor> in = new ArrayList<>();
        ArrayList<student> st = new ArrayList<>();
        Reader.init(System.in);
        addinstructor(in, 0, "I0");
        addinstructor(in, 1, "I1");
        addstudent(st, 0, "S0");
        addstudent(st, 1, "S1");
        addstudent(st, 2, "S2");
        lecmaterial lec = new lecmaterial();
        material lect = new lecmaterial();
        assess a1 = new assessment();
        while (true){
            System.out.println("Welcome to Backpack");
            System.out.println("1. Enter as instructor");
            System.out.println("2. Enter as student");
            System.out.println("3. Exit");
            int x = Reader.nextint();
            if (x == 1){
                System.out.println("Instructors:");
                for (instructor instructor : in) {
                    instructor.printins();
                }
                System.out.print("Choose ID: ");
                int id = Reader.nextint();
                String name = in.get(id).getname();
                while(true) {
                    System.out.println("Welcome " + name);
                    System.out.println("----------------------------------");
                    System.out.println("INSTRUCTOR MENU");
                    System.out.println("1. Add class material");
                    System.out.println("2. Add assessments");
                    System.out.println("3. View lecture materials");
                    System.out.println("4. View assessments");
                    System.out.println("5. Grade assessments");
                    System.out.println("6. Close assessment");
                    System.out.println("7. View comments");
                    System.out.println("8. Add comments");
                    System.out.println("9. Logout");
                    System.out.println("----------------------------------");
                    int y = Reader.nextint();
                    if (y == 1) {
                        System.out.println("1. Add Lecture Slide");
                        System.out.println("2. Add Lecture Video");
                        int z = Reader.nextint();
                        if (z == 1) {
                            System.out.print("Enter topic of slides: ");
                            String topic = Reader.nextline();
                            System.out.print("Enter number of slides: ");
                            int num = Reader.nextint();
                            String[] slides = new String[num];
                            System.out.println("Enter content of slides");
                            for (int i = 0; i < num; i++) {
                                System.out.print("Content of slide " + (i+1) + ": ");
                                slides[i] = Reader.nextline();
                                lec.slid.add(slides[i]);
                            }
                            long millis = System.currentTimeMillis();
                            java.util.Date date = new java.util.Date(millis);
                            addmat(topic, date, name, num);
                        }
                        else if (z == 2) {
                            System.out.print("Enter topic of video: ");
                            String topic = Reader.nextline();
                            System.out.print("Enter filename of video: ");
                            String filename = Reader.nextline();
                            String fi = filename.substring(filename.length()-4);
                            if (fi.equals(".mp4")){
                                long millis = System.currentTimeMillis();
                                java.util.Date date = new java.util.Date(millis);
                                addmat(topic, date, name, filename);
                            }
                            else{
                                System.out.println("Incorrect format");
                                break;
                            }
                        }
                    }
                    else if (y == 2){
                        System.out.println("1. Add Assignment");
                        System.out.println("2. Add Quiz");
                        int z = Reader.nextint();
                        if (z == 1){
                            System.out.print("Enter problem statement: ");
                            String prob = Reader.nextline();
                            System.out.print("Enter max marks: ");
                            int marks = Reader.nextint();
                            addassess(prob, marks);
                        }
                        else if (z == 2){
                            System.out.print("Enter quiz question: ");
                            String ques = Reader.nextline();
                            addassess(ques);
                        }
                    }
                    else if (y == 3){
                        lec.viewmaterials();
                        lect.viewmaterials1();
                    }
                    else if (y == 4){
                        a1.viewassessment(0);
                    }
                    else if (y == 5){
                        System.out.println("List of assessments");
                        System.out.print("Enter ID of assessment to view submissions: ");
                        int num = Reader.nextint();
                        System.out.println("Choose ID from these ungraded submissions");
                        for (student student : st) {
                            int[] arr = student.getsubmitted();
                            for (int i : arr) {
                                if (i == num)
                                    System.out.println(student.getid() + ". " + student.getname());
                            }
                        }
                        int num1 = Reader.nextint();
                        System.out.print("Submission: ");
                        String[] sub = st.get(num1).getsubmission();
                        System.out.print(sub[num]);
                        System.out.println("----------------------------------");
                        System.out.println("Max marks: " + assessment.as.get(num).getmarks());
                        System.out.print("Marks scored: ");
                        int mark = Reader.nextint();
                        st.get(id).setmarks(mark, num);
                        st.get(id).setgraded(1, num);
                        st.get(id).setinsname(name, num);
                    }
                    else if (y == 6){
                        System.out.println("List of Open Assignments:");
                        for (int i = 0; i < assessment.as.size(); i++) {
                            if (assessment.as.get(i).getopen() == 0){
                                a1.viewassessment(0);
                            }
                        }
                        System.out.print("Enter id of assignment to close: ");
                        int id1 = Reader.nextint();
                        assessment.as.get(id1).setclose();
                    }
                    else if (y == 7)
                        viewcomment();
                    else if (y == 8){
                        System.out.print("Enter comment: ");
                        String comm = Reader.nextline();
                        long millis = System.currentTimeMillis();
                        java.util.Date date = new java.util.Date(millis);
                        addcomment(comm, date, name);
                    }
                    else if (y == 9)
                        break;
                    else{
                        System.out.println("Invalid input");
                        break;
                    }
                }
            }
            else if (x == 2){
                System.out.println("Students:");
                for (student student : st) {
                    student.printstud();
                }
                System.out.print("Choose ID: ");
                int id = Reader.nextint();
                String name = st.get(id).getname();
                while (true){
                    System.out.println("Welcome " + name);
                    System.out.println("----------------------------------");
                    System.out.println("STUDENT MENU");
                    System.out.println("1. View lecture materials");
                    System.out.println("2. View assessments");
                    System.out.println("3. Submit assessment");
                    System.out.println("4. View grades");
                    System.out.println("5. View comments");
                    System.out.println("6. Add comments");
                    System.out.println("7. Logout");
                    System.out.println("----------------------------------");
                    int y = Reader.nextint();
                    if (y == 1) {
                        lec.viewmaterials();
                        lect.viewmaterials1();
                    }
                    else if (y == 2) {
                        a1.viewassessment(0);
                    }
                    else if (y == 3) {
                        System.out.println("Pending assessments");
                        int[] sub = st.get(id).getsubmitted();
                        a1.viewassessment(0);
                        for (int i = 0; i < assessment.as.size(); i++) {
                            for (int k : sub) {
                                if (assessment.as.get(i).getid() != k)
                                    a1.viewassessment(0);
                            }
                        }
                        System.out.print("Enter ID of assessment: ");
                        int inp = Reader.nextint();
                        for (int i = 0; i < assessment.as.size(); i++) {
                            if (Objects.equals(assessment.as.get(inp).gettype(), "assgn")) {
                                System.out.print("Enter filename of assignment: ");
                                String filename = Reader.next();
                                String fi = filename.substring(filename.length() - 4);
                                if (fi.equals(".zip")) {
                                    for (student student : st) {
                                        if (student.getid() == id) {
                                            student.setsubmission(filename, inp);
                                            student.setgraded(0, inp);
                                        }
                                    }
                                } else {
                                    System.out.println("Incorrect format");
                                    break;
                                }
                            }
                            else if (Objects.equals(assessment.as.get(inp).gettype(), "quiz")) {
                                System.out.print(assessment.as.get(inp));
                                String ans = Reader.next();
                                for (student student : st) {
                                    if (student.getid() == id) {
                                        student.setsubmission(ans, inp);
                                        student.setgraded(0, inp);
                                    }
                                }
                            }
                        }
                    }
                    else if (y == 4) {
                        System.out.println("Graded submissions");
                        int[] grade = st.get(id).getgraded();
                        String[] sub = st.get(id).getsubmission();
                        int[] marks = st.get(id).getmarks();
                        String[] insname = st.get(id).getinsname();
                        for (int i = 0; i < grade.length; i++) {
                            if (grade[i] == 1) {
                                System.out.println("Submission: " + sub[i]);
                                System.out.println("Marks scored: " + marks[i]);
                                System.out.println("Graded by: " + insname[i]);
                            }
                        }
                        System.out.println();
                        System.out.println("Ungraded Submissions");
                        for (int i = 0; i < grade.length; i++) {
                            if (grade[i] == 0){
                                System.out.println("Submission: " + sub[i]);
                            }
                        }
                    }
                    else if (y == 5)
                        viewcomment();
                    else if (y == 6) {
                        System.out.print("Enter comment: ");
                        String comm = Reader.nextline();
                        long millis = System.currentTimeMillis();
                        java.util.Date date = new java.util.Date(millis);
                        addcomment(comm, date, name);
                    }
                    else if (y == 7)
                        break;
                    else {
                        System.out.println("Invalid input");
                        break;
                    }
                }
            }
            else if ( x== 3) {
                System.out.println("------------------------------------------------------------------------");
                System.out.println("{End of Test Case}");
                break;
            }
            else {
                System.out.println("Invalid Input");
                break;
            }
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