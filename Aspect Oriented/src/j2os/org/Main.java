package j2os.org;

public class Main {
    public static void main(String[] args) {
        Student student= (Student) Spring.getBean("student");
        student.a();
        student.b();
    }


}
