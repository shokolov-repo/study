package students;

/**
 * Created by compik on 7/18/15.
 */
public class Main {
    public static void main(String[] args) {

        Student st1 = new Student();
        st1.setAge(15);
        st1.setName("Dimitrius");

        Student st2 = new Student(18, "Joseph");

        System.out.println("Student " + st1.getName() + " age= " + st1.getAge());
        System.out.println("Student " + st2.getName() + " age= " + st2.getAge());

        Student petro = new LazyStudent(20, "Petro", 8);
        System.out.println(petro);

    }
}
