import Config.FactoryConfiguration;
import Entity.Laptop;
import Entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Student student = new Student();
        student.setId("11e");
        student.setName("Randika");
        student.setAddress("Medagama");

        Student student1 = new Student();
        student1.setId("11e22");
        student1.setName("Randika");
        student1.setAddress("Medagama");

        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);

        Laptop laptop1 = new Laptop();
        laptop1.setId("10111");
        laptop1.setModel("woow");
        laptop1.setStudents(students);

        Laptop laptop2 = new Laptop();
        laptop2.setId("1011111");
        laptop2.setModel("woo1");
        laptop2.setStudents(students);

        List<Laptop> laptops = new ArrayList<>();
        laptops.add(laptop1);
        laptops.add(laptop2);

        student.setLaptops(laptops);

        Session session = FactoryConfiguration.getInstance().getSession();
        Transaction transaction = session.beginTransaction();


            for (Student stu : students) {
                session.save(stu);
            }

            for (Laptop laptop : laptops) {
                session.save(laptop);
            }

            transaction.commit();

            session.close();

    }
}
